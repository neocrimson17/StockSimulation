package edu.ycp.cs320.stocksimulation.shared;

public class StockPortfolio {
	// TODO: fields
	private int numshares;
	private Stock stocktype;
	
	public StockPortfolio() {
		
	}
	
	public void addShares(Stock stock, int numShares) {
		stocktype.setName(stock.getName());
		stocktype.setSymbol(stock.getSymbol());
		this.numshares += numShares;
	}
	
	public void removeShares(Stock stock, int numShares) {
		stocktype.setName(stock.getName());
		stocktype.setSymbol(stock.getSymbol());
		this.numshares -= numShares;
	}
}
