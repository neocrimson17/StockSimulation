package stocksimulation.tests;

import java.math.BigDecimal;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class DepositTest {
	private Money money;
	private Deposit dep;
	
	public DepositTest(){
		money = new Money(new BigDecimal("5000"));
		dep = new Deposit(new Money(new BigDecimal("100")));
	}
	
	@Test
	public void testMoneyTransaction(){
		assertEquals(new Money(new BigDecimal("5100")), dep.moneyTransaction(money));
		
	}
}
