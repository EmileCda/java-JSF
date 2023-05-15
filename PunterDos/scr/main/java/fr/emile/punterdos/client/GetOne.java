package fr.emile.punterdos.client;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


import fr.emile.punterdos.common.IConstant;

public class GetOne implements IConstant {

	public static void main(String[] args) {
	
		Integer id = 3;
		
		String path = String.format("id/%d", id); 
		WebTarget target = JerseyClient.init(CRUD_R,path);
		
		Response response = target.request(MEDIA_TYPE_JSON).accept(MEDIA_TYPE_JSON).get();
		
		JerseyClient.done(response) ;
		
	}


}
