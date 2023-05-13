package fr.emile.fabric.utils;

import fr.emile.fabric.entity.Employee;



public final class Strings {

	private Strings() {
		// TODO Auto-generated constructor stub
	}

	public static String getXlmEmployee(Employee employee) {
		String stringReturn = "";

		stringReturn += String.format("<%s>\n","employee" );
		stringReturn += String.format("<id>%d</id>\n",employee.getId() );
		stringReturn += String.format("<lastname>%s</lastname>\n",employee.getLastname() );
		stringReturn += String.format("<firstname>%s</firstname>\n",employee.getLastname() );
		stringReturn += String.format("<position>%s</position>\n",employee.getPosition() );
		stringReturn += String.format("</%s>\n","employee" );
		
		
		return stringReturn;
	}

	public static  String getJsonEmploye(Employee employee) {
		String stringReturn = "";
		stringReturn += String.format("{\"id\":\"%d\",\"lastname\":\"%s\",\"firstname\":\"%s\", \"position\":\"%s\"}",
				employee.getId() ,
				employee.getLastname(),
				employee.getLastname(),
				employee.getPosition() );
		return stringReturn;
	}

}
