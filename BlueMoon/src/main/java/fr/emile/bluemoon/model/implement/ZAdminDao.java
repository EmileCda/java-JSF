package fr.emile.bluemoon.model.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.emile.bluemoon.common.IConstant;
import fr.emile.bluemoon.entity.Admin;
import fr.emile.bluemoon.model.connect.DBConnect;
import fr.emile.bluemoon.model.interfaces.IAdminDao;
import fr.emile.bluemoon.utils.Utils;

public class ZAdminDao implements IAdminDao, IConstant {

	public ZAdminDao() {
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
//			if (session != null && session.isOpen())
//				session.close();

		}

		return admin;
	}

//-------------------------------------------------------------------------------------------------
	public Admin getByFunctionCode(int functionCode) throws Exception {

		Session session = DBConnect.getSession();
		Admin myAdmin = new Admin();
		List<Admin> AdminList = new ArrayList<Admin>();
		try {

			Utils.trace("myQuery.toString()");
			Query<Admin> myQuery = session.createQuery("FROM Admin WHERE functionCode = :functionCode", Admin.class);
//			Query<Admin> myQuery = session.createQuery("FROM User WHERE id = :functionCode", Admin.class);
			Utils.trace("myQuery.toString()");
			Utils.trace(myQuery.toString());
			
			myQuery.setParameter("functionCode",FUNCTION_KEY_DB );

			Utils.trace("myQuery.toString()");
			Utils.trace(myQuery.toString());

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
