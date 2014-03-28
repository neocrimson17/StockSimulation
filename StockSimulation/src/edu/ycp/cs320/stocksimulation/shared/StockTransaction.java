package edu.ycp.cs320.stocksimulation.shared;

public abstract class StockTransaction extends Transaction {
	// field(s)
	private int numShare;
	private Money sharePrice;
	
	// constructor
	public StockTransaction(){
		
	}
	
	public void setStock(Stock stockAmount){
		this.numShare = stockAmount.getStockAmount();
	}
	
	public int getStock(){
		return numShare;
	}
	
	// Apply the transaction to the given amount of stock.
	public abstract Stock stockTransaction(Stock stock);
}
