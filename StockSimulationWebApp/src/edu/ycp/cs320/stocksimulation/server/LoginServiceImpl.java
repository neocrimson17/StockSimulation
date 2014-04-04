package edu.ycp.cs320.stocksimulation.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.stocksimulation.client.LoginService;
import edu.ycp.cs320.stocksimulation.server.controllers.GetLogin;
import edu.ycp.cs320.stocksimulation.shared.Login;

public class LoginServiceImpl extends RemoteServiceServlet implements
		LoginService {

	@Override
	public boolean login(String username, String password) {
		System.out.println("Attempt to log in, username=" + username + ", password="+password);
		
		GetLogin controller = new GetLogin();
		boolean result = controller.getLogin(username, password);
		if (!result) {
			System.out.println("No such username/password?");
		}
		return result;
	}

}
