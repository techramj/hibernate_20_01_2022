package com.easylearing.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.easylearing.entities.Account;
import com.easylearing.entities.Transaction;
import com.easylearing.entities.User;


public class ApplicationMain {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Transaction t1 = new Transaction("DEBIT", "Grocery expenses", BigDecimal.valueOf(3000.0));
		Transaction t2 = new Transaction("CREDIT", "Salary credited", BigDecimal.valueOf(25000.0));
		
		Account account = new Account("John", BigDecimal.valueOf(50000.0));
		account.getTransactions().add(t1);
		account.getTransactions().add(t2);
		
		Account account1 = new Account("Jessica",  BigDecimal.valueOf(50000.0));
		
		Account jointAccout = new Account("John&Jessica",  BigDecimal.valueOf(50000.0));
		
		User jack = new User("Jack", "Jack@test.com");
		User jessica = new User("Jessica", "Jack@test.com");
		
		
		account.getUsers().add(jack);
		account1.getUsers().add(jessica);
		
		jointAccout.getUsers().add(jack);
		jointAccout.getUsers().add(jessica);
		
		jack.getAccounts().add(account);
		jack.getAccounts().add(jointAccout);
		
		jessica.getAccounts().add(account1);
		jessica.getAccounts().add(jointAccout);
		
		session.save(account);
		session.save(account1);
		session.save(jointAccout);
		
		session.getTransaction().commit();
	
		session.close();
		
		session= factory.openSession();
		
		User newUser=session.get(User.class, jointAccout.getUsers().iterator().next().getUserId());
		System.out.println(newUser.getAccounts().iterator().next().getName());

		factory.close();
	}





}
