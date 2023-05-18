package fr.emile.bluemoon.test;

import fr.emile.bluemoon.entity.Address;
import fr.emile.bluemoon.entity.DataTest;
import fr.emile.bluemoon.model.implement.AddressDao;
import fr.emile.bluemoon.model.interfaces.IAddressDao;
import fr.emile.bluemoon.utils.Utils;

public class AddressCreate {

	public static void main(String[] args) {
		addAddress();
	}
	
// ---------------------------------------------------------------
	
	public static void addAddress() {
		
//		User myUser = DataTes
		Address myAddress = DataTest.genAddress();
		
		
		
		
		
	IAddressDao myAddressDao = new AddressDao();
	try {
		myAddressDao.add(myAddress);
	} catch (Exception e) {
		Utils.trace("catch myUserDao.add(myUser) ");
		e.printStackTrace();
	}finally {
		Utils.trace(myAddress.toString());
	}
		
		
	}

}
