package stocksimulation.tests;
import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {

	@Test
	public void testTransaction() {
		Transaction test = new Transaction();
		assertEquals("Transaction: Failed to create", test, new Transaction());
	}
	
	@Test
	public void testSetTransaction() {
		Transaction test = new Transaction();
		test.setTransaction( 1234, 01012000 );
		assertEquals("Transaction: Failed to get Id", 1234, test.getId());
		assertEquals("Transaction: Failed to get Timestamp", 01012000, test.getTimestamp());
	}
	
	@Test
	public void testSetId() {
		Transaction test = new Transaction();
		test.setId( 1234 );
		assertEquals("Transaction: Could not set Id", 1234, test.getId());
	}
	
	@Test
	public void testSetTimestamp() {
		Transaction test = new Transaction();
		test.setTimestamp( 01012000 );
		assertEquals("Transaction: Could not set Timestamp", 01012000, test.getTimestamp());
	}
	
	@Test
	public void testGetId() {
		Transaction test = new Transaction();
		test.setTransaction( 1234, 01012000 );
		assertEquals("Transaction: Could not get Id", 1234, test.getId());
	}
	
	@Test
	public void testGetTimestamp(){
		Transaction test = new Transaction();
		test.setTransaction( 1234, 01012000 );
		assertEquals("Transaction: Could not get Timestamp", 01012000, test.getTimestamp());
	}

}
