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

import com.company.dao.pojo.selftest.Course;
import com.company.dao.pojo.selftest.Score;
import com.company.dao.pojo.selftest.Stu;
import com.company.dao.pojo.twoway12n.Dept;
import com.company.dao.pojo.twoway12n.Emp;



public class SelfTest {

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
		Stu zhao = new Stu("zhao");
		Stu qian = new Stu("qian");
		
		Course java = new Course("java");
		Course web = new Course("web");
		Course html = new Course("html");
		Course python = new Course("python");
		
		Score score = new Score(zhao, java);
		Score score1 = new Score(zhao, web);
		Score score2 = new Score(qian, html);
		Score score3 = new Score(qian, python);
		
		session.save(java);
		session.save(web);
		session.save(html);
		session.save(python);
		
		session.save(zhao);
		session.save(qian);
		
		session.save(score);
		session.save(score1);
		session.save(score2);
		session.save(score3);
		
	}

	@Test
	public void twoWay12n_update(){
		Stu stu = (Stu) session.get(Stu.class, 2);
		for(Score score:stu.getScores()){
			if( (score.getStu().getSid()==2) && (score.getCourse().getCid()==3) ){
				score.setCourseScore(90.0);
				System.out.println(score);
			}
		}
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
