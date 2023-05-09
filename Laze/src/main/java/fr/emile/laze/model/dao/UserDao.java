package fr.emile.laze.model.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.emile.laze.common.IConstant;
import fr.emile.laze.entity.User;
import fr.emile.laze.model.connector.HibernateConnector;
import fr.emile.laze.model.dao.interfaces.IUserDao;
import fr.emile.laze.utils.Utils;

public class UserDao implements IUserDao, IConstant, Serializable {

	private static final long serialVersionUID = 1L;

	public UserDao() {
	}

//-------------------------------------------------------------------------------------------------
// add user in the table.
// this method add user and address in tables

	public User add(User user) throws Exception {

		Session session = HibernateConnector.getSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			session.persist(user.getAddress());
			session.persist(user);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			if (session != null && session.isOpen())
				session.close();

		}
		return user;
	}
//-------------------------------------------------------------------------------------------------
// this methode retreive an user by his Id

	public User get(int id) throws Exception {

		Session session = HibernateConnector.getSession();
		Transaction transaction = null;
		User user = new User();
		try {
			user = session.find(User.class, id);
		} catch (Exception e) {

		} finally {
			if (session != null && session.isOpen())
				session.close();
			Utils.trace(user.toString());
		}

		return user;
	}

	// -------------------------------------------------------------------------------------------------
	// this methode retreve the whole user from table

	public List<User> get() throws Exception {

		return this.get_JPL();
	}

	// -------------------------------------------------------------------------------------------------
	// this methode retreve the whole user from table

	public List<User> get_JPL() throws Exception {
		Session session = HibernateConnector.getSession();
		List<User> userList = new ArrayList<User>();
		try {

			// Query<User> query = session.createQuery("SELECT u FROM User u"); // this is
			// an other way
			Query<User> myQuery = session.createQuery("FROM User", User.class);
			userList = myQuery.list();

		} catch (Exception e) {

		} finally {
			if (session != null && session.isOpen())
				session.close();
			for (User user : userList) {

				Utils.trace(user.toString());

			}
		}
		return userList;
	}

//-------------------------------------------------------------------------------------------------
	public List<User> get_nativeSql() throws Exception {
		Session session = HibernateConnector.getSession();
		List<User> userList = new ArrayList<User>();
		try {

			Query<User> myQuery = session.createNativeQuery("SELECT * FROM user", User.class);
			userList = myQuery.list();

		} catch (Exception e) {

		} finally {
			if (session != null && session.isOpen())
				session.close();
			for (User user : userList) {

				Utils.trace(user.toString());

			}
		}
		return userList;
	}

//-------------------------------------------------------------------------------------------------
	public List<User> get_predefine() throws Exception {
		Session session = HibernateConnector.getSession();
		List<User> userList = new ArrayList<User>();
		try {

		Query<User> myQuery=session.createNamedQuery("User:findAll", User.class);	

			userList = myQuery.list();

		} catch (Exception e) {

		} finally {
			if (session != null && session.isOpen())
				session.close();
			for (User user : userList) {

				Utils.trace(user.toString());

			}
		}
		return userList;
	}

//-------------------------------------------------------------------------------------------------
// this methode	update user table and Address table
	public int update(User user) throws Exception {
		Session session = HibernateConnector.getSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			session.update(user.getAddress());
			session.update(user);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			if (session != null && session.isOpen())
				session.close();

		}
		return 0;
	}
//-------------------------------------------------------------------------------------------------
// this methode put the flag delete on the record.

	public int delete(int id, boolean isDeleted) throws Exception {

		User user = new User();
		user = this.get(id);
		this.delete(user, isDeleted);
		return 0;
	}

	public int delete(User user, boolean isDeleted) throws Exception {
		user.setDeleted(isDeleted);
		this.update(user);
		return 0;
	}

	public int delete(int id) throws Exception {
		this.delete(id, true);
		return 0;
	}

	public int delete(User user) throws Exception {
		this.delete(user, true);
		return 0;
	}

// this methode delete data from table.

	public int remove(User user) throws Exception {

		Session session = HibernateConnector.getSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			session.remove(user);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			if (session != null && session.isOpen())
				session.close();

		}
		return 0;
	}

//-------------------------------------------------------------------------------------------------
	public User get(String parameEmail) throws Exception {
		Session session = HibernateConnector.getSession();
		User myUSer = new User();
		try {

			Query<User> myQuery = session.createQuery("FROM User WHERE lower(email) = :email", User.class);
			myQuery.setParameter("email", parameEmail.toLowerCase());

			myUSer = (User) myQuery.uniqueResult(); // retreive the first record encontered

		} catch (Exception e) {

		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return myUSer;
	}
//-------------------------------------------------------------------------------------------------

	public Map<String, List<User>> getByCity() throws Exception {
		Session session = HibernateConnector.getSession();
		Transaction transaction = null;
		Map<String, List<User>> mapReturn = new HashMap<String, List<User>>();
		
		List<User> principalUserList = new ArrayList<User>();
		try {

			Query<User> myQuery = session.createQuery("FROM User", User.class);
			
			principalUserList =myQuery.getResultList();
			
			for (User user : principalUserList) {
				
				String city = user.getAddress().getCity();
				
				List<User> currentUserList = mapReturn.get(city);
				
				if (currentUserList == null)				// city do not exist  
					currentUserList = new ArrayList<User>();
					
				currentUserList.add(user);
				mapReturn.put(city,currentUserList );
				
			}
			

		} catch (Exception e) {

		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

		return mapReturn;
	}

	//-------------------------------------------------------------------------------------------------
		public List<User> getByCity(String cityName) throws Exception {
		Session session = HibernateConnector.getSession();
		Transaction transaction = null;
		List<User> userList = new ArrayList<User>();
		try {

			Query<User> myQuery = session.createQuery("FROM User u WHERE u.address.city=:arg", User.class);
			myQuery.setParameter("arg", cityName);
//			userList = myQuery.getResultList() ;//  this is another way to retreive list
			userList = myQuery.list();

		} catch (Exception e) {

		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return userList;
	}

}
