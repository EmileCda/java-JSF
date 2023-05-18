package fr.emile.bluemoon.model.interfaces;


import fr.emile.bluemoon.entity.Sys;

public interface ISysDao {
	
	Sys add(Sys sys) throws Exception; 
	Sys get(int Id) throws Exception ;
	Sys getByFunctionCode(int functionCode) throws Exception;

	int Update(Sys admin)throws Exception;
	int delete (int id)throws Exception;

}
