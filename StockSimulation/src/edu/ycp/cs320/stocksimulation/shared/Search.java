package edu.ycp.cs320.stocksimulation.shared;

/**
 * This class allows the user to search for a specific type of stockby using common name or ticker symbol
 * @author hdao2
 *
 */
public class Search {
	
	private String symbol;
	
	public Search() {
		
	}
	
	public Search( String symbol ) {
		this.symbol = symbol;
	}
	
	public void setSearch( String symbol ) {
		this.symbol = symbol;
	}
	
	public String getSearch() {
		return symbol;
	}

}
