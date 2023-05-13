package fr.emile.fabric.server;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.core.Response;

import fr.emile.fabric.entity.Employee;

public interface IEmployeeWebResource {
	
	
	public String getInfo() ; 
	
	
	public String getXmlEmployee(Integer id); 
	public String getJsonEmployee(Integer id);
//	public String getJsonEmployee(int id);
	public Response getEmployeeJsonToResponse(Integer id); 
	public List<Employee> getEmployeeList();
	public List<Employee> getEmployeeJsonList();
	public List<Employee> getEmployeeXmlList() ;


	public Response addEmployee(Employee employee)  throws URISyntaxException;
	public Response updateEmployee(Employee employe) throws URISyntaxException ;
	public Response removeEmployee(Integer id)  throws URISyntaxException;

}
