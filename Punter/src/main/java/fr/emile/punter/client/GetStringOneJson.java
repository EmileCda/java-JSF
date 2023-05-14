package fr.emile.punter.client;
import fr.emile.punter.common.IConstant;
import fr.emile.punter.utils.Utils;

import javax.ws.rs.core.MediaType;



public class GetStringOneJson implements IConstant {


	public static void main(String[] args) {
		final String link = "http://localhost:9991/fabric/employee/json/1";
		String output =JerseyClient.GetOne(link,MediaType.APPLICATION_JSON);
		Utils.trace(output);
		
	}


}
