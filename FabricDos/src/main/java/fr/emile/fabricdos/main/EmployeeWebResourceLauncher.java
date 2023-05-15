package fr.emile.fabricdos.main;

import java.net.URI;

import javax.ws.rs.ApplicationPath;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import fr.emile.fabricdos.common.IConstant;
import fr.emile.fabricdos.common.Utils;


public class EmployeeWebResourceLauncher implements IConstant {

	public static void main(String[] args) {

		final URI BASE_URI = URI.create(LINK_SERVER);

		try {

			ResourceConfig config = new  ResourceConfig().packages(PACK_NAME);
			ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();

			Utils.trace(String.format(" Starting serveur :  %s ", BASE_URI));

			HttpServer myHttpServer = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config);

			Utils.trace("Creating ...");
			myHttpServer.start();
			Thread.sleep(2000);

			Utils.trace(String.format("Jersey started \n  \tWADM here: %s \n\tCheck: %s/application.wadl", BASE_URI, BASE_URI));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
