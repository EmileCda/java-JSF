package fr.emile.model.interfaces;


import fr.emile.redrose.entity.Admin;

public interface IAdminDao {
	
	Admin add(Admin admin) throws Exception; 
	Admin get(int Id) throws Exception ;
	Admin getByFunctionCode(int functionCode) throws Exception;

	int Update(Admin admin)throws Exception;
	int delete (int id)throws Exception;

}
