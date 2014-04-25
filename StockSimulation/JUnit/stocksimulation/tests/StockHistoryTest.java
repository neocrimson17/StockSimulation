package stocksimulation.tests;

import java.math.BigDecimal;
import java.util.List;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StockHistoryTest {
	private StockHistory hist;
	private StockPrice price;
	
	public StockHistoryTest(){
		price = new StockPrice();
		hist = new StockHistory();
		price.setTimestamp(100);
		price.setPrice(new Money(new BigDecimal("50")));
		hist.add(price);
	}
	
	@Test
	public void testGetStockPrice(){
		assertEquals(price.getPrice(),hist.getStockPrice(100).getPrice());
	}
}
