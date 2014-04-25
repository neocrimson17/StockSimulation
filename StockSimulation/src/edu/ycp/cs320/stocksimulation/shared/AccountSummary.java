package edu.ycp.cs320.stocksimulation.shared;

/**
 * Represents the Account Summary.
 * 
 * @author kmusco
 */

/**
 * This class represents the account summary which contains all total amount of each type of stock
 * Note: each type of stock should have a separate total amount (not all stocks have the same(Money) value
 * @author hdao2
 *
 */

public class AccountSummary {

	//fields
	private Money totalAmountMoney;
	private StockPortfolio totalAmountStock;
	
	//constructor
	public AccountSummary(){
		
	}
	
	public void setAmountMoney(Money totalMoney){
		this.totalAmountMoney = totalMoney;
	}
	
	public Money getAmountMoney(){
		return totalAmountMoney;
	}
	
	public void setAmountStock(StockPortfolio totalStock){
		this.totalAmountStock = totalStock;
	}
	public StockPortfolio getAmountStock(){
		return totalAmountStock;
	}
}
