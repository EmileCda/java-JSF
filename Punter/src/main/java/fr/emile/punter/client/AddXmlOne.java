package fr.emile.punter.client;

import javax.ws.rs.core.MediaType;

import fr.emile.punter.entity.Employee;
import fr.emile.punter.utils.DataTest;
import fr.emile.punter.utils.Utils;

public class AddXmlOne {
public static void main(String[] args) {
		
		
		final String link = "http://localhost:9991/fabric/employee/add";
		Employee employeetoAdd = new Employee(DataTest.firstname(), DataTest.lastname(),DataTest.position());
		String output =JerseyClient.AddOne(link,MediaType.APPLICATION_XML,employeetoAdd);
		Utils.trace(output);
			
		}
	
}
