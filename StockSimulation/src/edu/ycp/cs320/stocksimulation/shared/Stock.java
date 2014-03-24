package edu.ycp.cs320.stocksimulation.shared;

/**
 * Represents a stock.
 * 
 * @author kmusco
 */
public class Stock {
	
	// fields
	private Integer stockAmount;
	private String stockName;
	private String tickerSymbol;
	
	// constructor
	public Stock(){
		
	}
	
	// get the type of the stock
	public String getName(){
		return stockName;
	}
	// set the type of stock 
	public void setName(String name){
		this.stockName = name;
	}
	// set the  symbol (a ticker of sort)
	// example: Google will be "GOOG"
	public void setSymbol(String symbol){
		this.tickerSymbol = symbol;
	}
	
	// get the ticker symbol for the stock
	public String getSymbol(){
		return tickerSymbol;
	}
	
	// method to get a stock amount
	public int getStockAmount(){
		return stockAmount;
	}
	
	// method to set the amount of stock
	public void setStockAmount(int amount){
		this.stockAmount = amount;
	}

}
