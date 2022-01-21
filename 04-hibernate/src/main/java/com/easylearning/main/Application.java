package com.easylearning.main;

import java.util.Date;

import org.hibernate.Session;

import com.easylearning.entities.Department;
import com.easylearning.entities.Employee;

public class Application {
	
	public static void main(String[] args) {
		Employee emp = new Employee("Jack",15000.0);
		Employee emp1 = new Employee("Jessica",5000.0);
		Department dept = new Department("IT");
		Department dept1 = new Department("HR");
		emp.setDateOfJoining(new Date());
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		//session.save(emp);
		session.save(dept);
		//session.save(emp1);
		session.save(dept1);
		session.save(new Department("Account"));
		session.getTransaction().commit();
		
		session.close();
		HibernateUtil.getSessionFactory().close();
	}

}
