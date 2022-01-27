package com.easylearing.main;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.easylearing.entities.Account;
import com.easylearing.entities.Budget;
import com.easylearing.entities.Transaction;


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
		
		Budget janBudget = new Budget("Jan Budget", BigDecimal.valueOf(10000.0), "1");
		janBudget.getTransaction().add(t1);
		janBudget.getTransaction().add(t2);
		
		session.save(account);
		session.save(janBudget);
		session.getTransaction().commit();
	
		
		session.close();

		factory.close();
	}





}
