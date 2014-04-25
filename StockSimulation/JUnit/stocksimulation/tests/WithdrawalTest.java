package stocksimulation.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import edu.ycp.cs320.stocksimulation.shared.Money;
import edu.ycp.cs320.stocksimulation.shared.Withdrawal;

public class WithdrawalTest {
	private Money money;
	private Withdrawal with;
	
	public WithdrawalTest(){
		money = new Money(new BigDecimal("100"));
		with = new Withdrawal(new Money(new BigDecimal("5000")));
	}
	
	@Test
	public void testMoneyTransaction(){
		assertEquals(new Money(new BigDecimal("4900")), with.moneyTransaction(money));	
	}
}
