package edu.ycp.cs320.stocksimulation.shared;


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
