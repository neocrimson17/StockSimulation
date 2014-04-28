package stocksimulation.tests;
import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {

	private Deposit dep;
	
	public TransactionTest(){
		dep = new Deposit(new Money());
		dep.setTransaction(0, 100L);
	}
	
	
	@Test
	public void testSetTransaction() {
		assertEquals(0,dep.getId());
		assertEquals(100L,dep.getTimestamp());
		dep.setTransaction( 1234, 01012000 );
		assertEquals("Transaction: Failed to get Id", 1234, dep.getId());
		assertEquals("Transaction: Failed to get Timestamp", 01012000, dep.getTimestamp());
	}
	
	@Test
	public void testSetId() {
		dep.setId( 1234 );
		assertEquals("Transaction: Could not set Id", 1234, dep.getId());
	}
	
	@Test
	public void testSetTimestamp() {
		dep.setTimestamp( 01012000 );
		assertEquals("Transaction: Could not set Timestamp", 01012000, dep.getTimestamp());
	}
	
	@Test
	public void testGetId() {
		dep.setTransaction( 1234, 01012000 );
		assertEquals("Transaction: Could not get Id", 1234, dep.getId());
	}
	
	@Test
	public void testGetTimestamp(){
		dep.setTransaction( 1234, 01012000 );
		assertEquals("Transaction: Could not get Timestamp", 01012000, dep.getTimestamp());
	}

}
