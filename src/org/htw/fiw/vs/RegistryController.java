package org.htw.fiw.vs;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


@Path("/registry")
public class RegistryController{
	
	private static String dropdown() {
		return "<select><option value=\"muster1\">Muster1</option><option value=\"an-aus\">An Aus</option></select>";
	}
	
	@GET
	public String sendRegistryContent() throws RemoteException, MalformedURLException, NotBoundException {

		IBinder registry = (IBinder) Naming.lookup("rmi://141.45.213.212/binder");
		String[] list = registry.list();
		 
		 String registredElement = "";
		 int i = 1;
		 for (String elm : list) {
			 System.out.println(elm);
			 if (elm.contains("button")) {
				 registredElement = registredElement + "<br/>"+ i + "." + elm + RegistryController.dropdown() + "<button type=\"submit\" name=\"" + elm + "\">Click</button>";
			 }
			 else {
				 registredElement = registredElement+"<br />"+i+"."+elm;
			 }
			 i++;
		 }
		return new MyHtml().getHtml(registredElement);
	}
	
	@POST
	public String hello() {
		System.out.println("Hallo POST");
		return "hello";
	}

}
