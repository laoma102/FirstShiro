package org.swinglife.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/****
 * Ȩ�ޱ�
 * 
 * @author Swinglife
 * 
 */
@Entity
@Table(name = "t_permission")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	/**token**/
	String token;
	/**��Դurl**/
	String url;
	/**Ȩ��˵��**/
	String description;
	/**������ɫ���**/
	Integer roleId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
