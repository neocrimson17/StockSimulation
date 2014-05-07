package edu.ycp.cs320.stocksimulation.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stock.
 * 
 * @author kmusco
 */
public class Stock implements Serializable {
	
	// fields
	private int id;
	private String stockName;
	private String tickerSymbol;
	
	// constructor
	public Stock(){
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
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
	
}
