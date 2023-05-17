package fr.emile.lunh.test;

import java.security.Key;

import fr.emile.lunh.adaptator.ToBlob;
import fr.emile.lunh.common.IConstant;
import fr.emile.lunh.entity.Admin;
import fr.emile.lunh.model.implement.AdminDao;
import fr.emile.lunh.model.interfaces.IAdminDao;
import fr.emile.lunh.utils.Utils;

public class TestAdmin implements IConstant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IAdminDao myAdminDao = new AdminDao();
		
		try {
			Admin myAdmin = new Admin();
			Key myKey = ToBlob.getKey();
			myAdmin.setFunctionCode(FUNCTION_KEY_DB);
			myAdmin.setCrytoKey(myKey);
			myAdmin.setAlgorythm(ALGORITHM);
			Utils.trace(myAdmin.toString());
			myAdminDao.add(myAdmin);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
