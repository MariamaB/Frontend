package org.htw.fiw.vs;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/registry")
public class RegistryController{


	@GET
	public String sendRegistryContent() throws RemoteException, MalformedURLException, NotBoundException {
		IBinder registry = (IBinder) Naming.lookup("rmi://141.45.205.36/binder");
		 String[] list = registry.list();
		 
		 String registredElement = "";
		 int i = 1;
		 for (String elm : list) {
			 System.out.println(elm);
			 registredElement = registredElement+"<br />"+i+"."+elm;
			 
			 i++;
		 }

		return new MyHtml().getHtml(registredElement);
	}

	
	
//	@GET
//	@Path("/{user}")
//	public String hello(@PathParam("user") String user) {
//		return "hello " + user;
//	}



	


}
