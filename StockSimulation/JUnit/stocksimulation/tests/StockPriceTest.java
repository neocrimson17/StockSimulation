package stocksimulation.tests;
import java.math.BigDecimal;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StockPriceTest {
	
	/**
	 * test setPrice() method
	 */
	@Test
	public void testSetPrice() {
		
		BigDecimal val = new BigDecimal("5000");
		Money money = new Money(val);
		StockPrice test = new StockPrice();
		
		test.setPrice(money);
		
		assertEquals("Stock Price: Failed to set money", money, test.getPrice());
	}
	
	/**
	 * test getPrice method
	 */
	
	@Test
	public void testGetPrice() {
		
		BigDecimal val = new BigDecimal("5000");
		Money money = new Money(val);
		StockPrice test = new StockPrice();
		
		test.setPrice(money);
		
		assertEquals("Stock Price: Failed to set money", money, test.getPrice());
	}
	
	@Test
	public void testGetId(){
		StockPrice price = new StockPrice();
		price.setStockId(1);
		assertEquals(1,price.getStockId());	
	}
	
	@Test
	public void testGetTimeStamp(){
		StockPrice price = new StockPrice();
		price.setTimestamp(100);
		assertEquals((long)100,price.getTimestamp());
	}

}
