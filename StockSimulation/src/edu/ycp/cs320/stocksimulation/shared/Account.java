package edu.ycp.cs320.stocksimulation.shared;
/**
 * This class represents the account the user has which contains
 * all the transactions up to this point
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Account {
	private List<Transaction> transactionList;
	
	public Account() {
		this.transactionList = new ArrayList<Transaction>();
	}
	
	public void addTransaction(Transaction txn) {
		transactionList.add(txn);
	}
	
	public void addAllTransactions(Transaction[] transactionList) {
		this.transactionList.addAll(Arrays.asList(transactionList));
	}
	
	public List<Transaction> getTransactionList() {
		return Collections.unmodifiableList(transactionList);
	}
}
