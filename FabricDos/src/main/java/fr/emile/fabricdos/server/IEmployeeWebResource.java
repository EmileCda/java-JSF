package fr.emile.fabricdos.server;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.core.Response;

import fr.emile.fabricdos.entity.Employee;

public interface IEmployeeWebResource {
	
	
	public Response getInfo() ; 
	
	
	public Response get(Integer id); 
	public Response get(String emailid); 
	public Response get();
//
	public Response add(Employee employee)  throws URISyntaxException;
	public Response update(Employee employe) throws URISyntaxException ;
	public Response delete(Integer id)  throws URISyntaxException;

}
