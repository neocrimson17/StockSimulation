package edu.ycp.cs320.stocksimulation.shared;

/**
 * Represents a stock.
 * 
 * @author kmusco
 */
public class Stock {
	// Add changed
	private String getName;
	private String getSymbol;
	
	public void getName(String name){
		this.getName = name;
	}
	
	public void getSymbol(String symbol){
		this.getSymbol = symbol;
	}

}
