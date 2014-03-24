package edu.ycp.cs320.stocksimulation.shared;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * This class represents the money use in this stock simulation game.  The currency is assumed to be in U.S. dollars
 * The money class uses BigDecimal to represent the currency in the game.
 * @author hdao2
 *
 */

public class Money {

	//field(s)
	private BigDecimal amount;
	
	// constructor
	public Money(){
	
	}
	
	// method to get amount of money
	public BigDecimal getAmount(){
		return amount;
	}
	// method to set amount of money
	public void setAmount(BigDecimal amountMoney){
		this.amount = amountMoney;
	}
}
