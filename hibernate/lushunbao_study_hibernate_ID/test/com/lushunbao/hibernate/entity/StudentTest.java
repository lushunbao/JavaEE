package com.lushunbao.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StudentTest {
	private static Session session = null;
	private static SessionFactory sessionFactory = null;
	private static int count = 0;
	@BeforeClass
	public static void setUp(){
		System.out.println("Set Up!");
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	@Test
	public void testStudentInsert() throws Exception{
		System.out.println("testInsert!");
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		for(int i=0;i<100;i++){
			session.persist(getStudent());
		}
		//session.persist(getStudent());
	}
	
	public static Student getStudent(){
		System.out.println("getStudent!");
		Student student = new Student();
		student.setAge(count);
		student.setName("lusb"+count);
		count++;
		System.out.println(count);
		return student;
	}
	
	@AfterClass
	public static void closeSession(){
		session.close();
	}

}
