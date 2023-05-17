package fr.emile.lunh.model.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.emile.lunh.common.IConstant;
import fr.emile.lunh.entity.Address;
import fr.emile.lunh.entity.Admin;
import fr.emile.lunh.entity.User;
import fr.emile.lunh.model.connect.DBConnect;
import fr.emile.lunh.model.interfaces.IAdminDao;
import fr.emile.lunh.utils.Utils;

public class AdminDao implements IAdminDao, IConstant {

	public AdminDao() {
		// TODO Auto-generated constructor stub
	}

	public Admin add(Admin admin) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			Utils.trace("save dans le add");
			session.save(admin);
			transaction.commit();

		} catch (Exception e) {
			Utils.trace("catch add");
			Utils.trace(e.toString());
//			Utils.trace(admin.toString());

			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			if (session != null && session.isOpen())
				session.close();

		}

		return admin;
	}

//-------------------------------------------------------------------------------------------------
	public Admin getByFunctionCode(int functionCode) throws Exception {

		Session session = DBConnect.getSession();
		Admin myAdmin = new Admin();
		List<Admin> AdminList = new ArrayList<Admin>();
		try {

			Query<Admin> myQuery = session.createQuery("FROM Admin WHERE functionCode = :functionCode", Admin.class);
			
			myQuery.setParameter("functionCode",FUNCTION_KEY_DB );

//			myAdmin = myQuery.uniqueResult(); // retreive the first record encontered
			AdminList = myQuery.list();
			myAdmin = AdminList.get(0);
			myAdmin.setKey();

		} catch (Exception e) {
			Utils.trace("catch getByFunctionCode");
			Utils.trace(e.toString());
			

		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return myAdmin;

	}

	//-------------------------------------------------------------------------------------------------
	public Admin get(int Id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int Update(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
