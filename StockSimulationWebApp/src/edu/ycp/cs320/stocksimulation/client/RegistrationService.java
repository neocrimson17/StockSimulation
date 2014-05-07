package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.stocksimulation.client.LoginService;
import edu.ycp.cs320.stocksimulation.server.controllers.GetLogin;
import edu.ycp.cs320.stocksimulation.shared.Login;

@RemoteServiceRelativePath("register")
public interface RegistrationService extends RemoteService{
	public boolean register(String username, String password, String confirmPassword);
}
