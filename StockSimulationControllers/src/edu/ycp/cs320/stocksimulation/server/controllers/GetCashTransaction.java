package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.IDatabase;

public class GetCashTransaction {
	
		public boolean cashDeposit(String username, int ammount) {
			IDatabase db = DatabaseProvider.getInstance();
			return db.cashDeposit(username, ammount);
		}
		
		public boolean cashWithdrawal( String username, int ammount ) {
			IDatabase db = DatabaseProvider.getInstance();
			return db.cashWithdrawal(username, ammount);
	}

}
