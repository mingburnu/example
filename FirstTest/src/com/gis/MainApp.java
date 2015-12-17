package com.gis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.StaleStateException;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;

public class MainApp {

	public static void TestQuery() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		// 取得所有資料
		Iterator users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			System.out.println(user.getNAME());
			System.out.println(user.getEMAIL());
		}
		session.close();
		System.out.println("TestQuery done2");
		System.out.println("---------------------------------------------");
		DefaultFactory.shutdown();
	}

	public static void TestQuery2() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6422"));
		Iterator users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			System.out.println(user.getNAME());
			System.out.println(user.getEMAIL());
		}
		session.close();
		System.out.println("TestQuery2 done3");
		System.out.println("---------------------------------------------");
		// DefaultFactory.shutdown();
	}

	public static void TestHQL() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Query query = session
				.createQuery("from USER as USER where USER.NAME = :NAME");
		query.setString("NAME", "code6421");
		List users = query.list();
		Iterator list = users.iterator();
		while (list.hasNext()) {
			USER item = (USER) list.next();
			System.out.println(item.getNAME());
			System.out.println(item.getEMAIL());
		}
		session.close();
		System.out.println("TestHQL done4");
		System.out.println("---------------------------------------------");
	}

	public static void TestLoad() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		USER o = (USER) session.load(USER.class, 2);
		System.out.println(o.getNAME());
		System.out.println(o.getEMAIL());
		System.out.println("TestLoad done5");
		System.out.println("---------------------------------------------");
	}

	public static void TestGet() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		USER o = (USER) session.get(USER.class, 2);
		System.out.println(o.getNAME());
		System.out.println(o.getEMAIL());
		System.out.println("TestGet done6");
		System.out.println("---------------------------------------------");
	}

	public static void TestDelete() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6421"));
		Iterator users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			session.delete(user);
		}
		tx.commit();
		session.close();
		System.out.println("done.");
		// DefaultFactory.shutdown();
		System.out.println("TestDelete done7");
		System.out.println("---------------------------------------------");
	}

	public static void TestUpdate() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6421"));
		Iterator users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			user.setEMAIL("code6421@code6421.com");
			session.saveOrUpdate(user);
		}
		tx.commit();
		session.close();
		System.out.println("TestUpdate done8");
		// DefaultFactory.shutdown();
	}

	public static void TestDepartInsert() {
		DEPARTMENT dep = new DEPARTMENT();
		dep.setID("A001");
		dep.setNAME("IT");
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(dep);
			tx.commit();
		} catch (ConstraintViolationException ex) {
			System.out.println("Insert Data Error:" + ex.getMessage());
			tx.rollback();
		}
		session.close();
		System.out.println("TestDepartInsert done9");
		// DefaultFactory.shutdown();
	}

	public static void TestDepartInsert2() {
		DEPARTMENT dep = new DEPARTMENT();
		dep.setID("A001");
		dep.setNAME("IT");
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(dep);
			tx.commit();
		} catch (ConstraintViolationException ex) {
			System.out.println("Insert Data Error:" + ex.getMessage());
			tx.rollback();
		} catch (HibernateException gex) {
			System.out.println("Generic Error :" + gex.getMessage());
			tx.rollback();
		}
		session.close();
		System.out.println("TestDepartInsert2 done10");
		// DefaultFactory.shutdown();
	}

	public static void TestDepartDelete() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DEPARTMENT.class);
		criteria.add(Restrictions.eq("NAME", "IT"));
		Iterator deps = criteria.list().iterator();
		while (deps.hasNext()) {
			DEPARTMENT dep = (DEPARTMENT) deps.next();
			session.delete(dep);
		}
		tx.commit(); // 把中斷點設在這,停下來後透過資料庫工具刪除對應的資料
		session.close();
		System.out.println("TestDepartDelete done11");
		DefaultFactory.shutdown();
	}

	public static void TestDepartDelete2() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DEPARTMENT.class);
		criteria.add(Restrictions.eq("NAME", "IT"));
		Iterator deps = criteria.list().iterator();
		while (deps.hasNext()) {
			DEPARTMENT dep = (DEPARTMENT) deps.next();
			session.delete(dep);
		}
		try {
			tx.commit(); // 把中斷點設在這
		} catch (StaleStateException ex) {
			System.out.println("Delete or Update Error (row not exists) : "
					+ ex.getMessage());
			tx.rollback();
		} catch (HibernateException gex) {
			System.out.println("Generic Error :" + gex.getMessage());
			tx.rollback();
		}
		session.close();
		System.out.println("TestDepartDelete2 done12");
		// DefaultFactory.shutdown();
	}

	public static void TestDepartDelete_Lock() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DEPARTMENT.class);
		criteria.add(Restrictions.eq("NAME", "IT"));
		criteria.setLockMode(LockMode.PESSIMISTIC_WRITE);
		Iterator deps = criteria.list().iterator();
		while (deps.hasNext()) {
			DEPARTMENT dep = (DEPARTMENT) deps.next();
			session.delete(dep);
		}
		tx.commit(); // 把中斷點設在這
		session.close();
		System.out.println("TestDepartDelete_Lock done13");
		DefaultFactory.shutdown();
	}

	public static void TestDepartDelete_Lock_Opt() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DEPARTMENT.class);
		criteria.add(Restrictions.eq("NAME", "IT"));
		Iterator deps = criteria.list().iterator();
		while (deps.hasNext()) {
			DEPARTMENT dep = (DEPARTMENT) deps.next();
			session.delete(dep);
		}
		TestDepartDelete2();
		tx.commit(); // 此處會拋出例外
		session.close();
		System.out.println("TestDepartDelete_Lock_Opt done14");
		DefaultFactory.shutdown();
	}

	public static void TestDepartDelete_Lock_Opt2() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(DEPARTMENT.class);
		criteria.add(Restrictions.eq("NAME", "IT"));
		Iterator deps = criteria.list().iterator();
		while (deps.hasNext()) {
			DEPARTMENT dep = (DEPARTMENT) deps.next();
			session.delete(dep);
		}
		TestDepartDelete2();
		try {
			tx.commit(); // 把中斷點設在這
		} catch (StaleObjectStateException ex) {
			System.out.println("Update Row Version Error : " + ex.getMessage());
			tx.rollback();
		} catch (HibernateException gex) {
			System.out.println("Generic Error:" + gex.getMessage());
			tx.rollback();
		}
		session.close();
		System.out.println("TestDepartDelete_Lock_Opt2 done15");
		DefaultFactory.shutdown();
	}

	public static void TestUpdate_Opt() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6421"));
		Iterator users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			user.setEMAIL("code6421_12@testcode6421.com");
			session.saveOrUpdate(user);
		}
		try {
			tx.commit(); // 中斷點設在這
		} catch (StaleObjectStateException ex) {
			System.out.println("Update Row Version Error : " + ex.getMessage());
			tx.rollback();
		} catch (HibernateException gex) {
			System.out.println("Generic Error:" + gex.getMessage());
			tx.rollback();
		}
		session.close();
		System.out.println("TestUpdate_Opt done16");
	}

	public static void TestInsertWithDynUpdate() {
		USER data = new USER();
		data.setNAME("code6421_2");
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(data);
		tx.commit();
		session.close();
		System.out.println("TestInsertWithDynUpdate done17");
	}

	public static void TestCOMPOSITE_KEY() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		COMPOSITE_KEY item1 = new COMPOSITE_KEY();
		item1.setNAME("code6421");
		item1.setPHONE("3539458394");
		item1.setADDRESS("Taiwan");
		session.save(item1);
		tx.commit();
		session.close();
		System.out.println("TestCOMPOSITE_KEY done17");
	}

	public static void TestQuery3() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6421"));
		List lst = criteria.list();
		if (lst.isEmpty()) {
			System.out.println("no data");
			session.close();
			return;
		}
		USER user1 = (USER) lst.get(0);
		Criteria criteria2 = session.createCriteria(USER.class);
		criteria2.add(Restrictions.eq("NAME", "code6421"));
		List lst2 = criteria2.list();
		USER user2 = (USER) lst.get(0);
		if (user1 == user2)
			System.out.println("is same");
		session.close();
	}

	public static void TestClear() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		List lst = criteria.list();
		USER u = (USER) lst.get(0);
		session.clear();
		lst = criteria.list();
		USER u1 = (USER) lst.get(0);
		if (u == u1)
			System.out.println("is Same");
		session.close();
		System.out.println("done.");
	}

	public static void TestEvict() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		List lst = criteria.list();
		USER u = (USER) lst.get(0);
		session.evict(u);
		lst = criteria.list();
		USER u1 = (USER) lst.get(0);
		if (u == u1)
			System.out.println("is Same");
		session.close();
		System.out.println("done.");
	}

	public static void TestQuery4() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6421"));
		Iterator users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			user.setEMAIL("dummy");
			System.out.println(user.getNAME());
			System.out.println(user.getEMAIL());
		}
		criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6421"));
		users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			System.out.println(user.getNAME());
			System.out.println(user.getEMAIL());
		}
		// tx.commit();
		session.close();
		System.out.println("done.");
	}

	public static void TestQuery5() {
		StatelessSession session = DefaultFactory.getSessionFactory()
				.openStatelessSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6421"));
		Iterator users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			user.setEMAIL("dummy");
			System.out.println(user.getNAME());
			System.out.println(user.getEMAIL());
		}
		criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6421"));
		users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			System.out.println(user.getNAME());
			System.out.println(user.getEMAIL());
		}
		// tx.commit();
		session.close();
		System.out.println("done.");
	}

	public static void TestQueryWithCache() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.setCacheable(true);
		Iterator users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			System.out.println(user.getNAME());
			System.out.println(user.getEMAIL());
		}
		users = criteria.list().iterator();
		while (users.hasNext()) {
			USER user = (USER) users.next();
			System.out.println(user.getNAME());
			System.out.println(user.getEMAIL());
		}
		session.close();
		System.out.println("done.");
	}

	public static void AddStock() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(PRODUCT.class);
		criteria.add(Restrictions.eq("NAME", "Java"));
		PRODUCT item1 = (PRODUCT) criteria.list().get(0);
		criteria = session.createCriteria(PRODUCT.class);
		criteria.add(Restrictions.eq("NAME", "C++"));
		PRODUCT item2 = (PRODUCT) criteria.list().get(0);
		STOCK st1 = new STOCK();
		st1.setLOCATION("Taipei");
		STOCK_DETAIL detail1 = new STOCK_DETAIL();
		detail1.setQTY(15);
		detail1.setSTOCK(st1);
		detail1.setPRODUCT(item1);
		STOCK_DETAIL detail2 = new STOCK_DETAIL();
		detail2.setQTY(5);
		detail2.setSTOCK(st1);
		detail2.setPRODUCT(item2);
		st1.addDETAIL(detail1);
		st1.addDETAIL(detail2);
		session.save(st1);
		tx.commit();
		System.out.println("done.");
	}

	public static void BasicQuery() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6421"));
		USER u = (USER) criteria.list().get(0);
		System.out.println(u.getNAME());
		System.out.println(u.getEMAIL());
		session.close();
		System.out.println("done.");
	}

	public static void BasicQuery_OR2() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.or(Restrictions.eq("NAME", "code6421")).add(
				Restrictions.like("EMAIL", "%code6421.com%")));
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			USER u = (USER) dataIterator.next();
			System.out.println(u.getNAME());
			System.out.println(u.getEMAIL());
		}
		session.close();
		System.out.println("done.");
	}

	public static void BasicQuery_IN() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.add(Restrictions.in("NAME",
				new String[] { "code6421", "mary" }));
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			USER u = (USER) dataIterator.next();
			System.out.println(u.getNAME());
			System.out.println(u.getEMAIL());
		}
		session.close();
		System.out.println("done.");
	}

	public static void BasicQuery_UseObject() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		USER q = new USER();
		q.setEMAIL("code6421@code6421.com");
		criteria.add(Example.create(q));
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			USER u = (USER) dataIterator.next();
			System.out.println(u.getNAME());
			System.out.println(u.getEMAIL());
		}
		session.close();
	}

	public static void UseOrder() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.addOrder(Order.asc("EMAIL"));
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			USER u = (USER) dataIterator.next();
			System.out.println(u.getNAME());
			System.out.println(u.getEMAIL());
		}
		session.close();
	}

	public static void UseOrder2() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.addOrder(Order.desc("EMAIL"));
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			USER u = (USER) dataIterator.next();
			System.out.println(u.getNAME());
			System.out.println(u.getEMAIL());
		}
		session.close();
	}

	public static void UseOrder3() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class);
		criteria.addOrder(Order.desc("EMAIL")).addOrder(Order.asc("NAME"));
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			USER u = (USER) dataIterator.next();
			System.out.println(u.getNAME());
			System.out.println(u.getEMAIL());
		}
		session.close();
	}

	public static void UseProjection() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(STOCK_DETAIL.class)
				.setProjection(
						Projections.projectionList()
								.add(Projections.avg("QTY").as("AVG_QTY"))
								.add(Projections.groupProperty("PRODUCT")));
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			Object[] o = (Object[]) dataIterator.next();
			System.out.println(((PRODUCT) o[1]).getNAME());
			System.out.println(((double) o[0]));
		}
		session.close();
	}

	public static void QueryAssociation() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(STOCK.class);
		criteria.createCriteria("DETAILS").createCriteria("PRODUCT")
				.add(Restrictions.eq("NAME", "C++"));
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			STOCK u = (STOCK) dataIterator.next();
			System.out.println(u.getLOCATION());
		}
		session.close();
	}

	public static void QueryStockWithFetchMode() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(STOCK.class);
		criteria.setFetchMode("DETAILS", FetchMode.JOIN);
		// 查詢user所有欄位
		Iterator sts = criteria.list().iterator();
		while (sts.hasNext()) {
			STOCK st = (STOCK) sts.next();
			System.out.println(st.getLOCATION());
			Iterator sts_details = st.getDETAILS().iterator();
			while (sts_details.hasNext()) {
				STOCK_DETAIL std = (STOCK_DETAIL) sts_details.next();
				System.out.println(std.getPRODUCT().getNAME() + ":"
						+ std.getQTY());
			}
		}
		session.close();
		System.out.println("done.");
	}

	public static void UseSqlRestriction() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class).add(
				Restrictions.sqlRestriction("{alias}.NAME LIKE (?)", "c%",
						StandardBasicTypes.STRING));
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			USER u = (USER) dataIterator.next();
			System.out.println(u.getNAME());
			System.out.println(u.getEMAIL());
		}
		session.close();
	}

	public static void UseMaxResult() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class).setMaxResults(2);
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			USER u = (USER) dataIterator.next();
			System.out.println(u.getNAME());
			System.out.println(u.getEMAIL());
		}
		session.close();
	}

	public static void DisplayByPage(int page, int pageSize) {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(USER.class)
				.setFirstResult(page * pageSize).setMaxResults(pageSize);
		List datas = criteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			USER u = (USER) dataIterator.next();
			System.out.println(u.getNAME());
			System.out.println(u.getEMAIL());
		}
		session.close();
	}

	public static void UseDetachedCriteria() {
		DetachedCriteria criteria = DetachedCriteria.forClass(USER.class);
		criteria.add(Restrictions.eq("NAME", "code6421"));
		Session session = DefaultFactory.getSessionFactory().openSession();
		Criteria realCriteria = criteria.getExecutableCriteria(session);
		List datas = realCriteria.list();
		Iterator dataIterator = datas.iterator();
		while (dataIterator.hasNext()) {
			USER u = (USER) dataIterator.next();
			System.out.println(u.getNAME());
			System.out.println(u.getEMAIL());
		}
		session.close();
	}

	public static void UseBasicHQL() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Query query = session
				.createQuery("from USER as USER where USER.NAME = :NAME");
		query.setString("NAME", "code6421");
		List users = query.list();
		Iterator list = users.iterator();
		while (list.hasNext()) {
			USER item = (USER) list.next();
			System.out.println(item.getNAME());
			System.out.println(item.getEMAIL());
		}
		session.close();
	}

	public static void UseOrderHQL() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Query query = session
				.createQuery("from USER as USER order by USER.EMAIL desc");
		List users = query.list();
		Iterator list = users.iterator();
		while (list.hasNext()) {
			USER item = (USER) list.next();
			System.out.println(item.getNAME());
			System.out.println(item.getEMAIL());
		}
		session.close();
	}

	public static void UseGroupHQL() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Query query = session
				.createQuery("select STOCK_DETAIL.PRODUCT.NAME, avg(STOCK_DETAIL.QTY) AS AQTY FROM STOCK_DETAIL AS STOCK_DETAIL GROUP BY STOCK_DETAIL.PRODUCT");
		List users = query.list();
		Iterator list = users.iterator();
		while (list.hasNext()) {
			Object[] item = (Object[]) list.next();
			System.out.println(item[0]);
			System.out.println(item[1]);
		}
		session.close();
	}

	public static void UseUnTypeHQL2() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Query query = session
				.createQuery("select USER.NAME, USER.EMAIL from USER as USER where USER.NAME = :NAME AND USER.EMAIL LIKE :EMAIL");
		query.setString("NAME", "code6421");
		query.setString("EMAIL", "%code6421%");
		List users = query.list();
		Iterator list = users.iterator();
		while (list.hasNext()) {
			Object[] item = (Object[]) list.next();
			System.out.println(item[0]);
			System.out.println(item[1]);
		}
		session.close();
	}

	public static void UseNamedQuery() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Query query = session.getNamedQuery("findByName");
		query.setString("NAME", "code6421");
		List users = query.list();
		Iterator list = users.iterator();
		while (list.hasNext()) {
			USER item = (USER) list.next();
			System.out.println(item.getNAME());
			System.out.println(item.getEMAIL());
		}
		session.close();
	}

	public static void TestUpdateHQL() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session
				.createQuery("UPDATE USER SET EMAIL='c64@gmail.com' WHERE EMAIL=:EMAIL");
		query.setString("EMAIL", "c64@gmail.com");
		query.executeUpdate();
		tx.commit();
		session.close();
	}

	public static void TestDeleteHQL() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("DELETE USER WHERE EMAIL=:EMAIL");
		query.setString("EMAIL", "c64@gmail.com");
		query.executeUpdate();
		tx.commit();
		session.close();
	}

	public static void UseNativeSQL() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Query query = session.createSQLQuery("SELECT * FROM users")
				.addEntity(USER.class);
		List users = query.list();
		Iterator list = users.iterator();
		while (list.hasNext()) {
			USER item = (USER) list.next();
			System.out.println(item.getNAME());
			System.out.println(item.getEMAIL());
		}
		session.close();
	}

	public static void UseNativeSQL_Update() {
		Session session = DefaultFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createSQLQuery(
				"SELECT * FROM users WHERE NAME = :NAME").addEntity(
				USER.class);
		query.setString("NAME", "code6421");
		USER u = (USER) query.list().get(0);
		u.setEMAIL("code6421vs@gmail.com");
		session.saveOrUpdate(u);
		tx.commit();
		session.close();
	}

	public static void main(String[] args) {
		// USER user = new USER();
		// user.setNAME("code6421");
		// user.setEMAIL("code6421vs@gmail.com");
		// user.setNAME("code6422");
		// user.setEMAIL("code6422vs@gmail.com");
		// Session session = DefaultFactory.getSessionFactory().openSession();
		// Transaction tx = session.beginTransaction();
		// session.save(user);
		// tx.commit();
		// session.close();
		// System.out.println("done1");
		// System.out.println("---------------------------------------------");
		// TestDepartInsert2();
		// TestDepartDelete_Lock();
		// TestDepartDelete_Lock_Opt2();
		// TestUpdate_Opt();
		// TestInsertWithDynUpdate();
		// TestCOMPOSITE_KEY();
		// TestQuery3();
		// TestClear();
		// TestEvict();
		// TestQuery4();
		// TestQuery5();
		// TestQueryWithCache();
		// AddStock();
		// BasicQuery();
		// BasicQuery_OR2();
		// UseOrder();
		// UseSqlRestriction();
		// UseMaxResult();
		// DisplayByPage(2,2);
		// UseDetachedCriteria();
		// UseBasicHQL();
		// UseOrderHQL();
		// UseNamedQuery();
		// TestUpdateHQL();
//		TestDeleteHQL();
//		UseNativeSQL();
		UseNativeSQL_Update();
		DefaultFactory.shutdown();
		System.out.println("over");
	}
}