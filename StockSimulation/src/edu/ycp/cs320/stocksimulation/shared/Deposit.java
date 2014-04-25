package edu.ycp.cs320.stocksimulation.shared;

public class Deposit extends CashTransaction {

	public Deposit(Money money) {
		super(money);
	}

	@Override
	public Money moneyTransaction(Money money) {
		// TODO Auto-generated method stub
		return this.getMoney().add(money);
	}

}
