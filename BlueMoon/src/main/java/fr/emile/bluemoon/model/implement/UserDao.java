package fr.emile.bluemoon.model.implement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.emile.bluemoon.common.IConstant;
import fr.emile.bluemoon.entity.Address;
import fr.emile.bluemoon.entity.Admin;
import fr.emile.bluemoon.entity.User;
import fr.emile.bluemoon.model.connect.DBConnect0;
import fr.emile.bluemoon.model.interfaces.IUserDao;
import fr.emile.bluemoon.utils.Utils;

public class UserDao implements IUserDao, IConstant, Serializable {

	private static final long serialVersionUID = 1L;

	public UserDao() {
	}

// add an user  and his (list of) addresses
	@Override
	public User add(User user) throws Exception {
		
	
	Session session = DBConnect0.getSession();
		
		
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			session.save(user);

			List<Address> userAddressList = user.getAddressList();
			
			for (Address address : userAddressList) {
				
				session.save(address);
			
			}
			
			transaction.commit();

		} catch (Exception e) {
			Utils.trace("catch add");
			Utils.trace(e.toString());
			Utils.trace(user.toString());
			
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			this.closeSession(session );
			

		}
		
		return user;
		
	}
//-------------------------------------------------------------------------------------------------
// this methode retreive an user by his Id

	@Override
	public User get(int id) throws Exception {
		List<User> userList = new ArrayList<User>();
		Session session = DBConnect0.getSession();
		User user = new User();
		try {
			Utils.trace(String.format("get(int id) : %d",id ));
			Query<User> myQuery = session.createQuery("FROM User WHERE id = :id", User.class);
			Utils.trace(myQuery.toString());
			
			myQuery.setParameter("id",id );
			Utils.trace(myQuery.toString());

//			myAdmin = myQuery.uniqueResult(); // retreive the first record encontered
			userList = myQuery.list();
			Utils.trace(String.format("List<User> userList size :%d",  userList.size()));

			user = userList.get(0);
//			myAdmin.setKey();
//			user = session.find(User.class, id);
		} catch (Exception e) {
			Utils.trace("catch get(int id)");
			Utils.trace( e.toString());

		} finally {
			this.closeSession(session );
			Utils.trace(user.toString());
		}

		return user;
	}

	// -------------------------------------------------------------------------------------------------
	@Override
	public List<User> get() throws Exception {
		return this.get_JPL();
	}
// -------------------------------------------------------------------------------------------------
// this methode retreve one user( the first) identified by his email (which is suppose to be unique)

	@Override
	public User get(String email) throws Exception {
		Session session = DBConnect0.getSession();
		User myUSer = new User();
		try {
// email suppose to be in lower case
			Query<User> myQuery = session.createQuery("FROM User WHERE lower(email) = :email", User.class);
			myQuery.setParameter("email", email.toLowerCase());

			myUSer = (User) myQuery.uniqueResult(); // retreive the first record encontered

		} catch (Exception e) {

		} finally {
			this.closeSession(session );
		}
		return myUSer;
	}

// -------------------------------------------------------------------------------------------------
// this methode retreve the whole user from table by using JPL technics

	public List<User> get_JPL() throws Exception {
		Session session = DBConnect0.getSession();
		List<User> userList = new ArrayList<User>();
		try {

			// Query<User> query = session.createQuery("SELECT u FROM User u"); // this is
			// an other way
			Query<User> myQuery = session.createQuery("FROM User", User.class);
			userList = myQuery.list();

		} catch (Exception e) {

		} finally {
			this.closeSession(session );
			for (User user : userList) {

				Utils.trace(user.toString());

			}
		}
		return userList;
	}
