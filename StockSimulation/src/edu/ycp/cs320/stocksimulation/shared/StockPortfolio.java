package edu.ycp.cs320.stocksimulation.shared;

public class StockPortfolio {
	// TODO: fields
	private int numshares;
	private Stock stocktype;
	//Map<String, Integer> stocksOwned = new HashMap<String, Integer>();
	
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
	
	public int getNumShares(Stock stock) {
		// TODO
		return 0;
	}
}
