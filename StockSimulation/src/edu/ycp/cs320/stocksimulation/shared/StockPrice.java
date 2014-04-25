package edu.ycp.cs320.stocksimulation.shared;


public class StockPrice {
	// fields
	private int stockId;
	private Money price;
	private long timestamp;
	
	public StockPrice(){
		
	}
	
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	public int getStockId() {
		return stockId;
	}
	
	public void setPrice(Money price) {
		this.price = price;
	}
	
	//price per share
	public Money getPrice(){
		return price;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	// timestamp
	public long getTimestamp() {
		return timestamp;
	}
	
	
}
