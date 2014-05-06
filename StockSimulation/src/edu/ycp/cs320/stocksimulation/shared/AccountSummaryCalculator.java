package edu.ycp.cs320.stocksimulation.shared;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * This class is responsible for calculating the account summary
 * @author hdao2
 *
 */
public class AccountSummaryCalculator {
	public AccountSummary calculate(Account account, long beginTimestamp, long endTimestamp) {
		List<Transaction> transactionList = account.getTransactionList();
		
		Money totalCash = new Money();
		
		// Keep track of which stocks the user owned
		StockPortfolio stockPortfolio = new StockPortfolio();
		
		for (Transaction txn : transactionList) {
			if (txn.getTimestamp() >= beginTimestamp && txn.getTimestamp() <= endTimestamp) {
				// based on type of transaction, update total cash
				
				if (txn instanceof CashTransaction) {
					CashTransaction cashTxn = (CashTransaction) txn;
					System.out.print("Processing " + txn.getClass().getSimpleName() + ": " + totalCash.getAmount() + " => ");
					totalCash = cashTxn.moneyTransaction(totalCash);
					System.out.println(totalCash.getAmount());
				} else if (txn instanceof StockTransaction) {
					
					StockTransaction stockTxn = (StockTransaction) txn;
					// ...update stockPortfolio...
					stockTxn.stockTransaction(stockPortfolio);
				
				}
			}
			
		}
		
		AccountSummary result = new AccountSummary();
		result.setAmountMoney(totalCash);
		
		//set total stock value
		result.setAmountStock(stockPortfolio);
		
		return result;
	}
}
