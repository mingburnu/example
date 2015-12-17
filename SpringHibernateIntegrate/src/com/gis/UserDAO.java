package com.gis;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserDAO {
	private SessionFactory sessionFactory = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<USER> getByName(String name) {
		Session session = sessionFactory.openSession();
		List<USER> result = session.createCriteria(USER.class)
				.add(Restrictions.eq("NAME", name)).list();
		session.close();
		return result;
	}

	public UserDAO() {
	}

}