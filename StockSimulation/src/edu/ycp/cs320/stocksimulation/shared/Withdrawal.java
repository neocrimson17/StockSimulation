package edu.ycp.cs320.stocksimulation.shared;

public class Withdrawal extends CashTransaction {

	public Withdrawal(Money money) {
		super(money);
	}
	@Override
	public Money moneyTransaction(Money money) {
		//return this.getMoney().subtract(money);
		return money.subtract(this.getMoney());
	}
	
}
