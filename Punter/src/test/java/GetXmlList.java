

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

public class GetXmlList implements IConstant {

	
	public static void main(String[] args) {
		final String link = "http://localhost:9991/fabric/employee/list";
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getClasses().add(JacksonJsonProvider.class);

		Client client = Client.create(clientConfig);
		
		WebResource webResource = client.resource(link);
		Builder builder = webResource.accept(MediaType.APPLICATION_XML)
									.header("content-type",MediaType.APPLICATION_XML)
									.header("infor-perso","Autre information");
							

		ClientResponse response = builder.get(ClientResponse.class);
		Utils.trace(String.format("Status %d ", response.getStatus()));
		
	
		if (response.getStatus() != 200) {
			Utils.trace(String.format("error : %d ", response.getStatus()));
			String error = response.getEntity(String.class);
			Utils.trace(String.format("error : %s ", error ));
			System.exit(ERROR);
			
		}
		
		Utils.trace(String.format("error :  "));
		List<Employee> employeeList = new ArrayList<Employee>(); 
				
		employeeList =response.getEntity(new GenericType<List<Employee>>() {});
		Utils.trace(String.format("error :  "));
		
		
		Utils.trace(String.format("code status  %d  OK", response.getStatus()));
		
		Utils.trace("Output from server");
		for (Employee oneEmployee : employeeList) {
			
			Utils.trace(oneEmployee.toString());
			
		}
		
		System.exit(0);
	}
}