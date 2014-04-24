package edu.ycp.cs320.stocksimulation.shared;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stock.
 * 
 * @author kmusco
 */
public class Stock {
	
	// fields
	private Integer stockPrice;
	private String stockName;
	private String tickerSymbol;
	
	// Length of the list determines how many shares there are. Value of entry
	// determines the price of each share.
	List<Long> shares = new ArrayList<Long>(); 
	// constructor
	public Stock(){
	}
	
	// Return the list of shares
	public List<Long> getShares(){
		return shares;
	}
	
	// get the name of the stock
	public String getName(){
		return stockName;
	}
	// set the name of stock 
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
	
	// method to get a stock price
	public int getStockPrice(){
		return stockPrice;
	}
	
	// method to set the price of stock
	public void setStockPrice(int price){
		this.stockPrice = price;
	}
	
}
