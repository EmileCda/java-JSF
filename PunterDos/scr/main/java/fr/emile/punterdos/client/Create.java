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

public class Create implements IConstant {

	public static void main(String[] args) {

		
		WebTarget target = JerseyClient.init(CRUD_C,"");
		Utils.trace(LINK_SERVER+ENTITY_CLASS+"/"+CRUD_C + "");
		Employee employee = DataTest.genEmployee();

		Response response = target.request(MEDIA_TYPE_JSON)
				.post(Entity.entity(employee, MEDIA_TYPE_JSON));
		
		JerseyClient.done(response) ;
	
	}
	
	
	
}
