package edu.ycp.cs320.stocksimulation.shared;
/**
 * A method to allow the user to buy stock
 * @author hdao2
 *
 */
public class BuyStock extends StockTransaction {
	
	public BuyStock(int numShare, Stock stock) {
		super(numShare, stock);
	}
	/**
	 * A method to allow the user to buy stock
	 */
	@Override
	public void stockTransaction(StockPortfolio portfolio) {
		portfolio.addShares(getStock(), getNumShare());
	}

}
