package stocksimulation.tests;
import edu.ycp.cs320.stocksimulation.shared.*;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import edu.ycp.cs320.stocksimulation.shared.Money;

public class CashTransactionTest {
	
	private Money money;
	private Deposit dep;
	
	public CashTransactionTest(){
		money = new Money(new BigDecimal("5000"));
		dep = new Deposit(money);
	}
	

	/**
	 *  Tests setMoney
	 */
	@Test
	public void testSetMoney() {
		dep.setMoney(money); 		
		assertEquals(money, dep.getMoney());
	}
	/**
	 * Test getMoney
	 */
	@Test
	public void testGetMoney() {
		dep.setMoney(money); 
		assertEquals(money, dep.getMoney());
	}

}
