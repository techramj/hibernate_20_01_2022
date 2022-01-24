package com.easylearning.main;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.easylearning.entities.Account;
import com.easylearning.entities.Department;
import com.easylearning.entities.Employee;

public class Application {
	
	public static void main(String[] args) {
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(dummyAccount());
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
	
	public static Account dummyAccount() {
		Account account = new Account(1L, "SBI", "Sam", 50000.0);
		return account;
	}
	
	public static Employee dummyEmp() {
		Employee emp = new Employee( "Johnson",5000.0);
		emp.setDateOfJoining(new Date());
		List<String> contact = Arrays.asList("contact1","contact2", "contact3");
		emp.setContacts(contact);
		
		Map<String, String> projects = new HashMap<String, String>();
		projects.put("EMS", "Jackson");
		projects.put("Social Profile ", "Jessica");
		//projects.put(null, "no project manager"); not allowed
		projects.put("Automation web", null);
		
		emp.setProjects(projects);
		return emp;		
	}

}
