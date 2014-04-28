package stocksimulation.tests;

import java.math.BigDecimal;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {
	
	/**
	 * This test cover addTransaction
	 */
	@Test
	public void testAdd_Get_Transaction() {
		Account test = new Account();
		Deposit dep = new Deposit(new Money());
		dep.moneyTransaction(new Money(new BigDecimal(100)));
		// Add transactions
		test.addTransaction(dep);
		// get transactions
		assertEquals(dep, test.getTransactionList().get(0));
	}
	/**
	 * This test cover getTransaction
	 */
	@Test
	public void testGetTransactionList(){
		Account test = new Account();
		Deposit dep = new Deposit(new Money());
		dep.moneyTransaction(new Money(new BigDecimal(100)));
		// Add transactions
		test.addTransaction(dep);
		// get transactions
		assertEquals(dep, test.getTransactionList().get(0));
		
	}

}
