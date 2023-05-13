package fr.emile.punter.client;


import javax.ws.rs.core.MediaType;


import fr.emile.punter.utils.Utils;

public class GetStringOneXml {

	public static void main(String[] args) {
		
		
		final String link = "http://localhost:9991/fabric/employee/xml/1";
		String output =JerseyClient.GetOne(link,MediaType.APPLICATION_XML);
		Utils.trace(output);
			
		}

}
