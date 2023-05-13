
import fr.emile.punter.common.IConstant;
import fr.emile.punter.utils.Utils;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;


public class GetJson implements IConstant {


	public static void main(String[] args) {
	
		final String link = "http://localhost:9991/fabric/employee/json/1";
		
		String output =JerseyClient.GetOne(link,MediaType.APPLICATION_JSON);
		Utils.trace(output);
		
	}


	
	
	public void testOne() {
		ClientConfig clientConfig = new DefaultClientConfig();

		clientConfig.getClasses().add(JacksonJsonProvider.class);
		
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource(link);
		
		Builder builder = webResource.accept(MediaType.APPLICATION_JSON)
										.header("content-type",MediaType.APPLICATION_JSON)
										.header("infor-perso","Autre information");
							

		ClientResponse response = builder.get(ClientResponse.class); 
		Utils.trace(String.format("Status %d ", response.getStatus()));
		
		
		if (response.getStatus() != 200) {
			Utils.trace(String.format("error : %d ", response.getStatus()));
			String error = response.getEntity(String.class);
			Utils.trace(String.format("error : %s ", error ));
			System.exit(ERROR);
			
		}
		
		String output = response.getEntity(String.class);  // return value as a string 
		Utils.trace(String.format("code status  %d  OK", response.getStatus()));
		Utils.trace("Output from server");
		Utils.trace(output);
		
	}

}
