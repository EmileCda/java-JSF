package fr.emile.bluemoon.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.hibernate.Session;

import fr.emile.bluemoon.entity.Address;
import fr.emile.bluemoon.entity.Sys;
import fr.emile.bluemoon.entity.User;

import fr.emile.bluemoon.model.implement.SysDao;
import fr.emile.bluemoon.model.implement.UserDao;
import fr.emile.bluemoon.model.interfaces.ISysDao;
import fr.emile.bluemoon.model.interfaces.IUserDao;
import fr.emile.bluemoon.utils.Utils;

public class SysRead {

	public static void main(String[] args) {
//		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		int id = 1;
		oneSys(id);
	}

	public static void oneSys(int id) {

		Sys mySys = new Sys();

		ISysDao mySysDao = new SysDao();
		try {
			mySys=mySysDao.get(id);
		} catch (Exception e) {
			Utils.trace("catch mySys.add(myUser) ");
			e.printStackTrace();
		} finally {
			Utils.trace(mySys.toString());
	
		}

	}
	public static void oneUserEmail(String email) {

		User myUser = new User();

		IUserDao myUserDao = new UserDao();
		try {
			myUser=myUserDao.get(email);
		} catch (Exception e) {
			Utils.trace("catch myUserDao.add(myUser) ");
			e.printStackTrace();
		} finally {
			Utils.trace(myUser.toString());
	
			List<Address> addressList = new ArrayList<Address>();
			addressList = myUser.getAddressList();
			
			for (Address address : addressList) {
				Utils.trace(address.toString());
				
			}
			
			
			
//			Session session = DBConnect.getSession();
//			if (session != null && session.isOpen())
//				session.close();
		}

	}
}
