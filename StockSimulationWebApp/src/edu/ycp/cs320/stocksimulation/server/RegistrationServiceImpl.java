package edu.ycp.cs320.stocksimulation.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.stocksimulation.client.LoginService;
import edu.ycp.cs320.stocksimulation.client.RegistrationService;
import edu.ycp.cs320.stocksimulation.server.controllers.GetRegistration;
/**
 * Allow a user to register an account 
 * @author hdao2
 *
 */
public class RegistrationServiceImpl extends RemoteServiceServlet implements
RegistrationService{

	@Override
	public boolean register(String username, String password, String confirmPassword) {
		System.out.println("Attempt to register user: " + username + ", password: "+password);
		
		GetRegistration controller = new GetRegistration();
		return controller.getRegistration(username, password, confirmPassword);
	}

}
