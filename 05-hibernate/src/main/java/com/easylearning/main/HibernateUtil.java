package com.easylearning.main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.easylearning.entities.Account;
import com.easylearning.entities.Department;
import com.easylearning.entities.Employee;
import com.easylearning.entities.SavingAccount;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		//configuration.addAnnotatedClass(Employee.class);
		//configuration.addAnnotatedClass(Department.class);
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(SavingAccount.class);
		//add the entity mapping class here
		
		return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
	}
	
	private HibernateUtil() {}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
