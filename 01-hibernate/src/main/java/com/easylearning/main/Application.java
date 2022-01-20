package com.easylearning.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.easylearning.entities.Employee;

public class Application {
	
	public static void main(String[] args) {
		Employee emp = new Employee(101L,"Jessica",5000.0);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		
		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
