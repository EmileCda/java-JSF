package fr.emile.bluemoon.test;

import java.util.Date;

import fr.emile.bluemoon.entity.Address;
import fr.emile.bluemoon.entity.DataTest;
import fr.emile.bluemoon.entity.User;
import fr.emile.bluemoon.enums.Gender;
import fr.emile.bluemoon.model.implement.UserDao;
import fr.emile.bluemoon.model.interfaces.IUserDao;
import fr.emile.bluemoon.utils.Utils;

public class UserCreate {
	

	public static void main(String[] args) {
		
		addUser();
		
		Utils.trace("---------------end---------------");
	}

	
	
	public static void addUser() {
		
		User myUser  = DataTest.genUser();
		
		myUser.addAddress(DataTest.genAddress());
//		myUser.addAddress(DataTest.genAddress());
		myUser.addAddress(DataTest.genAddress());
		
		myUser.setPass("lulu");
		IUserDao myUserDao = new UserDao();
		try {
			myUserDao.add(myUser);
		} catch (Exception e) {
			Utils.trace("catch myUserDao.add(myUser) ");
			e.printStackTrace();
		}finally {
			Utils.trace(myUser.toString());
		}
	}
	
	//--------------------------------------------------------------------------------	
	//--------------------------------------------------------------------------------	
	public  void addUserAndAddress() {
//			User myUser = new User("claudine", "PICARD", Utils.string2Date("18/01/1991", "dd/MM/yyyy"));
//			Address myAddress = new Address("312", "rue Louis Asseline", "genay", "94350");
//			
//			
//			
//			myUser.setAddress(myAddress);
//			IUserDao myUserDao = new UserDao();
//			try {
//				myUserDao.add(myUser);
//			} catch (Exception e) {
//				Utils.trace("catch myUserDao.add(myUser) ");
//				e.printStackTrace();
//			}finally {
//				Utils.trace(myUser.toString());
//				Utils.trace(myUser.getAddress().toString());
//				
//			}
			
		}

	
}
