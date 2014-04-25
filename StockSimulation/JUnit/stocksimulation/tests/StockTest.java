package stocksimulation.tests;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StockTest {
	private Stock stock;
	
	public StockTest(){
		stock = new Stock();
		stock.setId(0);
		stock.setName("Google");
		stock.setSymbol("GOOG");
	}
	
	@Test
	public void TestGetID(){
		assertEquals(0,stock.getId());	
	}
	
	@Test
	public void TestGetName(){
		assertEquals("Google",stock.getName());
	}
	
	@Test
	public void TestGetSymbol(){
		assertEquals("GOOG",stock.getSymbol());
	}
	
	
	
}
