package com.gis;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	public void Insert(final USER u) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(u);
	}

	public UserDAO() {
	}

}