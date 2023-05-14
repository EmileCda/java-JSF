package fr.emile.punter.client;

import javax.ws.rs.core.MediaType;

import fr.emile.punter.utils.Utils;

public class GetJsonOne {
public static void main(String[] args) {
		
		
		final String link = "http://localhost:9991/fabric/employee/json/1";
		String output =JerseyClient.GetOne(link,MediaType.APPLICATION_JSON);
		Utils.trace(output);
			
		}
}
