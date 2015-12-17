package com.gis;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class TestDAO {
	public static void TestAddUser(Session session) {
		userDAO dao = new userDAO(session);
		USER u = new USER();
		u.setNAME("tomm");
		u.setEMAIL("tomm@hinte.net");
		try {
			dao.Insert(u);
		} catch (HibernateException ex) {
			System.out.println("error occurs.");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Session session = DefaultFactory.getSessionFactory().openSession();
		try {
			TestAddUser(session);
		} finally {
			session.close();
		}
	}
}