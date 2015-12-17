package com.gis;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class userDAO {
	private Session _session = null;

	@SuppressWarnings("unchecked")
	public List<USER> getData() {
		return _session.createCriteria(USER.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<USER> getByName(String name) {
		return _session.createCriteria(USER.class)
				.add(Restrictions.eq("NAME", name)).list();
	}

	public void Insert(USER value) {
		Transaction tx = _session.beginTransaction();
		try {
			_session.save(value);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw ex;
		}
	}

	public userDAO(Session session) {
		_session = session;
	}
}