package stocksimulation.tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StockHistoryTest {
	private StockHistory hist;
	private StockPrice price;
	private StockPrice price2;
	private List<StockPrice> stockPrices;
	
	public StockHistoryTest(){
		price = new StockPrice();
		price2 = new StockPrice();
		hist = new StockHistory();
		stockPrices = new ArrayList<StockPrice>();
		price.setTimestamp(200);
		price.setPrice(new Money(new BigDecimal("50")));
		hist.add(price);
		price2.setTimestamp(100);
		price2.setPrice(new Money(new BigDecimal("50")));
		hist.add(price2);
	}
	
	@Test
	public void testGetStockPrice(){
		hist.sortByTimestamp();
		assertEquals(price.getPrice(),hist.getStockPrice(100).getPrice());
	}
	
	@Test
	public void testSortByTimeStamp(){
		// original StockPrice ordering is not chronological
		assertEquals(200L, hist.getStockPrices().get(0).getTimestamp());
		assertEquals(100L, hist.getStockPrices().get(1).getTimestamp());
		
		hist.sortByTimestamp();

		// Now stock prices should be sorted chronologically
		assertEquals(100L, hist.getStockPrices().get(0).getTimestamp());
		assertEquals(200L, hist.getStockPrices().get(1).getTimestamp());
	}
}
