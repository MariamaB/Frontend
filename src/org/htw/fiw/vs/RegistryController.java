package org.htw.fiw.vs;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.internal.RuntimeExecutorsBinder.BackgroundSchedulerLiteral;

@Path("/registry")
public class RegistryController{

	@GET
	//@Produces( MediaType.TEXT_HTML_TYPE )
	public String sendRegistryContent() throws RemoteException, AlreadyBoundException, UnknownHostException {

		Registry registry = LocateRegistry.getRegistry(3000);
	//	Registry registry = LocateRegistry.createRegistry(3000/*Registry.REGISTRY_PORT*/);
		//registry.bind("lamp/"+InetAddress.getLocalHost().getHostName(), this);
	//	registry.bind("button", this);
		 String[] list = registry.list();
		 String s = "Registered elements: ";
		 int i = 1;
		 for (String elm : list) {
			 System.out.println(elm);
			 s = s+"<br />"+i+"."+elm;
			 i++;
		 }
		// return Response.status(200).entity("<html> " + "<title>" + "Hello HTML Response" + "</title><body><div "+"Style = background-color: black" +">"+s+"</div></body></html>").build();
		return s;
		//return ResponseEntity.created().header("MyResponseHeader", "MyValue").body("Hello World");
	}

	@GET
	@Path("/{user}")
	public String hello(@PathParam("user") String user) {
		return "hello " + user;
	}

}
