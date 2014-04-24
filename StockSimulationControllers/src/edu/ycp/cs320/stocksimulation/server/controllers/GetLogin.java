package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.IDatabase;

public class GetLogin {
	public boolean getLogin(String username, String password) {
		IDatabase db = DatabaseProvider.getInstance();
		return db.getLogin(username, password);
	}
}
