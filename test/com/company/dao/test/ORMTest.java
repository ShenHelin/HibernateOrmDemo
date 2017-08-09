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

import com.company.dao.pojo.Dept;
import com.company.dao.pojo.Emp;

public class ORMTest {

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
	public void oneWayn21_save() {
		// 1-save
		Dept hrDept = new Dept(10, "HR", "DaLian");
		Emp emp1 = new Emp(1001, "zhao", 5000, new Date());
		Emp emp2 = new Emp(1002, "qian", 4000, new Date());
		Emp emp3 = new Emp(1003, "sun", 6000, new Date());
		emp1.setDept(hrDept);
		emp2.setDept(hrDept);
		emp3.setDept(hrDept);
		Dept developDept = new Dept(20, "DEVELOP", "BeiJing");
		Emp emp4 = new Emp(1004, "li", 5000, new Date());
		Emp emp5 = new Emp(1005, "zhou", 4000, new Date());
		Emp emp6 = new Emp(1006, "wu", 6000, new Date());
		emp4.setDept(developDept);
		emp5.setDept(developDept);
		emp6.setDept(developDept);
		// 1.1 �ȱ���1���󱣴�n,��ִ��4��insert��sql���
		session.save(hrDept);
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(developDept);
		session.save(emp4);
		session.save(emp5);
		session.save(emp6);

		// 1.2 �ȱ���n���󱣴�1����ִ��1��select+4��insert+3��update��sql���
		// session.save(emp1);
		// session.save(emp2);
		// session.save(emp3);
		// session.save(hrDept);

	}

	@Test
	public void oneWayn21_update(){
		
	}
	@Test
	public void oneWayn21_delete(){
		
	}
	@Test
	public void oneWayn21_findAll(){
		
		Query query = session.createQuery("from Emp");
		List<Emp> emps = query.list();
		for(Emp emp:emps){
			System.out.println(emp);
			System.out.println(emp.getDept());//ȡ���Ĳ���deptno��ֵ������Dept����
		}
		
	}
	@Test
	public void oneWayn21_findById(){
		Emp emp = (Emp) session.get(Emp.class, 2);
		System.out.println(emp);
		System.out.println(emp.getDept());
		
	}
}
