package stocksimulation.tests;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SellStockTest {
	
	private Stock google;
	private BuyStock sell;
	private StockPortfolio port;
	
	public SellStockTest(){
		google = new Stock();
		//google.setId(1);
		google.setName("Google, Inc.");
		google.setSymbol("GOOG");
		sell = new BuyStock(100, google);
		sell.setNumShare(100);
		
		port = new StockPortfolio();
	}
	
	@Test
	public void testSellStock(){
		
		Stock stock = new Stock();
		stock.setSymbol("GOOG");
		assertEquals(0,port.getNumShares(stock));

		sell.stockTransaction(port);
		
		assertEquals(100,port.getNumShares(stock));
	}

}
