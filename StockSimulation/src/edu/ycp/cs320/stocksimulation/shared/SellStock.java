package edu.ycp.cs320.stocksimulation.shared;

public class SellStock extends StockTransaction {
	
	public SellStock(int numShare, Stock stock) {
		super(numShare, stock);
	}
	/**
	 * A method to allow the user to sell stock
	 */
	@Override
	public void stockTransaction(StockPortfolio portfolio) {
		portfolio.subtractShares(getStock(), getNumShare());
	}
	
}
