package edu.ycp.cs320.stocksimulation.shared;

/**
 * This class represents the cash-transaction 
 * it is a super class of the Withdrawal class and the Deposit class
 * @author hdao2
 *
 */
public abstract class CashTransaction extends Transaction {
	
	private Money money;
	
	public CashTransaction() {
		
	}
	
	public CashTransaction(Money money) {
		this.money = money;
	}
	
	public void setMoney(Money money) {
		this.money = money;
	}
	
	public Money getMoney() {
		return money;
	}
	
	// Apply the transaction to the given amount of money.
	public abstract Money moneyTransaction(Money money) ;
}
