package fr.emile.model.interfaces;

import java.util.List;

import fr.emile.redrose.entity.Address;
import fr.emile.redrose.entity.User;

public interface IAddressDao {
	
	Address add(Address address) throws Exception; 
	List<Address> get(int userId) throws Exception;
	List<Address> get(User  user) throws Exception;
	List<Address> get() throws Exception;
	Address getById(int Id) throws Exception ;
	
	int Update(Address address)throws Exception;
	int delete (int id)throws Exception;

}
