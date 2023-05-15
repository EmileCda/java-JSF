package fr.emile.punterdos.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import fr.emile.punterdos.common.DataTest;
import fr.emile.punterdos.entity.Employee;
import fr.emile.punterdos.enums.HttpStatusCode;
import fr.emile.punterdos.common.IConstant;
import fr.emile.punterdos.common.Utils;

public class Update implements IConstant {

	public static void main(String[] args) {

		Integer id = 3;
		String path = ""; 
		WebTarget target = JerseyClient.init(CRUD_U,path);
		
		Utils.trace(LINK_SERVER+ENTITY_CLASS+"/"+CRUD_U+"/"+path);
		
		Employee employee = DataTest.genEmployee();

		Response response = target.request(MEDIA_TYPE_JSON)
				.put(Entity.entity(employee, MEDIA_TYPE_JSON));
		
		JerseyClient.done(response) ;
			
	}
}