//-------------------------------------------------------------------------------------------------
// this methode retreve the whole user from table by using nativeSql technics

	public List<User> get_nativeSql() throws Exception {
		Session session = DBConnect0.getSession();
		List<User> userList = new ArrayList<User>();
		try {

			Query<User> myQuery = session.createNativeQuery("SELECT * FROM user", User.class);
			userList = myQuery.list();

		} catch (Exception e) {

		} finally {
			this.closeSession(session );
			for (User user : userList) {

				Utils.trace(user.toString());

			}
		}
		return userList;
	}

//-------------------------------------------------------------------------------------------------
	public List<User> get_predefine() throws Exception {
		Session session = DBConnect0.getSession();
		List<User> userList = new ArrayList<User>();
		try {

			Query<User> myQuery = session.createNamedQuery("User:findAll", User.class);

			userList = myQuery.list();

		} catch (Exception e) {

		} finally {
			this.closeSession(session );
			for (User user : userList) {

				Utils.trace(user.toString());

			}
		}
		return userList;
	}

//-------------------------------------------------------------------------------------------------
// this method retreive all users who have an address in this city
	@Override
	public List<User> getByCity(String cityName) throws Exception {
		Session session = DBConnect0.getSession();
		List<User> userList = new ArrayList<User>();
		try {

			Query<User> myQuery = session.createQuery("FROM User u WHERE u.address.city=:arg", User.class);
			myQuery.setParameter("arg", cityName);
//			userList = myQuery.getResultList() ;//  this is another way to retreive list
			userList = myQuery.list();

		} catch (Exception e) {

		} finally {
			this.closeSession(session );
		}
		return userList;
	}

//-------------------------------------------------------------------------------------------------
// this method retreive all users in a map colection group by cityname
	@Override
	public Map<String, List<User>> getByCity() throws Exception {
//		Session session = DBConnect.getSession();
		Map<String, List<User>> mapReturn = new HashMap<String, List<User>>();
//
//		List<User> principalUserList = new ArrayList<User>();
//		try {
//
//			Query<User> myQuery = session.createQuery("FROM User", User.class);
//
//			principalUserList = myQuery.getResultList();
//
//			for (User user : principalUserList) {
//
////				String city = user.getAddress().getCity();
//
//				List<User> currentUserList = mapReturn.get(city);
//
//				if (currentUserList == null) // city do not exist
//					currentUserList = new ArrayList<User>();
//
//				currentUserList.add(user);
//				mapReturn.put(city, currentUserList);
//
//			}
//
//		} catch (Exception e) {
//
//		} finally {
//			if (session != null && session.isOpen())
//				session.close();
//		}

		return mapReturn;
	}
//-------------------------------------------------------------------------------------------------
// this method update all fields of an user 

	@Override
	public int update(User user) throws Exception {
		Session session = DBConnect0.getSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
//			session.update(user.getAddress());
			session.update(user);
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			this.closeSession(session );

		}
		return 0;
	}

//-------------------------------------------------------------------------------------------------
// delete do not remove user from database, only set flag delete (true) or revered (false)
// for delete from database, user remove. Warning : can not undelete 	
	@Override
	public int delete(int id, boolean isDeleted) throws Exception {

		User user = new User();
		user = this.get(id);
		this.delete(user, isDeleted);
		return 0;
	}

	@Override
	public int delete(User user, boolean isDeleted) throws Exception {
		user.setDeleted(isDeleted);
		this.update(user);
		return 0;
	}

	@Override
	public int delete(int id) throws Exception {
		this.delete(id, true);
		return 0;
	}

	@Override
	public int delete(User user) throws Exception {
		this.delete(user, true);
		return 0;
	}


//-------------------------------------------------------------------------------------------------
// hard remove (remove from table) can not undelete
	@Override
	public int remove(User user) throws Exception {

		Session session = DBConnect0.getSession();
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

			this.closeSession(session);

		}
		return 0;
	}
	
//-------------------------------------------------------------------------------------------------
	
	public void closeSession(Session session ) {

//		if (session != null && session.isOpen())
//			session.close();
		
	};

}
