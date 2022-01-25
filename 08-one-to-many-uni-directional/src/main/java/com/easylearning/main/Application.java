package com.easylearning.main;

import java.math.BigDecimal;

import org.hibernate.Session;

import com.easylearning.entities.Account;
import com.easylearning.entities.Transaction;

public class Application {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Transaction t1 = new Transaction("DEBIT", "Grocery", BigDecimal.valueOf(2000.0));
		Transaction t2 = new Transaction("DEBIT", "Movie ticket", BigDecimal.valueOf(500.0));
		Transaction t3 = new Transaction("CREDIT", "Salary", BigDecimal.valueOf(42000.0));
		
		Account account  = new Account("Rohit", BigDecimal.valueOf(200000));
		account.getTransactions().add(t1);
		account.getTransactions().add(t2);
		account.getTransactions().add(t3);
		
		session.save(account);

		session.getTransaction().commit();

		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
