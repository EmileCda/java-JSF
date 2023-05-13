package fr.emile.punter.client;

import javax.ws.rs.core.MediaType;

import fr.emile.punter.entity.Employee;
import fr.emile.punter.utils.DataTest;
import fr.emile.punter.utils.Utils;

public class DeleteOne {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String link = "http://localhost:9991/fabric/employee/remove/1";
//		String output =JerseyClient.deleteOne(link,MediaType.APPLICATION_XML);
		String output =JerseyClient.deleteOne(link,MediaType.APPLICATION_JSON);
		Utils.trace(output);
	}

}
