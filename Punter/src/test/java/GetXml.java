

import java.net.URI;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import fr.emile.punter.utils.Utils;

public class GetXml {

	public static void main(String[] args) {
		
		
		final String link = "http://localhost:9991/fabric/employee/xml/1";
		Client client =Client.create();
		
		WebResource webResource = client.resource(link);
		Builder builder = webResource.accept(MediaType.APPLICATION_XML)
							.header("content-type",MediaType.APPLICATION_XML);

		ClientResponse response = builder.get(ClientResponse.class);
		
		if (response.getStatus() != 200) {
			Utils.trace(String.format("error : %d ", response.getStatus()));
			String error = response.getEntity(String.class);
			Utils.trace(String.format("error : %s ", error ));
			System.exit(1);
			
		}
		
		String output = response.getEntity(String.class);
		
		Utils.trace(String.format("code status  %d  OK", response.getStatus()));
		
		Utils.trace("Output from server");
		Utils.trace(output);
		
	}

}
