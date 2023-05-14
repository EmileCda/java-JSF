package fr.emile.laze.test;

import fr.emile.laze.entity.User;
import fr.emile.laze.model.dao.UserDao;
import fr.emile.laze.model.dao.interfaces.IUserDao;
import fr.emile.laze.utils.Utils;

public class TestUserDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final IUserDao myUserDao = new UserDao();
		User myUser = new User();
		int idUser = 3;
		myUser.setId(idUser);
		try {
			int nbImpacted = 0; 
			// delete by id 
			myUser = myUserDao.get(idUser);
			Utils.trace(String.format("origin user %s Deleted  nb impacted : %d\n",myUser.toString(), nbImpacted));
			nbImpacted = myUserDao.delete(idUser);
//			myUser = myUserDao.get(idUser);
//			Utils.trace(String.format("delete user %s Deleted  nb impacted : %d\n",myUser.toString(), nbImpacted));
//			nbImpacted = myUserDao.delete(idUser,false);
//			myUser = myUserDao.get(idUser);
//
//			Utils.trace(String.format("delete user %s Deleted  nb impacted : %d\n",myUser.toString(), nbImpacted));
//			
//			// delete by user  
//			idUser = 4;
//			myUser.setId(idUser);
//			myUser = myUserDao.get(idUser);
//			Utils.trace(String.format("origin user %s Deleted  nb impacted : %d\n",myUser.toString(), nbImpacted));
//			nbImpacted = myUserDao.delete(myUser);
//			myUser = myUserDao.get(idUser);
//			Utils.trace(String.format("delete user %s Deleted  nb impacted : %d\n",myUser.toString(), nbImpacted));
//
//			nbImpacted = myUserDao.delete(myUser,false);
//			myUser = myUserDao.get(idUser);
//			Utils.trace(String.format("delete user %s Deleted  nb impacted : %d\n",myUser.toString(), nbImpacted));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.printf("Error add %s", myUser);
			
		}
	}

}
