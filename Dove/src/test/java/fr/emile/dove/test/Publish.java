package fr.emile.dove.test;

import javax.xml.ws.Endpoint;

import fr.emile.dove.utils.Utils;
import fr.emile.dove.webservice.StudentWebService;

public class Publish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		try {
			Utils.trace("Start Web service ...");
			Endpoint.publish("http://loalhost:9991/ws/StudentWebService", 
					new StudentWebService());
					
			Utils.trace(" Web service Started");
			
		} catch (Exception e) {
			Utils.trace(" erreur Web service "+ e.toString());
			
		}
		
		
	}

}
