package fr.emile.laze.test;
import fr.emile.laze.entity.Address;
import fr.emile.laze.entity.User;
import fr.emile.laze.model.dao.UserDao;
import fr.emile.laze.model.dao.interfaces.IUserDao;
import fr.emile.laze.utils.Utils;

public class MainUserTestCreate {

	public static void main(String[] args) {
		User myUser = new User("claudine", "PICARD", Utils.string2Date("18/01/1991", "dd/MM/yyyy"));
		Address myAddress = new Address("312", "rue Louis Asseline", "genay", "94350");
		
		
		
		myUser.setAddress(myAddress);
		IUserDao myUserDao = new UserDao();
		try {
			myUserDao.add(myUser);
		} catch (Exception e) {
			Utils.trace("catch myUserDao.add(myUser) ");
			e.printStackTrace();
		}finally {
			Utils.trace(myUser.toString());
			Utils.trace(myUser.getAddress().toString());
			
		}
		
		
		
		
		

	}

}
