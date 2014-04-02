package edu.ycp.cs320.stocksimulation.shared.model.persist;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.stocksimulation.server.controllers.GetStockHistory;
import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.FakeDatabase;
import edu.ycp.cs320.stocksimulation.shared.Money;
import edu.ycp.cs320.stocksimulation.shared.Stock;
import edu.ycp.cs320.stocksimulation.shared.StockHistory;

public class GetStockHistoryTest {
	private Stock google;
	private Stock yahoo;
	private Stock ibm;

	@Before
	public void setUp() {
		DatabaseProvider.setInstance(new FakeDatabase());
		google = new Stock();
		google.setName("Google");
		google.setSymbol("GOOG");
		yahoo = new Stock();
		yahoo.setName("Yahoo");
		yahoo.setSymbol("yhoo");
		ibm = new Stock();
		ibm.setName("IBM");
		ibm.setSymbol("IBM");
	}
	
	@Test
	public void testGetStockHistory() {
		GetStockHistory controller = new GetStockHistory();
		StockHistory h = controller.getStockPricesForStock(google, 500L, 600L);
		assertEquals(new Money(new BigDecimal(100)), h.getStockPrice(501L));
		assertEquals(new Money(new BigDecimal(125)), h.getStockPrice(551L));
	}
}
