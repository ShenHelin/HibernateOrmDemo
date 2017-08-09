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

import com.company.dao.pojo.twoway12n.Dept;
import com.company.dao.pojo.twoway12n.Emp;



public class ORM_onewayn21Test {

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
	public void twoWay12n_save() {
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
		// 1.1 先保存1，后保存n,将执行4条insert的sql语句
		session.save(hrDept);
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(developDept);
		session.save(emp4);
		session.save(emp5);
		session.save(emp6);

		// 1.2 先保存n，后保存1，将执行1条select+4条insert+3条update的sql语句
		// session.save(emp1);
		// session.save(emp2);
		// session.save(emp3);
		// session.save(hrDept);

	}

	@Test
	public void twoWay12n_update(){
		//findById
		Emp e = (Emp) session.get(Emp.class, 1003);
		e.setEname("SUNSUNSUN");
		Dept dept = e.getDept();//获取的多对一的对象是持久化状态，可以自动调用flush方法
//		System.out.println(dept);
		dept.setLoc("BeiJi");
	}
	@Test
	public void twoWay12n_delete(){
		Emp e = (Emp) session.get(Emp.class, 1005);
//		Dept dept = e.getDept();
//		session.delete(dept);//删除不成功，外键关联中dept中依然有其他emp对象
		session.delete(e);
	}
	@Test
	public void twoWay12n_findAll(){
		
		Query query = session.createQuery("from Emp");
		List<Emp> emps = query.list();
		for(Emp emp:emps){
			System.out.println(emp);
			System.out.println(emp.getDept());//取出的不是deptno的值，而是Dept对象
		}
		
	}
	@Test
	public void twoWay12n_findById(){
		Emp emp = (Emp) session.get(Emp.class, 1002);
		System.out.println(emp);
		System.out.println(emp.getDept());
		
	}
}
