package com.studentManagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ObjectDao extends HibernateDaoSupport {

	/**
	 * 查询一组数据
	 * 
	 * @param condition
	 *            查询条件
	 * @return
	 */
	public Object getObjectForm(String condition) {
		List list = null;
		Object object = null;
		try {
			list = getHibernateTemplate().find(condition);
			if (list != null && list.size() != 0)
				object = list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * 查询多组数据
	 * 
	 * @param condition
	 *            查询条件
	 * @return
	 */
	public List getObjectList(String condition) {
		List list = null;
		try {
			list = getHibernateTemplate().find(condition);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 更新对象数据
	 * 
	 * @param object
	 * @return
	 */
	public boolean updateObjectForm(Object object) {
		try {
			getHibernateTemplate().update(object);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 保存数据操作
	 * 
	 * @param object
	 */
	public boolean insertObjectForm(Object object) {
		try {
			getHibernateTemplate().save(object);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除数据操作
	 * 
	 * @param object
	 * @return
	 */
	public boolean deleteObjectForm(Object object) {
		try {
			getHibernateTemplate().delete(object);
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 以下是分页查询的代码
	 */

	/**
	 * 获取总的记录数
	 * 
	 * @return
	 */
	public long getTotalRow(String table, String PropertyName, String search) {
		Session session = getSessionFactory().openSession();
		String hql = "select count(*) from " + table + " p ";
		if (PropertyName != null) {
			hql += "where p." + PropertyName + " like : " + search;
		}
		Query query = session.createQuery(hql);
		long rows = ((Long) query.iterate().next()).longValue();
		session.close();
		return rows;
	}

	/**
	 * 获取总页数
	 */
	public int getTotalPage(int rows, int rowsPerPage) {

		if (rows % rowsPerPage == 0) {
			return rows / rowsPerPage;
		} else {
			return rows / rowsPerPage + 1;
		}
	}

	/**
	 * 获取指定页数的数据记录
	 * 
	 * @param page
	 * @param rowsPerPage
	 * @return
	 */
	public List<Object> findPlantByPage(int page, int rowsPerPage,
			String table, String PropertyName, String search) {
		Session session = getSessionFactory().openSession();
		String sql = "select count(*) from " + table + " p ";
		if (PropertyName != null) {
			sql += "where p." + PropertyName + " like : " + search;
		}
		Query query = session.createQuery(sql);
		query.setMaxResults(rowsPerPage); // 每页最多显示几条
		query.setFirstResult((page - 1) * rowsPerPage); // 每页从第几条记录开始
		List<Object> list = query.list();
		session.close();

		return list;
	}
}
