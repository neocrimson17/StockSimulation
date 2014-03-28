package edu.ycp.cs320.stocksimulation.shared;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the Account Summary.
 * 
 * @author kmusco
 */

public class AccountSummary {
	
	private int cash;
	private long timeStamp;
	
	List<shares> shares = Stock.getShares()
	
	// Map of stocks and how much of each are owned
	//Map<String, List<Stock>> stocksOwned = new HashMap<String, List<Stock>>();
	
	public AccountSummary(){
		
	}
	
	
	// Set cash total
	public void setCash(int cash){
		this.cash = cash;
	}
	
	// Get cash total
	public int getCash(int cash){
		return cash;
	}
	
	
	// Get worth of all stocks
	public long getAccountWorth(){
		
		return AccountSummaryCalculator
		
		
	}
	
	// Get date
	public void getTimeStamp(long timeStamp){
		this.timeStamp = timeStamp;
	}

}
