package edu.ycp.cs320.stocksimulation.shared;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a portfolio a user has on his/her account
 * The portfolio contains all kind of stocks and the amount of each stock the user owned
 * @author hdao2
 *
 */
public class StockPortfolio {
	
	// Map of stock symbols to the number of shares owned
	private Map<String, Integer> stocksOwned;
	
	public StockPortfolio() {
		stocksOwned = new HashMap<String, Integer>();
	}
	
	/**
	 * Add the amount of shares to the total amount of this type of stock the user is current owned
	 * @param stock
	 * @param numShares
	 */
	public void addShares(Stock stock, int numShares) {
		Integer currentNumShares = stocksOwned.get(stock.getSymbol());
		if (currentNumShares == null) {
			currentNumShares = 0;
		}
		currentNumShares += numShares;
		stocksOwned.put(stock.getSymbol(), currentNumShares);
	}
	
	/**
	 * Subtract the amount of shares to the total amount of this type of stock the user is current owned
	 * @param stock
	 * @param numShares
	 */
	public void subtractShares(Stock stock, int numShares) {
		Integer currentNumShares = stocksOwned.get(stock.getSymbol());
		
		if (currentNumShares == null) {
			currentNumShares = 0;
		}
		
		currentNumShares -= numShares;
		if (currentNumShares < 0) {
			throw new IllegalArgumentException("The " + stock.getSymbol() + " Stock"  + " would have negative number of shares");
		}
		
		stocksOwned.put(stock.getSymbol(), currentNumShares);
	}
	/**
	 * Get the current number of shares the user has
	 * @param stock
	 * @return
	 */
	public int getNumShares(Stock stock) {
		Integer numShares = stocksOwned.get(stock.getSymbol());
		if (numShares == null) {
			return 0;
		} else {
			return numShares;
		}
	}
	
	
}
