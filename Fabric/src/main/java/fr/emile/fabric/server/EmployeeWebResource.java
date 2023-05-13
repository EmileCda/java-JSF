package fr.emile.fabric.server;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import fr.emile.fabric.entity.Employee;
import fr.emile.fabric.utils.DataTest;
import fr.emile.fabric.utils.Utils;
import fr.emile.fabric.common.IConstant;

@Path("employee")
@Produces(MediaType.TEXT_PLAIN +fr.emile.fabric.common.IConstant.CHARSET_UTF8)  // produces by default if ommited in methode
public class EmployeeWebResource implements IEmployeeWebResource, IConstant {


	@Override
	@GET
	@Produces(MediaType.TEXT_PLAIN + CHARSET_UTF8) // return a string so Text_Plain
	public String getInfo() {
		Utils.trace("getInfo");

		return "Web service powered with REST jersey";
	}

	@Override
	@GET
	@Path("xml/{id}")
	@Produces(MediaType.APPLICATION_XML + CHARSET_UTF8)

	public String getXmlEmployee(@PathParam("id") Integer id) {
		Employee employee = new Employee(DataTest.firstname(), DataTest.lastname(),DataTest.position());
		employee.setId(id);		
		Utils.trace("getXmlEmployee ");
		Utils.trace(employee.toString());
		return employee.toXml(); 
	}

	@Override
	@GET
	@Path("json/{id}")
	@Produces({  MediaType.APPLICATION_JSON + CHARSET_UTF8,MediaType.APPLICATION_XML + CHARSET_UTF8 })
	public String getJsonEmployee(@PathParam("id") Integer id) {
		Utils.trace("getJsonEmployee");
		Employee employee = new Employee(DataTest.firstname(), DataTest.lastname(),DataTest.position());
		employee.setId(id);		
		Utils.trace(employee.toString());
		return employee.toJson(); 
	}

	@Override
	@GET
	@Path("id/{id}")
	@Produces({ MediaType.APPLICATION_XML + CHARSET_UTF8, MediaType.APPLICATION_JSON + CHARSET_UTF8 })
	public Response getEmployeeJsonToResponse(@PathParam("id") Integer id) {

		Employee employee = new Employee(DataTest.firstname(), DataTest.lastname(),DataTest.position());
		employee.setId(id);
		Utils.trace(employee.toString());
		return Response.ok().entity(employee).build();

	}

	@Override
	@GET
	@Path("list")
//	@Produces({ MediaType.APPLICATION_XML + CHARSET_UTF8, MediaType.APPLICATION_JSON + CHARSET_UTF8 })
	@Produces({  MediaType.APPLICATION_JSON + CHARSET_UTF8,MediaType.APPLICATION_XML + CHARSET_UTF8 })
	public List<Employee> getEmployeeList() {

		List<Employee> employeeList = new ArrayList<Employee>();

		Employee employee;
		
		for (int index = 1; index <= 10; index++) {
			employee = new Employee(DataTest.firstname(), DataTest.lastname(),DataTest.position());
			employee.setId(index);
			employeeList.add(employee);
		}

		return employeeList;
	}
	@Override
	@GET
	@Path("xml/list")
	@Produces( MediaType.APPLICATION_XML + CHARSET_UTF8 )
	public List<Employee> getEmployeeXmlList() {
		return this.getEmployeeList();
	}

	@Override
	@GET
	@Path("json/list")
	@Produces( MediaType.APPLICATION_JSON + CHARSET_UTF8 )
	public List<Employee> getEmployeeJsonList() {

		return this.getEmployeeList();
	}

	@Override
	@POST
	@Path("add")
//	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Consumes({ MediaType.APPLICATION_XML + CHARSET_UTF8, MediaType.APPLICATION_JSON + CHARSET_UTF8 })
	@Produces({ MediaType.APPLICATION_XML + CHARSET_UTF8, MediaType.APPLICATION_JSON + CHARSET_UTF8 })
	public Response addEmployee(Employee employee) throws URISyntaxException {
		Utils.trace("addEmployee");
		Utils.trace(employee.toString());

		employee.setId(100);
		return Response.status(Status.CREATED).entity(employee).build();
	}

	@Override
	@PUT
	@Path("update")
	@Consumes({ MediaType.APPLICATION_XML + CHARSET_UTF8, MediaType.APPLICATION_JSON + CHARSET_UTF8 })
	@Produces({ MediaType.APPLICATION_XML + CHARSET_UTF8, MediaType.APPLICATION_JSON + CHARSET_UTF8 })
	public Response updateEmployee(Employee employee) throws URISyntaxException {
		Utils.trace("updateEmployee");
		Utils.trace(employee.toString());

		employee.setId(100);
		return Response.status(Status.ACCEPTED).entity(employee).build();
	}

	@Override
	@DELETE
	@Path("remove/{id}")
	@Produces({ MediaType.APPLICATION_XML + CHARSET_UTF8, MediaType.APPLICATION_JSON + CHARSET_UTF8 })
	public Response removeEmployee(@PathParam("id") Integer id) throws URISyntaxException {
		Utils.trace("removeEmployee");
		
		Employee employee = new Employee(DataTest.firstname(), DataTest.lastname(),DataTest.position());
		employee.setId(id);

		Utils.trace(employee.toString());
		return Response.status(Status.ACCEPTED).entity(employee).build();
	}

}
