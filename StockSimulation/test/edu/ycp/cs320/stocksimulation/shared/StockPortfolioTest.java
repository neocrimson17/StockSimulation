package edu.ycp.cs320.stocksimulation.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StockPortfolioTest {
	private StockPortfolio portfolio;
	private Stock google;
	private Stock yahoo;
	private Stock ibm;
	
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
		
		portfolio.addShares(google, 10);
		portfolio.addShares(yahoo, 20);
	}
	
	
	@Test
	public void testGetNumShares() {
		assertEquals(10, portfolio.getNumShares(google));
		assertEquals(20, portfolio.getNumShares(yahoo));
		assertEquals(0, portfolio.getNumShares(ibm));
	}
}
