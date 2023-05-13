package fr.emile.fabric.main;

import java.net.URI;

import javax.ws.rs.ApplicationPath;

import fr.emile.fabric.utils.Utils;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.core.PackagesResourceConfig;

import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;

@ApplicationPath("services")
public class EmployeeWebResourceLauncher {

	public static void main(String[] args) {

		final URI BASE_URI = URI.create("http://localhost:9991/fabric");

		try {

			String resourceName = "fr.emile.fabric.server";
			ResourceConfig config = new PackagesResourceConfig(resourceName);

			Utils.trace(String.format(" Starting serveur :  %s ", BASE_URI));

			HttpServer myHttpServer = HttpServerFactory.create(BASE_URI, config);

			Utils.trace("Created ...");
			myHttpServer.start();
			Thread.sleep(2000);
			Utils.trace("Jersey started");
			Utils.trace(String.format(" WADM here %s", BASE_URI));
			Utils.trace(String.format(" Check %s/application.wadl", BASE_URI));

			System.in.read();
			Utils.trace("Stopping ...");
			myHttpServer.stop(1);
			Thread.sleep(2000);
			Utils.trace(" Stopped");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
