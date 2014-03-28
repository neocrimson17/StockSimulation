package edu.ycp.cs320.stocksimulation.shared;

public class Withdrawal extends CashTransaction {

	@Override
	public Money moneyTransaction(Money money) {
		return money.subtract(this.getMoney());
	}
	
}
