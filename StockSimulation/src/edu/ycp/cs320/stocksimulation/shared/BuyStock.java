package edu.ycp.cs320.stocksimulation.shared;
/**
 * A method to allow the user to buy stock
 * @author hdao2
 *
 */
public class BuyStock extends StockTransaction {

	/**
	 * A method to allow the user to buy stock
	 */
	@Override
	public StockPortfolio stockTransaction(StockPortfolio portfolio) {
		portfolio.addShares(getStock(), getNumShare());
		return portfolio;	
	}

}
