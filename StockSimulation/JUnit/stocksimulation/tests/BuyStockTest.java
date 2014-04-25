package stocksimulation.tests;

import edu.ycp.cs320.stocksimulation.shared.*;

import static org.junit.Assert.*;

import org.junit.Test;


public class BuyStockTest {
	private Stock google;
	private BuyStock buy;
	private StockPortfolio port;
	
	public BuyStockTest(){
		google = new Stock();
		//google.setId(1);
		google.setName("Google, Inc.");
		google.setSymbol("GOOG");
		buy = new BuyStock(100, google);
		buy.setNumShare(100);
		
		port = new StockPortfolio();
	}
	
	@Test
	public void testBuyStock(){
		
		Stock stock = new Stock();
		stock.setSymbol("GOOG");
		//port.addShares(stock, buy.getNumShare());
		assertEquals(0,port.getNumShares(stock));

		buy.stockTransaction(port);
		
		assertEquals(100,port.getNumShares(stock));
	}
}
