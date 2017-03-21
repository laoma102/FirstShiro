package org.swinglife.dao;

import java.util.List;

import org.hibernate.Query;

public interface BaseDao {

	/***
	 * ���
	 */
	public void addObject(Object object);

	/***
	 * ��ѯ�������� return list
	 */
	public List findAllByHQL(String hql);

	/***
	 * ��ѯ��������������
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	public List findAllByHQL(String hql, Object[] args);

	/***
	 * ��ѯ���������Ķ���
	 */
	public Object findObjectByHQL(String hql);

	public Object findObjectByHQL(String hql, Object[] args);

	/***
	 * ��ѯ���������Ķ���
	 */
	public Object findObjectBySQL(String sql);

	/***
	 * ��ҳ��ѯ return list
	 */
	public List findPage(String hql, int page, int size);

	/***
	 * ��ҳ��ѯ ��ռλ������
	 * 
	 * @param hql
	 * @param page
	 * @param size
	 * @param args
	 * @return
	 */
	public List findPage(String hql, int page, int size, Object[] args);

	/***
	 * ɾ������
	 */
	public void delObject(Object object);

	/***
	 * ���¶���
	 */
	public void updateObject(Object object);

	/***
	 * �������¶��� return int
	 */
	public void updateObjectByHQL(String hql);

	public void updateObjectByHQL(String hql, Object[] params);

	/***
	 * ͨ��sql��ѯ����
	 * 
	 * @param sql
	 * @return
	 */
	public List findAllBySql(String sql);

}
