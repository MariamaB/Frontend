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
		return "<select class=\"select\" name=\"pattern\">"
			+"<option value=\"no-pattern\">No Pattern</option>"
			+"<option value=\"even-odd\">Even Odd</option>"
			+"<option value=\"all-lamps\">All Lamps</option>"
			+"<option value=\"blink\">Blink</option>"
			+"<option value=\"switch-off\">Switch off</option></select>";
	}
	
	@GET
	public String sendRegistryContent(@QueryParam("name") String name, @QueryParam("pattern") String pattern) throws RemoteException, MalformedURLException, NotBoundException {
	
		IBinder registry = (IBinder) Naming.lookup("rmi://localhost/binder");
		String[] list = registry.list();
		
		ControllerInterface ci = (ControllerInterface) registry.lookup("controller");
		if (name != null && !name.isEmpty() && pattern != null && !pattern.isEmpty()) {
			ci.changePattern(name, pattern);
		}
		
		String registeredElement = printList(list);
		return new MyHtml().getHtml(registeredElement);
	}
	
	
	@POST
	public String sendData() throws MalformedURLException, RemoteException, NotBoundException {
		IBinder registry = (IBinder) Naming.lookup("rmi://141.45.251.207/binder");

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
				 registeredElement = registeredElement 
					+ "<tr><th>" 
					+ "<form style=\"margin-bottom: 1em; margin-top: 1em;\" action=\"registry\" method=\"GET\">" 
					+ i + ". " + elm 
					+ RegistryController.dropdown() 
					+ "<button class=\"btn btn-success\" type=\"submit\" name=\"name\" value=\""+ elm +"\"" + "\">Pattern anwenden</button>" 
					+ "</form>" 
					+ "</th></tr>";
			 }
			 else {
				 registeredElement = registeredElement + "<tr><th>" + i + ". " + elm + "</th></tr>";
			 }
			 i++;
		 }
		return registeredElement;
	}

}
