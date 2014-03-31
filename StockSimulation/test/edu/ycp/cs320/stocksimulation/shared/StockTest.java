package edu.ycp.cs320.stocksimulation.shared;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StockTest {
	private Stock google;
	
	@Before
	public void setUp() {
		google = new Stock();
		google.setName("Google");
		google.setSymbol("GOOG");
	}
	/**
	 * test the getName() method
	 */
	@Test
	public void testGetName() {
		assertEquals("Google", google.getName());
	}
	/**
	 * test the setName() method
	 */
	@Test
	public void testSetName(){
		google.setName("Amazon");
		assertEquals("Amazon", google.getName());
	}
}
