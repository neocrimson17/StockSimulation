package edu.ycp.cs320.stocksimulation.shared;

public abstract class CashTransaction extends Transaction {
	
	private Money money;
	
	public CashTransaction() {
		
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
