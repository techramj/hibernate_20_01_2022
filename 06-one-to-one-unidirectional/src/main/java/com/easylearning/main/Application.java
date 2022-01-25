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

		session.save(cred);

		Credential c1 = session.get(Credential.class, cred.getCredentialId());
		System.out.println("=================="+c1.getUser().getFisrtName());
		session.getTransaction().commit();

		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
