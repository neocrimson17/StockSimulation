package edu.ycp.cs320.stocksimulation.shared;

import java.io.Serializable;
import java.math.BigDecimal;

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

public class AccountSummary implements Serializable {

	//fields
	private Money totalAmountMoney;
	private StockPortfolio totalAmountStock;
	
	//constructor
	public AccountSummary(){
		
		Money money = new Money( new BigDecimal("0"));
		totalAmountMoney = money;
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
