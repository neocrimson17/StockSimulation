package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.IDatabase;
import edu.ycp.cs320.stocksimulation.shared.Login;

public class GetRegistration {
	public boolean getRegistration(String username, String password, String confirmPassword) {
		IDatabase db = DatabaseProvider.getInstance();
		return db.postLogin(username, password, confirmPassword);
	}
}
