package fr.emile.model.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.emile.redrose.common.IConstant;
import fr.emile.redrose.entity.Admin;
import fr.emile.redrose.model.connect.DBConnect;
import fr.emile.redrose.model.interfaces.IAdminDao;
import fr.emile.redrose.utils.Utils;

public class AdminDao implements IAdminDao, IConstant {

	public AdminDao() {
		// TODO Auto-generated constructor stub
	}

	public Admin add(Admin admin) throws Exception {
		Session session = DBConnect1.getSession();
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

		Session session = DBConnect1.getSession();
		Admin myAdmin = new Admin();
		List<Admin> AdminList = new ArrayList<Admin>();
		try {

			Utils.trace("myQuery.toString()");
			Query<Admin> myQuery = session.createQuery("FROM Admin WHERE function_code = :functionCode", Admin.class);
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
