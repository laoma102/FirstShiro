package org.swinglife.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.swinglife.dao.BaseDao;
import org.swinglife.model.Permission;
import org.swinglife.model.Role;
import org.swinglife.model.User;
import org.swinglife.model.UserRole;

/****
 * �û�Service
 * 
 * @author Swinglife
 * 
 */
@Service
public class AccountService {

	/****
	 * ͨ���û�����ȡ�û�����
	 * 
	 * @param username
	 * @return
	 */
	public User getUserByUserName(String username) {
		User user = (User) dao.findObjectByHQL("FROM User WHERE username = ?", new Object[] { username });
		return user;
	}

	/***
	 * ͨ���û�����ȡȨ����Դ
	 * 
	 * @param username
	 * @return
	 */
	public List<String> getPermissionsByUserName(String username) {
		System.out.println("����");
		User user = getUserByUserName(username);
		if (user == null) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		// System.out.println(user.getUserRoles().get(0).get);
		for (UserRole userRole : user.getUserRoles()) {
			Role role = userRole.getRole();
			List<Permission> permissions = dao.findAllByHQL("FROM Permission WHERE roleId = ?", new Object[] { role.getId() });
			for (Permission p : permissions) {
				list.add(p.getUrl());
			}
		}
		return list;
	}

	// ���������ݿ���ʽӿ�
	// ����ʡ��BaseDao dao�ı�д
	@Autowired
	private BaseDao dao;
}
