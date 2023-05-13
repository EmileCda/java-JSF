package fr.emile.punter.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.GenericType;

import fr.emile.punter.common.IConstant;
import fr.emile.punter.entity.Employee;
import fr.emile.punter.utils.Utils;

public class GetObjectListXml implements IConstant {

	
	public static void main(String[] args) {
		final String link = "http://localhost:9991/fabric/employee/list";
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = JerseyClient.GetList(link,MediaType.APPLICATION_XML);
		
		for (Employee oneEmployee : employeeList) {
			
			Utils.trace(oneEmployee.toString());
			
		}
		
		System.exit(0);
	}
}