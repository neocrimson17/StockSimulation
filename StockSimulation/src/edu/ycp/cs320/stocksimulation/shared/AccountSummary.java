package edu.ycp.cs320.stocksimulation.shared;

public class AccountSummary {
	
	//fields
	private Money totalAmountMoney;
	private Stock totalAmountStock;
	
	// TODO: add fields to keep track of what stocks the user owns, and how many
	
	//constructor
	public AccountSummary(){
		
	}
	
	public void setAmountMoney(Money totalMoney){
		this.totalAmountMoney = totalMoney;
	}
	
	public Money getAmountMoney(){
		return totalAmountMoney;
	}
	
	public void setAmountStock(Stock totalStock){
		this.totalAmountStock = totalStock;
	}
	public Stock getAmountStock(){
		return totalAmountStock;
	}
}
