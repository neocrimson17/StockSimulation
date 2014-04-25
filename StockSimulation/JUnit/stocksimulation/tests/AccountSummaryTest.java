package stocksimulation.tests;
import java.math.BigDecimal;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AccountSummaryTest {


	@Test
	public void testSetAmountMoney(){
		AccountSummary test = new AccountSummary();
		
		// Adds $5000 to account
		String a = "5000";
		BigDecimal val = new BigDecimal(a);
		Money money = new Money(val);
		test.setAmountMoney( money );
		
		assertEquals("AccountSummary: Could not set Account Money", money, test.getAmountMoney());
	}
	
	@Test
	public void testSetAmountStock(){
		AccountSummary test = new AccountSummary();
		
		// Creates a stock called Google and adds 123 shares to it
		Stock google = new Stock();
		google.setName("Google");
		google.setSymbol("GOOG");
		
		StockPortfolio googleTransaction = new StockPortfolio();
		googleTransaction.addShares(google, 123);
		test.setAmountStock(googleTransaction);
		assertEquals(123, test.getAmountStock().getNumShares(google));
		
	}
	
	@Test
	public void testGetAmountStock(){
		AccountSummary test = new AccountSummary();
		
		// Creates a stock called GOOG and adds 100 shares to it.
		Stock google = new Stock();
		google.setName("Google");
		google.setSymbol("GOOG");
		
		StockPortfolio googleTransaction = new StockPortfolio();
		googleTransaction.addShares( google, 100 );
		test.setAmountStock(googleTransaction);
		assertEquals(100, test.getAmountStock().getNumShares(google));
	}
}
