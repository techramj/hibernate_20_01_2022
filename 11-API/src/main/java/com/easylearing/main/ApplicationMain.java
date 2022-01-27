package com.easylearing.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.easylearing.entities.Country;
import com.easylearing.entities.Employee;

public class ApplicationMain {

	public static void main(String[] args) {
		try (SessionFactory factory = HibernateUtil.getSessionFactory();) {
			flushDemo(factory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void flushDemo(SessionFactory factory) {
		Transaction transaction = null;
		Session session = factory.openSession();
		try  {
			transaction=session.beginTransaction();
			Employee emp = session.get(Employee.class, 206L);
			emp.setFirstName("Rajiv");
			session.flush();
			if(1==1) {
				throw new NullPointerException();
			}
			emp.setLastName("Mishra");
			
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public static void detachedDemo1(SessionFactory factory) {
		Country detachedCountry =null;
		try (Session session2 = factory.openSession();) {
			session2.beginTransaction();
			detachedCountry = session2.get(Country.class, "IN");
			session2.getTransaction().commit();
			session2.close();
		}
		
		Country transientCountry = new Country("IN","INDIA");
		
		
		try (Session session3 = factory.openSession();) {
			session3.beginTransaction();
	        session3.saveOrUpdate(detachedCountry);
			session3.saveOrUpdate(transientCountry);
			session3.getTransaction().commit();
		}
	}
	
	public static void detachedDemo(SessionFactory factory) {
		Country transientCountry = new Country("TO","TOGO");
		try (Session session1 = factory.openSession();) {
			session1.beginTransaction();
			session1.save(transientCountry);
			session1.getTransaction().commit();
		}
		
		
		try (Session session2 = factory.openSession();) {
			session2.beginTransaction();
			Country detachedCountry = session2.get(Country.class, "TO");
			detachedCountry.setCountryName("TOBO");
			session2.saveOrUpdate(transientCountry);
			session2.getTransaction().commit();
		}
	}
	
	public static void loadTest(SessionFactory factory) {

		try (Session session = factory.openSession();) {
			session.beginTransaction();
			Country c1= session.load(Country.class, "IX");
			//c1= session.get(Country.class, "IX");
			System.out.println(c1);
			//System.out.println(c1.getCountryName());
			session.getTransaction().commit();
		}
	}
	
	public static void test4(SessionFactory factory) {

		try (Session session = factory.openSession();) {
			session.beginTransaction();
			Employee emp=session.load(Employee.class, 100L);
			//System.out.println(emp);
			//System.out.println(emp.getFirstName());
			session.getTransaction().commit();
		}
	}

	
	public static void test3(SessionFactory factory) {

		try (Session session = factory.openSession();) {
			session.beginTransaction();
			Country c1= session.get(Country.class, "IN");
			//c1= session.get(Country.class, "IX");
			//System.out.println(c1);
			//System.out.println(c1.getCountryName());
			session.getTransaction().commit();
		}
	}
	
	
	public static void test2(SessionFactory factory) {
		Country country = new Country("RU", "USSR");

		try (Session session = factory.openSession();) {
			session.beginTransaction();
			session.save(country); // persist state
			
			
	
			session.getTransaction().commit();
			session.beginTransaction();
			country.setCountryName("RUSSIA"); //still this country in the persist
			session.getTransaction().commit();
			session.close();
		}

	}

	public static void test(SessionFactory factory) {
		// transient state
		Country country = new Country("ID", "INDO");

		try (Session session = factory.openSession();) {
			session.beginTransaction();
			session.save(country); // persist state
				// country.setCountryName("INDONESIA"); //still this country in the persist
				// state
			session.getTransaction().commit();
			session.close();
		}

		// detaching the country object detached state
		pause(2, "Creating the new session");
		try (Session session = factory.openSession();) {
			session.beginTransaction();
			country.setCountryName("INDONESA");
			session.update(country); // save or update
			pause(2, "modifying country name after persist state");
			// country.setCountryName("INDONESA"); // still this country in the persist
			// state
			// country.setCountryName("ABC");
			// country.setCountryName("XYZ");
			pause(2, "About to commit");
			session.getTransaction().commit();
		}
	}

	public static void pause(int sec, String message) {
		System.out.println(
				"\n\n===================================" + message + "============================================");
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sample(SessionFactory factory) {

		try (Session session = factory.openSession();) {
			session.beginTransaction();
			
			session.getTransaction().commit();
		}
	}

}
