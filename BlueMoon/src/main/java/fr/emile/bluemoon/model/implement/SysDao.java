package fr.emile.bluemoon.model.implement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.emile.bluemoon.common.IConstant;
import fr.emile.bluemoon.entity.Sys;
import fr.emile.bluemoon.model.connect.DBConnect;
import fr.emile.bluemoon.model.interfaces.ISysDao;
import fr.emile.bluemoon.utils.Utils;

public class SysDao implements ISysDao, IConstant {

	public SysDao() {
		// TODO Auto-generated constructor stub
	}

	public Sys add(Sys sys) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			Utils.trace("save dans le add");
			session.save(sys);
			transaction.commit();

		} catch (Exception e) {
			Utils.trace("catch add");
			Utils.trace(e.toString());
//			Utils.trace(sys.toString());

			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
//			if (session != null && session.isOpen())
//				session.close();

		}

		return sys;
	}

//-------------------------------------------------------------------------------------------------
	public Sys getByFunctionCode(int functionCode) throws Exception {

		Session session = DBConnect.getSession();
		Sys mySys = new Sys();
		List<Sys> SysList = new ArrayList<Sys>();
		try {

			Utils.trace("myQuery.toString()");
			Query<Sys> myQuery = session.createQuery("FROM Sys WHERE functionCode = :functionCode", Sys.class);
//			Query<Sys> myQuery = session.createQuery("FROM User WHERE id = :functionCode", Sys.class);
			Utils.trace("myQuery.toString()");
			Utils.trace(myQuery.toString());
			
			myQuery.setParameter("functionCode",FUNCTION_KEY_DB );

			Utils.trace("myQuery.toString()");
			Utils.trace(myQuery.toString());

//			mySys = myQuery.uniqueResult(); // retreive the first record encontered
			SysList = myQuery.list();
			mySys = SysList.get(0);
//			mySys.setKey();

		} catch (Exception e) {
			Utils.trace("catch getByFunctionCode");
			Utils.trace(e.toString());
			

		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return mySys;

	}

	//-------------------------------------------------------------------------------------------------
	public Sys get(int id) throws Exception {
		Session session = DBConnect.getSession();
		Sys mySys = new Sys();
		List<Sys> SysList = new ArrayList<Sys>();
		try {

			Utils.trace("myQuery.toString()");
//			Query<Sys> myQuery = session.createQuery("FROM Sys WHERE id = :id", Sys.class);
			Query<Sys> myQuery = session.createNativeQuery("SELECT * FROM Sys WHERE id = :id", Sys.class);
//			query.setParameter("email", email);
			Utils.trace("myQuery.toString()");
			Utils.trace(myQuery.toString());
			
			myQuery.setParameter("id",id );

			Utils.trace("myQuery.toString()");
			Utils.trace(myQuery.toString());

//			mySys = myQuery.uniqueResult(); // retreive the first record encontered
			SysList = myQuery.list();
			mySys = SysList.get(0);
//			mySys.setKey();

		} catch (Exception e) {
			Utils.trace("catch getByFunctionCode");
			Utils.trace(e.toString());
			

		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return mySys;

	}

	public int Update(Sys sys) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
