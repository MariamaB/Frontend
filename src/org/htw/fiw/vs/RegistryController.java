package org.htw.fiw.vs;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/registry")
public class RegistryController{

	@GET
	public String sendRegistryContent() throws RemoteException, MalformedURLException, NotBoundException {

		IBinder registry = (IBinder) Naming.lookup("rmi://141.45.209.97/binder");
		 String[] list = registry.list();
		 
		 String s = "Registered elements: ";
		 int i = 1;
		 for (String elm : list) {
			 System.out.println(elm);
			 s = s+"<br />"+i+"."+elm;
			 i++;
		 }
		 
		 return s;
		// return Response.status(200).entity("<html> " + "<title>" + "Hello HTML Response" + "</title><body><div "+"Style = background-color: black" +">"+s+"</div></body></html>").build();
		//return ResponseEntity.created().header("MyResponseHeader", "MyValue").body("Hello World"); 
	}

	
	
//	@GET
//	@Path("/{user}")
//	public String hello(@PathParam("user") String user) {
//		return "hello " + user;
//	}

}
