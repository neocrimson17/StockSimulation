package edu.ycp.cs320.stocksimulation.shared;

public class AccountSummary {
	
	private int cash;
	private int stockWorth;
	private String timeStamp;
	
	public void getCash(int cash){
		this.cash = cash;
	}
	
	public void getStockWorth(int stockWorth){
		this.stockWorth = stockWorth;
	}
	
	public void getTimeStamp(String timeStamp){
		this.timeStamp = timeStamp;
	}

}
