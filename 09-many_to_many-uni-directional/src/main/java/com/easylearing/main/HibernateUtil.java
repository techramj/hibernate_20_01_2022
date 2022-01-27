package com.easylearing.main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.easylearing.entities.Account;
import com.easylearing.entities.Transaction;
import com.easylearing.entities.User;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory=buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		Configuration configuration=new Configuration();
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Transaction.class);
		configuration.addAnnotatedClass(User.class);
		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());

	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
