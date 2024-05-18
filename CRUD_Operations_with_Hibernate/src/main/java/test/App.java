package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import test.entity.Users;

public class App {

	public static void main(String[] args) {
	SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
	
	try {
		//create object of entity class 
		Users user = new Users("Parvez", "jnd", "parvez", "akhtar");
		
		//Start Transaction 
		session.beginTransaction();
		
		//perform operation
		session.save(user);
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("ROW ADDED!");
		
	}finally {
		session.close();
		factory.close();
	}

	}

}
