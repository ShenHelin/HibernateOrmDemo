package com.company.dao.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.dao.pojo.twoway121.Detail;
import com.company.dao.pojo.twoway121.Login;

public class ORM_121Test {

	private Configuration configuration;
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction trans;

	@Before
	public void setUp() throws Exception {
		configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		trans = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		trans.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void initDB() {
		System.out.println("create the table from pojo--ORM");
	}

	@Test
	public void twoWay121_save() {
		Login login = new Login("admin", "123");
		Detail detail = new Detail("ADMIN**", 5000, new Date());
		login.setDetail(detail);
		detail.setLogin(login);
		session.save(login);
		session.save(detail);
	}

	@Test
	public void twoWay121_update() {
		Login login = (Login) session.get(Login.class, 32768);
		login.setPassword("1234567");
		Detail detail = login.getDetail();
		detail.setBalance(30000.98);
	}

	@Test
	public void twoWay121_delete() {
		Login login = (Login) session.get(Login.class, 32768);
		Detail detail = login.getDetail();
		// 删除时，需先删掉id依赖方，例如detail依赖于login，则先删除detail
		session.delete(detail);
		session.delete(login);

		// session.delete(login);
		// session.delete(detail);
	}

	@Test
	public void twoWay121_findAll() {
		Query query = session.createQuery("from Login");
		List<Login> logins = query.list();
		for (Login login : logins) {
			Detail detail = login.getDetail();
			System.out.println(login + "***" + detail);
		}
	}

	@Test
	public void twoWay121_findById() {
		Login login = (Login) session.get(Login.class, 32768);
		Detail detail = login.getDetail();
		System.out.println(login + ":" + detail);
	}
}
