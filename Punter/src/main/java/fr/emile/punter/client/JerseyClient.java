package fr.emile.punter.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import fr.emile.punter.common.IConstant;
import fr.emile.punter.entity.Employee;
import fr.emile.punter.utils.Utils;

public class JerseyClient implements IConstant {
	
	
	
	public static String  GetOne(String link, String typeOfMedia) {

		ClientConfig clientConfig = new DefaultClientConfig();

		clientConfig.getClasses().add(JacksonJsonProvider.class);
		
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(link);
		
		Builder builder = webResource.accept(typeOfMedia)
										.header("content-type",typeOfMedia)
										.header("infor-perso","Autre information");
							

		ClientResponse response = builder.get(ClientResponse.class); 
		
		
		if (response.getStatus() != 200) {
			String error = response.getEntity(String.class);
			Utils.trace(error);
			System.exit(ERROR);
		}
		
		
		return response.getEntity(String.class);  // return value as a string
		
		
		
	}
	
	public static List<Employee>  GetList(String link, String typeOfMedia) {

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getClasses().add(JacksonJsonProvider.class);

		Client client = Client.create(clientConfig);
		
		WebResource webResource = client.resource(link);
		Builder builder = webResource.accept(typeOfMedia)
									.header("content-type",typeOfMedia)
									.header("infor-perso","Autre information");
							

		ClientResponse response = builder.get(ClientResponse.class);
		
	
		if (response.getStatus() != 200) {
			Utils.trace(String.format("error : %d ", response.getStatus()));
			String error = response.getEntity(String.class);
			Utils.trace(String.format("error : %s ", error ));
			return null;
		}
		
		List<Employee> employeeList = new ArrayList<Employee>(); 
				
		employeeList =response.getEntity(new GenericType<List<Employee>>() {});
		return employeeList;
		
		
	}


}
