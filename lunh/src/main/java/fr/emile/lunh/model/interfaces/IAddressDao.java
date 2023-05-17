package fr.emile.lunh.model.interfaces;

import java.util.List;

import fr.emile.lunh.entity.Address;
import fr.emile.lunh.entity.User;

public interface IAddressDao {
	
	Address add(Address address) throws Exception; 
	List<Address> get(int userId) throws Exception;
	List<Address> get(User  user) throws Exception;
	List<Address> get() throws Exception;
	Address getById(int Id) throws Exception ;
	
	int Update(Address address)throws Exception;
	int delete (int id)throws Exception;

}