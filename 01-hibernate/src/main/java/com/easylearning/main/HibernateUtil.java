package com.easylearning.main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.easylearning.entities.Employee;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Employee.class);
		//add the entity mapping class here
		
		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
	}
	
	private HibernateUtil() {}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
