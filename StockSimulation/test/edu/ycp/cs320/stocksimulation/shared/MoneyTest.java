package edu.ycp.cs320.stocksimulation.shared;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	
	// fields 
	private Money money;
	private Money thirtyDollarsAndFourteenCents;
	private BigDecimal big;
	
	
	/**
	 * setUp for all the subsequent tests
	 * @throws Exception
	 */
	@Before
	public void setUp(){
		money = new Money();
		thirtyDollarsAndFourteenCents = new Money(new BigDecimal("30.14"));
		big = new BigDecimal("10.50");
	}
	
	/**
	 * Test the getAmount() method in the Money class
	 */
	/*@Test
	public void testgetAmount() {
		
		assertTrue(money.getAmount().compareTo(big) == 0);
	}*/
	
	@Test
	public void testGetAmount() {
		assertEquals(new BigDecimal("0"), money.getAmount());
		assertEquals(new BigDecimal("30.14"), thirtyDollarsAndFourteenCents.getAmount());
	}
	
	/**
	 * Test the add method in the Money class
	 */
	@Test
	public void testadd(){
		BigDecimal newBig = new BigDecimal("100");
		Money newMoney = new Money(newBig);
		Money result = money.add(newMoney);
		//assertTrue(money.getAmount().compareTo(newBig) < 0);
		assertEquals(new BigDecimal("100"), result.getAmount());
	}
	/**
	 * Test the subtract method in the Money class
	 */
		@Test
		public void testsubtract(){
			
		}
}
