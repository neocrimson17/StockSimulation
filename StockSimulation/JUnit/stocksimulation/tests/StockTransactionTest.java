package stocksimulation.tests;

import java.math.BigDecimal;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StockTransactionTest {
	private BuyStock buy;
	private Stock stock;
	
	public StockTransactionTest(){
		stock = new Stock();
		stock.setSymbol("GOOG");
		stock.setName("Google");
		buy = new BuyStock(100, stock);
	}
	
	@Test
	public void testgetStock(){
		assertEquals(stock,buy.getStock());
	}
	
	@Test
	public void testsetStock(){
		Stock stock2 = new Stock();
		stock.setSymbol("AMZN");
		stock.setName("Amazon");
		buy = new BuyStock(10,stock2);
		buy.setStock(stock);
		
		assertEquals(stock,buy.getStock());
		
	}
	
	@Test
	public void testGetNumShare(){
		assertEquals(100,buy.getNumShare());
	}
	
	@Test
	public void testGetSharePrice(){
		Money money = new Money(new BigDecimal("100"));
		buy.setSharePrice(money);
		assertEquals(money,buy.getSharePrice());
	}
}
