package org.htw.fiw.vs;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class RestServer {
	public static void main(String[] args) throws InterruptedException, IOException {
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8099"),
				new ResourceConfig(RegistryController.class));

		System.out.println("Press any key to close");
		System.in.read();
		server.stop();
	}
}
