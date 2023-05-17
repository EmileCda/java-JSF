package fr.emile.lunh.test;

import java.security.Key;
import java.util.Arrays;

import fr.emile.lunh.adaptator.ToBlob;
import fr.emile.lunh.common.IConstant;
import fr.emile.lunh.entity.Admin;
import fr.emile.lunh.model.implement.AdminDao;
import fr.emile.lunh.model.interfaces.IAdminDao;
import fr.emile.lunh.utils.Utils;

public class TestRetreiveKey implements IConstant{

	public static void main(String[] args) {
		IAdminDao myAdminDao = new AdminDao();
		
		try {
			Admin myAdmin = new Admin();
			myAdmin= myAdminDao.getByFunctionCode(FUNCTION_KEY_DB);

			
			if (myAdmin != null)
			{
				Utils.trace(myAdmin.getAlgorythm());
				Utils.trace(String.format("%d",myAdmin.getId()));
				Utils.trace(String.format("%d",myAdmin.getFunctionCode()));
				Utils.trace(Arrays.toString(myAdmin.getBlobKey()));
				
				Utils.trace(myAdmin.toString());
			} else Utils.trace("not found ");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
