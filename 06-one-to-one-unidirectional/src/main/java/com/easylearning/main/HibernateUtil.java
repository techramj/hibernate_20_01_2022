package com.easylearning.main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.easylearning.entities.Credential;
import com.easylearning.entities.User;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Credential.class);
		
	
		
		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
	}
	
	private HibernateUtil() {}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
