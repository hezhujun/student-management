package com.studentManagement.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.studentManagement.dao.ObjectDao;
import com.studentManagement.model.News;
import com.studentManagement.model.Sign;
import com.studentManagement.model.Student;

public class MyService extends ObjectDao {

	/**
	 * 获取新闻
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<News> getNews(int page, int rowsPerPage) {
		List<News> news = null;
		Transaction tx = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(News.class);
			criteria.addOrder(Order.desc("date"));
			criteria.setMaxResults(rowsPerPage); // 每页最多显示几条
			criteria.setFirstResult((page - 1) * rowsPerPage); // 每页从第几条记录开始
			news = criteria.list();
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			session.close();
		}
		return news;
	}

	/**
	 * 获取签到信息
	 * 
	 * @param day
	 *            第几天
	 * @return
	 */
	public Map<Integer, List<Object[]>> getSigned(String day) {
		// 1:已签到 2:未签到
		Map<Integer, List<Object[]>> map = new HashMap<Integer, List<Object[]>>();

		Transaction tx = null;
		Session session = null;
		List<Object[]> signed = new ArrayList<Object[]>();
		List<Object[]> unsigned = new ArrayList<Object[]>();
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Student.class);

			List<Student> allStudent = criteria.list();
			for (Student student : allStudent) {
				criteria = session.createCriteria(Sign.class);
				criteria.add(Restrictions.eq("studentId",
						student.getStudentId()));
				Timestamp begin = Timestamp.valueOf(day + " 00:00:00");
				Timestamp end = Timestamp.valueOf(day + " 23:59:59");
				criteria.add(Restrictions.between("date", begin, end));
				List<Sign> sign = criteria.list();
				if (sign == null || sign.size() == 0) {
					Object[] objects = { student.getName(),
							student.getStudentId().toString() };
					unsigned.add(objects);
				} else {
					Object[] objects = { student.getName(), sign.get(0) };
					signed.add(objects);
				}
			}
			map.put(1, signed);
			map.put(2, unsigned);
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			session.close();
		}

		return map;
	}

	/**
	 * 多条件查找学生
	 * 
	 * @param studentId
	 * @param name
	 * @param year
	 * @param nation
	 * @param political
	 * @param class_
	 * @param tel
	 * @param idcard
	 * @param province
	 * @return
	 */
	public List<Student> searchStudent(Long studentId, String name, int year,
			String nation, String political, String class_, String tel,
			String idcard, String province) {
		List<Student> studentList = null;
		Transaction tx = null;
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Student.class);
			Criterion cron;
			if (studentId != 0) {
				cron = Restrictions.eq("studentId", studentId);
				criteria.add(cron);
			}
			if (year != 0) {
				cron = Restrictions.eq("year", year);
				criteria.add(cron);
			}
			if (nation != null && !nation.equals("")) {
				cron = Restrictions.like("nation", "%" + nation + "%");
				criteria.add(cron);
			}
			if (political != null && !political.equals("")) {
				cron = Restrictions.like("political", "%" + political + "%");
				criteria.add(cron);
			}
			if (class_ != null && !class_.equals("")) {
				cron = Restrictions.like("class_", "%" + class_ + "%");
				criteria.add(cron);
			}
			if (tel != null && !tel.equals("")) {
				cron = Restrictions.eq("tel", "%" + tel + "%");
				criteria.add(cron);
			}
			if (idcard != null && !idcard.equals("")) {
				cron = Restrictions.eq("idcard", "%" + idcard + "%");
				criteria.add(cron);
			}
			if (province != null && !province.equals("")) {
				cron = Restrictions.like("province", "%" + province + "%");
				criteria.add(cron);
			}
			studentList = criteria.list();
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			session.close();
		}
		return studentList;
	}

	public boolean isAlreadySigned(long studentId, Timestamp time) {
		Transaction tx = null;
		Session session = null;
		boolean temp = false;
		try {
			session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Sign.class);
			criteria.add(Restrictions.eq("studentId", studentId));
			// 查找今天之前签到情况
			Timestamp begin = Timestamp.valueOf(time.toString().substring(0, 10) + " 00:00:00");
			criteria.add(Restrictions.between("date", begin, time));
			List<Sign> sign = criteria.list();
			if (sign == null || sign.size() == 0)
				temp = false;
			else
				temp = true;
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			session.close();
		}

		return temp;
	}
}
