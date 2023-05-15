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

public class GetList implements IConstant {

	public static void main(String[] args) {

		
		String path = "/list"; 
		WebTarget target = JerseyClient.init(CRUD_R,path);
		
		Response response = target.request(MEDIA_TYPE_JSON).accept(MEDIA_TYPE_JSON).get();
		
		JerseyClient.doneList(response) ;
		
	}

	
	
	
}
