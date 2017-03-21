package org.swinglife.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import org.swinglife.model.User;
import org.swinglife.service.AccountService;

/****
 * �û���¼Controller
 * 
 * @author Swinglife
 * 
 */
@Controller
public class LoginController {

	/***
	 * ��ת����¼ҳ��
	 * 
	 * @return
	 */
	@RequestMapping(value = "toLogin")
	public String toLogin() {
		// ��ת��/page/login.jspҳ��
		return "login";
	}

	/***
	 * ʵ���û���¼
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String Login(String username, String password) {
		User user = accountService.getUserByUserName(username);
		if (user == null) {
			return "error";
		}
		if (!user.getPassword().equals(password)) {
			return "error";
		}
		// ��¼���Ž�shiro token
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		System.out.println("��¼�ɹ�");
		return "redirect:/home";
	}

	// �����û�ҵ����
	@Autowired
	private AccountService accountService;
}
