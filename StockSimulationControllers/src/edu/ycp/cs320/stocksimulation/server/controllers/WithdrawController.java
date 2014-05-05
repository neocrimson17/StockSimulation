package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.IDatabase;
import edu.ycp.cs320.stocksimulation.shared.Account;
import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.AccountSummaryCalculator;
import edu.ycp.cs320.stocksimulation.shared.CashTransaction;
import edu.ycp.cs320.stocksimulation.shared.Transaction;

public class WithdrawController {
	public AccountSummary cashWithdrawal(String username, int amount) {
		IDatabase db = DatabaseProvider.getInstance();
		
		if (!db.cashWithdrawal(username, amount)) {
			System.out.println("Cash withdraw failed?");
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
