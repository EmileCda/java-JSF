package fr.emile.laze.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.emile.laze.entity.User;
import fr.emile.laze.model.dao.UserDao;
import fr.emile.laze.model.dao.interfaces.IUserDao;
import fr.emile.laze.utils.Utils;


public class MainUserRetreive {

	public static void main(String[] args) {
//		testbyEmail() ;
//		testbyCity() ;
		testbyCityHashMap();
//		testbyUser() ;
//		testAllUser();
		
	}
	public static void testbyCityHashMap() {
		final IUserDao myUserDao = new UserDao();
		Map<String, List<User>> mapUser = new HashMap<String, List<User>>();
		try {
			mapUser = myUserDao.getByCity();
			Utils.trace(String.format("== retreive map user group by city %d =========", mapUser.size()));
			if (mapUser != null) {
				for (Map.Entry<String, List<User>> entry : mapUser.entrySet()) {
					String city = entry.getKey();
					List<User> userList = entry.getValue();
					
					Utils.trace(city);
					for (User user : userList) {
						Utils.trace(user.toString());
					}
					
				}
				
				
			}else
				Utils.trace("userList est vide\n");			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	
	}

	
	public static void testbyCity() {
		final IUserDao myUserDao = new UserDao();
		List<User> userList = new ArrayList<User>();
		try {
			userList = myUserDao.getByCity("genay");
			Utils.trace(String.format("== retreive one user by city %d =========", userList.size()));
			if (userList != null) {
				for (User oneUser : userList) {
					Utils.trace(oneUser .toString());
				}
			}else
				Utils.trace("userList est vide\n");			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	public static void testbyEmail() {
		final IUserDao myUserDao = new UserDao();
		User myUser = null; 
		try {
			myUser = myUserDao.get("hilaire@DURAND.fr");
			Utils.trace("== retreive one user by mail =========");
			Utils.trace(myUser.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	public static void testbyUser() {
		final IUserDao myUserDao = new UserDao();
		User myUser = null; 
		try {
			myUser = myUserDao.get(5);
			Utils.trace("== retreive one user =========");
			Utils.trace(myUser.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	public static void testAllUser() {
		final IUserDao myUserDao = new UserDao();
		Utils.trace("= retreive all user ==================================================\n");
		try {
			
//			List<User> userList = myUserDao.get();
			List<User> userList = myUserDao.getByCity("chirassimont");
			

			if (userList != null) {
				for (User oneUser : userList) {
					Utils.trace(oneUser .toString());
				}
			}else
				Utils.trace("userList est vide\n");
				
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}

