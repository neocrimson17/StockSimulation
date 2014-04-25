package stocksimulation.tests;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {
	private Search search;
	
	public SearchTest(){
		search = new Search();
	}
	
	@Test
	public void testGetSearch(){
		search.setSearch("GOOG");
		assertEquals("GOOG",search.getSearch());
	}
}
