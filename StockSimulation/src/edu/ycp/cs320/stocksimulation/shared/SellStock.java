package edu.ycp.cs320.stocksimulation.shared;

public class SellStock extends StockTransaction {
	
	public SellStock(int numShare) {
		super(numShare);
	}
	/**
	 * A method to allow the user to sell stock
	 */
	@Override
	public StockPortfolio stockTransaction(StockPortfolio portfolio) {
		portfolio.subtractShares(getStock(), getNumShare());
		return portfolio;
	}
	
}
