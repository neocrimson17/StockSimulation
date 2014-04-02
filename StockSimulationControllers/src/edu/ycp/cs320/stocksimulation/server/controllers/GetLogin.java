package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.Database;
import edu.ycp.cs320.stocksimulation.server.model.persist.IDatabase;
import edu.ycp.cs320.stocksimulation.shared.Login;

public class GetLogin {
	public boolean getLogin(String username, String password) {
		IDatabase db = Database.getInstance();
		return db.getLogin(username, password);
	}
	
	public Login doPostReguest(String user, String pass){
		
		IDatabase db = Database.getInstance();
		return db.postLogin(user, pass);
	}
}
