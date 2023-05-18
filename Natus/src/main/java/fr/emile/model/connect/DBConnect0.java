package fr.emile.model.connect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DBConnect0 {

	private static DBConnect0 instance;
	private static SessionFactory sessionFactory;
	private static Session session;
	
	private DBConnect0() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration()
					.configure()
					.buildSessionFactory();
		}
	}

	public static Session getSession() {
		if (instance == null) {
			instance = new DBConnect0();
		}
		
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		
		return session;
		
	}
	
}
