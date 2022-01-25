package com.easylearning.main;

import org.hibernate.Session;

import com.easylearning.entities.Credential;
import com.easylearning.entities.User;

public class Application {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		User user = new User("Ashok", "More", "ashok@gmail.com");
		Credential cred = new Credential("ashokm", "mane@123");
		cred.setUser(user);
		user.setCredential(cred);

		session.save(cred);

		User u1 = session.get(User.class, user.getUserId());
		System.out.println("=================="+u1.getCredential().getUsername());
		session.getTransaction().commit();

		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
