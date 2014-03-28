package edu.ycp.cs320.stocksimulation.shared;


public class StockPrice {
	// fields
	private Money price;
	private long timestamp;
	
	public StockPrice(){
		
	}
	
	public void setPrice(Money price) {
		this.price = price;
	}
	
	//price per share
	public Money getPrice(){
//		Money result  = new Money();
//		
//		result.setAmount(price.getAmount());
//		
//		return result;
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
