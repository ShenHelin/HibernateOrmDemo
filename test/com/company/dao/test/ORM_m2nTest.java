//package com.company.dao.test;
//
//import java.util.List;
//import java.util.Set;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.company.dao.pojo.twowaym2n.Course;
//import com.company.dao.pojo.twowaym2n.Stu;
//
//
//public class ORM_m2nTest {
//
//	private Configuration configuration;
//	private SessionFactory sessionFactory;
//	private Session session;
//	private Transaction trans;
//
//	@Before
//	public void setUp() throws Exception {
//		configuration = new Configuration().configure();
//		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//				.buildServiceRegistry();
//		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//		session = sessionFactory.openSession();
//		trans = session.beginTransaction();
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		trans.commit();
//		session.close();
//		sessionFactory.close();
//	}
//
//	@Test
//	public void initDB() {
//		System.out.println("create the table from pojo--ORM");
//	}
//
//	@Test
//	public void twoWaym2n_save() {
//		Stu zhao = new Stu("zhao");
//		Stu qian = new Stu("qian");
//		Course java = new Course("java");
//		Course oracle = new Course("oracle");
//		Course web = new Course("web");
//		Course ssh = new Course("ssh");
//		
//		//由于Course.hbm.xml中<set>中设置了inverse=true，所以，多对多关系由Stu对象来维护
////		zhao.getCourses().add(java);
////		zhao.getCourses().add(oracle);
////		zhao.getCourses().add(web);
////		qian.getCourses().add(oracle);
////		qian.getCourses().add(web);
////		qian.getCourses().add(ssh);
//		
//		session.save(java);
//		session.save(oracle);
//		session.save(web);
//		session.save(ssh);
//		session.save(zhao);
//		session.save(qian);
//		
//	}
//
//	@Test
//	public void twoWaym2n_update() {
////		Course java = (Course) session.get(Course.class, 1);
////		java.setCourseName("JavaEE");
//		//zhao加选了课程ssh
//		Stu zhao = (Stu) session.get(Stu.class, 1);
//		Course ssh = (Course) session.get(Course.class, 4);
////		zhao.getCourses().add(ssh);
//		zhao.getCourses().remove(ssh);
//	}
//
//	@Test
//	public void twoWaym2n_delete() {
//	}//略
//
//	@Test
//	public void twoWaym2n_findAll() {
//		Query query = session.createQuery("from Stu");
//		List<Stu> stus = query.list();
//		for(Stu stu:stus){
//			Set<Course> courses = stu.getCourses();
//			for(Course course:courses){
//				System.out.println(stu.getStuName()+":"+course.getCourseName());
//			}
//			System.out.println("**************************");
//		}
//	}
//
//	@Test
//	public void twoWaym2n_findById() {
//		Stu x = (Stu) session.get(Stu.class, 1);
//		System.out.println("******************lazy=true*******************");
//		Set<Course> courses = x.getCourses();
//		for(Course course:courses){
//			System.out.println(x.getStuName()+":"+course.getCourseName());
//		}
//	}
//}
