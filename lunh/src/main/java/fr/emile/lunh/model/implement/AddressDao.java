package fr.emile.lunh.model.implement;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.emile.lunh.model.interfaces.IAddressDao;
import fr.emile.lunh.common.IConstant;
import fr.emile.lunh.entity.Address;
import fr.emile.lunh.entity.User;
import fr.emile.lunh.model.connect.DBConnect;
import fr.emile.lunh.utils.Utils;

public class AddressDao implements IConstant, Serializable, IAddressDao {

	@Override
	public Address add(Address address) throws Exception {
		Session session = DBConnect.getSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			session.persist(address);
			transaction.commit();

		} catch (Exception e) {
			Utils.trace("address : catch");

			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			Utils.trace(address.toString());
			if (session != null && session.isOpen())
				session.close();

		}
		return address;	
	}
//-------------------------------------------------------------------------------------------------

	@Override
	public List<Address> get(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> get(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getById(int Id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Update(Address address) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
