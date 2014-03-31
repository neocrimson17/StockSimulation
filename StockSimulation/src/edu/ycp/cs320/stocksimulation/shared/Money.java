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
	private final BigDecimal amount;
	
	// constructor
	public Money(){
		amount = new BigDecimal(0);
	}
	
	// constructor taking an amount of money as an argument
	public Money(BigDecimal amount) {
		this.amount = amount;
	}
	
	// method to get amount of money
	public BigDecimal getAmount(){
		return amount;
	}

	// Subtract given amount of money, returning a new amount of money
	public Money subtract(Money money) {
		return new Money(amount.subtract(money.getAmount()));
	}
	
	// Add given amount of money, return a new amount of money
	public Money add(Money money) {
		return new Money(amount.add(money.getAmount()));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Money)) {
			return false;
		}
		Money other = (Money) obj;
		return this.amount.equals(other.amount);
	}
}
