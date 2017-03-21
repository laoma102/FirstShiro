package org.swinglife.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/***
 * �û���
 * 
 * @author Swinglife
 * 
 */
@Table(name = "t_user")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	/** �û��� **/
	String username;
	/** ���� **/
	String password;
	/** �Ƿ�ɾ�� **/
	Integer isDelete;
	/** ����ʱ�� **/
	Date createDate;
	//��Զ��û�Ȩ�ޱ�
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
	List<UserRole> userRoles;
	
	
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
