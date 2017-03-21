package org.swinglife.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.swinglife.model.User;
import org.swinglife.service.AccountService;

/****
 * �Զ���Realm
 * 
 * @author Swinglife
 * 
 */
public class MyShiroRealm extends AuthorizingRealm {

	/***
	 * ��ȡ��Ȩ��Ϣ
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		// �����Լ�ϵͳ�������Ҫ��д��ȡ��Ȩ��Ϣ������Ϊ�˿�������ֻ��ȡ���û���Ӧ��ɫ����Դurl��Ϣ
		String username = (String) pc.fromRealm(getName()).iterator().next();
		if (username != null) {
			List<String> pers = accountService.getPermissionsByUserName(username);
			if (pers != null && !pers.isEmpty()) {
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				for (String each : pers) {
					// ��Ȩ����Դ��ӵ��û���Ϣ��
					info.addStringPermission(each);
				}
				return info;
			}
		}
		return null;
	}

	/***
	 * ��ȡ��֤��Ϣ
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) at;
		// ͨ�������յ��û���
		String username = token.getUsername();
		if (username != null && !"".equals(username)) {
			User user = accountService.getUserByUserName(username);
			if (user != null) {
				System.out.println("user:" + user);
				return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
			}
		}

		return null;
	}

	/** �û���ҵ���� **/
	private AccountService accountService;

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
