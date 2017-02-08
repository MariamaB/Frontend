package org.htw.fiw.vs;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.htw.fiw.vs.team1.ButtonInterface;


@Path("/registry")
public class RegistryController{
	
	String wasPressed=" ";

	@GET
	public String sendRegistryContent() throws RemoteException, MalformedURLException, NotBoundException {
		IBinder registry = (IBinder) Naming.lookup("rmi://141.45.214.93/binder");
		 String[] list = registry.list();
		 
		 String registredElement = "";
		 int i = 1;
		 for (String elm : list) {
			 System.out.println(elm);
			 registredElement = registredElement+"<br />"+i+"."+elm;
			 
			 ButtonInterface btn = (ButtonInterface) registry.lookup(elm);
			 i++;
		 }
		return new MyHtml().getHtml(registredElement, wasPressed);
	}

	
	
//	@GET
//	@Path("/{user}")
//	public String hello(@PathParam("user") String user) {
//		return "hello " + user;
//	}
	
	public void wasPressed(String name, Date date) throws MalformedURLException, RemoteException, NotBoundException{
		
		wasPressed =" " + name + "was pressed at: " + date + "<br />" + wasPressed;
		System.out.println(wasPressed);
	}


	


}
