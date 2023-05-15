package fr.emile.fabricdos.server;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.emile.fabricdos.entity.Employee;
import fr.emile.fabricdos.common.DataTest;
import fr.emile.fabricdos.common.IConstant;
import fr.emile.fabricdos.common.Utils;

//@Path(IConstant.ENTITY_CLASS)

@Path("/employee")
@Produces(IConstant.MEDIA_TYPE_JSON)
@Consumes(IConstant.MEDIA_TYPE_JSON)
public class EmployeeWebResource implements IEmployeeWebResource, IConstant {

//-------------------------------------------------------------------------------------------------
// this method is for checking if server is ready 	
	@Override
	@GET
	public Response getInfo() {
		Utils.trace("getInfo");
		return Response.status(Response.Status.ACCEPTED).header("function", "getInfo")
				.header("package name ", PACK_NAME)
				.entity("Web service powered with REST jersey 2.36 project FabricDos " + IConstant.MEDIA_TYPE_JSON)
				.build();

	}

//--CRUD READ by ID --------------------------------------------------------------------------------
	@Override
	@GET
	@Path(CRUD_R + BY_ID+"/{id}")
	public Response get(@PathParam("id") Integer id) {
		Utils.trace("get  by Id:" + CRUD_R);
		Employee employee = DataTest.genEmployee();

		employee.setId(id);
		return Response.status(Status.ACCEPTED).header("function", "get by Id ").entity(employee).build();
	}

//--CRUD READ by email  --------------------------------------------------------------------------------
// note : Email must be unique in the database
	@Override
	@GET
	@Path(CRUD_R + BY_EMAIL+ "/{email}")
	public Response get(@PathParam("email") String email) {
		Utils.trace("get  by email:" + CRUD_R);

		Employee employee = DataTest.genEmployee();
		employee.setId(100);
		employee.setEmail(email);
		return Response.status(Status.ACCEPTED).header("function", "get by email ").entity(employee).build();
	}

//--CRUD READ the whole list --------------------------------------------------------------------------------
// this methode should have a pagination in order to limit the number of records returned.
	@Override
	@GET
	@Path(CRUD_R + BY_LIST)
	public Response get() {
		Utils.trace("get list:" + CRUD_R);

		List<Employee> employeeList = new ArrayList<Employee>();

		for (int index = 1; index <= 10; index++) {
			Employee employee = DataTest.genEmployee();
			employee.setId(index);
			employeeList.add(employee);
		}

		return Response.status(Status.ACCEPTED).header("function", "get list").entity(employeeList).build();
	}

//--CRUD ADD --------------------------------------------------------------------------------
// note : this methode should check every field beford requestion DAO
	@Override
	@POST
	@Path(CRUD_C)
//	@Consumes(IConstant.MEDIA_TYPE_JSON)
	public Response add(Employee employee) throws URISyntaxException {

		
		if (isCorrect(employee)) {
			Utils.trace("Add:" + CRUD_C);

			Utils.trace(employee.toString());
			Integer newId = Utils.randInt(1, 10000);
			employee.setId(newId);

			return Response.status(Status.ACCEPTED).
					header("function", "Add").
					header("Id", newId).
					entity(employee.getId()).build();
			
		}
		else {
			return Response.status(Status.ACCEPTED).
					header("function", "Add").
					entity("Invalide fields : add canceled" ).build();
			
		}
		
	}
//--CRUD Update --------------------------------------------------------------------------------
// note : this methode should check every field beford requestion DAO

	@Override
	@PUT
	@Path(CRUD_U)
	public Response update(Employee employee) throws URISyntaxException {
		Utils.trace("update:" + CRUD_U);
		
		if ((isCorrect(employee)) &&  
				( isUnique(employee.getEmail()))) {
					
			employee.setPosition(employee.getPosition() + "~ update ~");
			Integer newId = Utils.randInt(1, 10000);
			employee.setId(newId);
			Utils.trace(employee.toString());
			return Response.status(Status.ACCEPTED).
					header("function", "update").
					header("new-position", employee.getPosition() ).
					entity(newId).build();

		}
		return Response.status(Status.ACCEPTED).
				header("function", "update").
				header("new-position", employee.getPosition() ).
				entity("Invalide fields : update canceled").build();
			
	}

	@Override
	@DELETE
	@Path(CRUD_D + "/{id}")
//	@Path("delete/{id}")
	public Response delete(@PathParam("id") Integer id) throws URISyntaxException {
		Utils.trace("delete:" + CRUD_D);

		return Response.status(Status.ACCEPTED).header("function", "deleteZ").entity(id).build();
	}
	
	private  boolean  isUnique(String email) {
		// check with database if email exist 
		
		return true ; 
	}
	
	private  boolean  isCorrect(Employee employee) {
		boolean status = true;
		
		if (employee == null)
			return false;
		
		if ((employee.getFirstname() == null) ||(employee.getFirstname().isEmpty() ))
			return false;

		if ((employee.getLastname() == null) ||(employee.getLastname().isEmpty() ))
			return false;

		if ((employee.getEmail() == null) ||(employee.getEmail().isEmpty() ))
			return false;
		
		if ((employee.getPosition() == null) ||(employee.getPosition().isEmpty() ))
			return false;
		
		return status ; 
	}

}
