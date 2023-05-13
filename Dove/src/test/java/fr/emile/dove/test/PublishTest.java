package fr.emile.dove.test;

import javax.xml.ws.Endpoint;

import fr.emile.dove.utils.Utils;
import fr.emile.dove.webservice.StudentWebService;

public class PublishTest {

	public static void main(String[] args) {

		try {
			Utils.trace("Expose web service StudentWebServices ...");
			String link = "http://localhost:9991/ws/StudentWebService";
			Endpoint.publish(link, new StudentWebService());

			Utils.trace("web service StudentWebServices online");
			Utils.trace("Link to web-service : " + link);
			Utils.trace("Link to interface web-service : " + link + "?wsdl");

		} catch (Exception e) {
			Utils.trace("ERROR : WebServices not found ");
			e.printStackTrace();
		}

	}

}
