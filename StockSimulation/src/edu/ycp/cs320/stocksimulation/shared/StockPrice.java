package edu.ycp.cs320.stocksimulation.shared;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class StockPrice {
	// fields
	private Money price;
	private Date day;
	
	public StockPrice(){
		
	}
	
	//price per share
	public Money pricePerShare(){
		Money result  = new Money();
		
		result.setAmount(price.getAmount());
		
		return result;
	}
	// timestamp
	public Long timeStamp(Date day){
		this.day = day;
		
		return day.getTime();
	}
	
	
}
