package edu.ycp.cs320.stocksimulation.shared;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountSummaryCalculator {
	public AccountSummary calculate(Account account, StockHistory stockHistory, long beginTimestamp, long endTimestamp) {
		List<Transaction> transactionList = account.getTransactionList();
		
		Money totalCash = new Money();
		//Money totalStockValue = new Money();
		
		// map of names of stocks owned to number of shares
		Map<String, Integer> stocksOwned = new HashMap<String, Integer>();
		
		for (Transaction txn : transactionList) {
			if (txn.getTimestamp() >= beginTimestamp && txn.getTimestamp() <= endTimestamp) {
				// based on type of transaction, update total cash
				
				if (txn instanceof CashTransaction) {
					CashTransaction cashTxn = (CashTransaction) txn;
					
					totalCash = cashTxn.moneyTransaction(totalCash);
				} else if (txn instanceof StockTransaction) {
					StockTransaction stockTxn = (StockTransaction) txn;
					
					// ...update stocksOwned...
				}
			}
			
		}
		return null;
		
		// TODO: create the AccountSummary
	}
}
