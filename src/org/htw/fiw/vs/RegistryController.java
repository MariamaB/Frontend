package org.htw.fiw.vs;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.htw.fiw.vs.team1.ControllerInterface;


@Path("/registry")
public class RegistryController{
	
	private static String dropdown() {
		return "<select name=\"pattern\"><option value=\"no-pattern\">No Pattern</option><option value=\"blink\">Blink</option></select>";
	}
	
	@GET
	public String sendRegistryContent(@QueryParam("name") String name) throws RemoteException, MalformedURLException, NotBoundException {
	
		IBinder registry = (IBinder) Naming.lookup("rmi://localhost/binder");
		String[] list = registry.list();
		
		ControllerInterface ci = (ControllerInterface) registry.lookup("controller");
		ci.printFromServer(name);
		
		String registeredElement = printList(list);
		return new MyHtml().getHtml(registeredElement);
	}
	
	
	@POST
	public String sendData() throws MalformedURLException, RemoteException, NotBoundException {
		IBinder registry = (IBinder) Naming.lookup("rmi://localhost/binder");

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
				 registeredElement = registeredElement + "<br/>"+ i + "." + elm + RegistryController.dropdown() + "<button type=\"submit\" name=\"name\" value=\"" + elm +"\"" + "\">Click</button>";
			 }
			 else {
				 registeredElement = registeredElement+"<br />"+i+"."+elm;
			 }
			 i++;
		 }
		return registeredElement;
	}

}
