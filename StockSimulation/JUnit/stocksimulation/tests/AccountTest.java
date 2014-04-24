package stocksimulation.tests;

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
		Transaction txn = new Transaction();
		// Add transactions
		test.addTransaction(txn);
		// get transactions
		assertEquals(txn, test.getTransactionList().get(0));
	}
	/**
	 * This test cover getTransaction
	 */
	@Test
	public void testGetTransactionList(){
		Account test = new Account();
		Transaction txn = new Transaction();
		// Add transactions
		test.addTransaction(txn);
		// get transactions
		assertEquals(txn, test.getTransactionList().get(0));
		
	}

}
