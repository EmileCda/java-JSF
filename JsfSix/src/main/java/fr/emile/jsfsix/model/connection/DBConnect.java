package fr.emile.jsfsix.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBConnect {
	private DBConnect() {
	}


	//---------------processing methode ---------------------
public static Connection  getConnection() throws Exception {
	ResourceBundle  myResource = ResourceBundle.getBundle("Enroll"); // retreive data from Dbase.properties

	String user = myResource.getString("user");
	String pass= myResource.getString("password");
	String stringConnection = myResource.getString("stringConnection");
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection myConection = DriverManager.getConnection(stringConnection,user, pass );

	return myConection ;
}

}
