package edu.ycp.cs320.stocksimulation.shared.model.persist;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.stocksimulation.server.controllers.GetLogin;
import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.FakeDatabase;

public class TestGetLogin {
	@Before
	public void setUp() {
		DatabaseProvider.setInstance(new FakeDatabase());
	}
	
	@Test
	public void testGetLogin() {
		GetLogin controller = new GetLogin();
		
		boolean ok = controller.getLogin("username", "abc123");
		assertTrue(ok);
	}
}
