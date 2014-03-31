package edu.ycp.cs320.stocksimulation.shared;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	private Account account;
	
	@Before
	public void setUp() {
		account = new Account();
	}
	
	@Test
	public void testAddCash() {
		AccountSummaryCalculator calc = new AccountSummaryCalculator();
		
		long ts = System.currentTimeMillis();

		AccountSummary summary1 = calc.calculate(account, null, ts, ts + 100);
		
		// Account is initially empty
		assertEquals(new Money(new BigDecimal(0)), summary1.getAmountMoney());
		
		// add 100 dollars
		CashTransaction deposit = new Deposit();
		deposit.setMoney(new Money(new BigDecimal(100)));
		deposit.setTimestamp(ts + 50);
		account.addTransaction(deposit);
		
		AccountSummary summary2 = calc.calculate(account, null, ts, ts + 100);

		// Account should now have $100
		assertEquals(new Money(new BigDecimal(100)), summary2.getAmountMoney());
	}
}
