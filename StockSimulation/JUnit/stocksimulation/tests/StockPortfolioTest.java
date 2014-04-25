package stocksimulation.tests;
import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StockPortfolioTest {
	private StockPortfolio portfolio;
	private Stock google;
	private Stock yahoo;
	private Stock ibm;
	private Stock amazon;
	
	@Before
	public void setUp() {
		portfolio = new StockPortfolio();
		google = new Stock();
		google.setName("Google");
		google.setSymbol("GOOG");
		yahoo = new Stock();
		yahoo.setName("Yahoo");
		yahoo.setSymbol("yhoo");
		ibm = new Stock();
		ibm.setName("IBM");
		ibm.setSymbol("IBM");
		amazon = new Stock();
		amazon.setName("Amazon");
		amazon.setSymbol("AMZN");
		
		portfolio.addShares(google, 10);
		portfolio.addShares(yahoo, 20);
		portfolio.addShares(ibm,50);
		portfolio.subtractShares(ibm, 10);
	}
	
	
	@Test
	public void testGetNumShares() {
		assertEquals(10, portfolio.getNumShares(google));
		assertEquals(20, portfolio.getNumShares(yahoo));
		assertEquals(40, portfolio.getNumShares(ibm));
		assertEquals(0,portfolio.getNumShares(amazon));
	}
	
	
}
