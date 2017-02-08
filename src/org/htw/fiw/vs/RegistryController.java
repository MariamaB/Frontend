package org.htw.fiw.vs;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.htw.fiw.vs.team1.ControllerInterface;


@Path("/registry")
public class RegistryController{
	
	private static String dropdown() {
		return "<select><option value=\"muster1\">Muster1</option><option value=\"an-aus\">An Aus</option></select>";
	}
	
	@GET
	public String sendRegistryContent() throws RemoteException, MalformedURLException, NotBoundException {

		IBinder registry = (IBinder) Naming.lookup("rmi://localhost/binder");
		String[] list = registry.list();
		 
		String registeredElement = printList(list);
		return new MyHtml().getHtml(registeredElement);
	}
	
	
	@POST
	public String sendData() throws MalformedURLException, RemoteException, NotBoundException {
		IBinder registry = (IBinder) Naming.lookup("rmi://localhost/binder");
		ControllerInterface ci = (ControllerInterface) registry.lookup("controller");
		ci.printFromServer("yes this is the server speaking");
		
		String[] list = registry.list();
		String registeredElement = printList(list);
		return new MyHtml().getHtml(registeredElement);
	}

	private String printList(String[] list) {
		String registeredElement = "";
		 int i = 1;
		 for (String elm : list) {
			 System.out.println(elm);
			 if (elm.contains("button")) {
				 registeredElement = registeredElement + "<br/>"+ i + "." + elm + RegistryController.dropdown() + "<button type=\"submit\" name=\"" + elm + "\">Click</button>";
			 }
			 else {
				 registeredElement = registeredElement+"<br />"+i+"."+elm;
			 }
			 i++;
		 }
		return registeredElement;
	}

}
