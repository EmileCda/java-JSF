package fr.emile.laze.model.dao.interfaces;

import java.util.List;

import fr.emile.laze.entity.Address;
import fr.emile.laze.entity.User;

public interface IAddressDao {

	Address add(Address address) throws Exception; 
	List<Address> get(int userId) throws Exception;
	List<Address> get(User  user) throws Exception;
	List<Address> get() throws Exception;
	Address getById(int Id) throws Exception ;
	
	int update(Address address)throws Exception;
	int delete (int id)throws Exception;

	
}
