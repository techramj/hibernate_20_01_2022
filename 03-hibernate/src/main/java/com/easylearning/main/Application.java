package com.easylearning.main;

import java.util.Date;

import org.hibernate.Session;

import com.easylearning.entities.Address;
import com.easylearning.entities.Employee;
import com.easylearning.entities.User;

public class Application {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
	    session.save(dummyUser1());
		session.getTransaction().commit();
		
		session.close();
		
		HibernateUtil.getSessionFactory().close();
	}
	
	private static User dummyUser1() {
		User user = new User(1001L, "Jackie", "marria@gmail.com", new Date());
		user.setCreatedBy("Ram");
		user.setLastUpdated(new Date());
		user.setLastUpdatedBy("Ram");
		
		Address address = new Address("1234", "Pune", "Near New Market", "411041");
		user.setAddress(address);
		return user;
		
	}

}
