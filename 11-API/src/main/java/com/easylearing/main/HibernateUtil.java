package com.easylearing.main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.easylearing.entities.Country;
import com.easylearing.entities.Department;
import com.easylearing.entities.Employee;
import com.easylearing.entities.Location;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory=buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		Configuration configuration=new Configuration();
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Location.class);
		configuration.addAnnotatedClass(Country.class);
		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());

	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
