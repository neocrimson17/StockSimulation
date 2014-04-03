package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.IDatabase;
import edu.ycp.cs320.stocksimulation.shared.Login;

public class AccountRegistration {
	public Login accountRegister(String user, String pass){
		
		IDatabase db = DatabaseProvider.getInstance();
		return db.postLogin(user, pass);
	}
}
