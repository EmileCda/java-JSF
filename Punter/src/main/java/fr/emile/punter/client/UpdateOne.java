package fr.emile.punter.client;

import javax.ws.rs.core.MediaType;

import fr.emile.punter.entity.Employee;
import fr.emile.punter.utils.DataTest;
import fr.emile.punter.utils.Utils;

public class UpdateOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String link = "http://localhost:9991/fabric/employee/update";
		Employee employeetoUpdate = new Employee(DataTest.firstname(), DataTest.lastname(),DataTest.position());
		String output =JerseyClient.updateOne(link,MediaType.APPLICATION_XML,employeetoUpdate);
		Utils.trace(output);
	}

}
