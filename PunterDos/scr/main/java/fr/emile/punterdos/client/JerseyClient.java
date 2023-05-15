package fr.emile.punterdos.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.emile.punterdos.common.IConstant;
import fr.emile.punterdos.common.Utils;
import fr.emile.punterdos.entity.Employee;

public class JerseyClient implements IConstant {

	public static WebTarget init(String crudAction, String path) {
	
		ClientConfig config = new ClientConfig().register(LoggingFeature.class);
		Client client = ClientBuilder.newClient(config);
		Utils.trace(String.format("%s%s/%s%s ",LINK_SERVER,ENTITY_CLASS, crudAction,path));
		return  client	.target(LINK_SERVER)
						.path(ENTITY_CLASS)
						.path(crudAction)
						.path(path);
		
	}



	public static void done (Response response) {

		if (response.getStatus() == 200) {
			Employee employee = response.readEntity(Employee.class);
			Utils.trace(employee.toString());

		} else {
			String message = response.readEntity(String.class);
			Utils.trace(response.getStatus()+": "+message);

		}
	}

	
	public static void doneList (Response response) {
		List<Employee>  employeeList ; 
		if ((response.getStatus()>=200)&& (response.getStatus()<300)) {
			employeeList = response.readEntity(new GenericType<List<Employee>>() {});
	
			Utils.trace("status : " + response.getStatus());
			for (Employee employee : employeeList) {
				Utils.trace(employee.toString());
			}
			
		}else {
			String message = response.readEntity(String.class);
			Utils.trace(response.getStatus()+": "+message);
			
		}
	}
	
}
