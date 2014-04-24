package edu.ycp.cs320.stocksimulation.shared;
/**
 * This class is a super class of the BuyStock and SellStock classes
 * it represents a stock transaction (buy/sell orders)
 * @author hdao2
 *
 */
public abstract class StockTransaction extends Transaction {
	// field(s)
	private Stock stock;
	private int numShare;
	private Money sharePrice;
	
	// constructor
	public StockTransaction(){
		
	}
	public StockTransaction(int numShare){
		this.numShare = numShare;
	}
	public void setStock(Stock stock){
		this.stock = stock;
	}
	
	public Stock getStock(){
		return stock;
	}
	
	public void setNumShare(int numShare) {
		this.numShare = numShare;
	}
	
	public int getNumShare() {
		return numShare;
	}
	
	public void setSharePrice(Money sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	public Money getSharePrice() {
		return sharePrice;
	}
	
	// Apply the transaction to the given amount of stock.
	//public abstract Stock stockTransaction(Stock stock);
	public abstract StockPortfolio stockTransaction(StockPortfolio portfolio);
}
