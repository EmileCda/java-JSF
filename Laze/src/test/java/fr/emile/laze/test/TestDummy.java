package fr.emile.laze.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.emile.laze.entity.User;
import fr.emile.laze.model.connector.HibernateConnector;
import fr.emile.laze.utils.Utils;



public class TestDummy {
	
	
	public static void main(String[] args) {
	
		Session session = HibernateConnector.getSession();
		String cityName = "Paris";
		Transaction transaction = null;
		List<User> userList = new ArrayList<User>();
		try {

			Query myQuery=session.createQuery("FROM User u join u.address a WHERE a.city=:arg",User.class);
			Query myQuery2 = session.createNamedQuery() ;
			myQuery.setString("arg", cityName);
			myQuery.setParameter("arg", cityName);
			
			userList = myQuery.getResultList() ;

		} catch (Exception e) {


		} finally {
			if (session != null && session.isOpen())
				session.close();
			for (User user : userList) {
				
				Utils.trace(user.toString());
				
			}
		}
	}
}
