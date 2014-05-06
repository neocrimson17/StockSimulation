package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.IDatabase;
import edu.ycp.cs320.stocksimulation.shared.Account;
import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.AccountSummaryCalculator;
import edu.ycp.cs320.stocksimulation.shared.Stock;

public class SellStockController {
	public AccountSummary sellStock(String username, int amount, Stock stockType) {
		IDatabase db = DatabaseProvider.getInstance();
		
		if (!db.sellStock(username, amount, stockType)) {
			System.out.println("Sell stock failed?");
			return null;
		}
		
		// Return an AccountSummary that will return (for example) the amount
		// of cash that the account contains
		AccountSummaryCalculator calc = new AccountSummaryCalculator();
		Account account = new Account();
		account.addAllTransactions(db.getTransactionsForAccount(username));
		return calc.calculate(account, 0L, Long.MAX_VALUE);
	}
}
