package stocksimulation.tests;

import edu.ycp.cs320.stocksimulation.shared.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class LoginTest {
	
	private Login log;
	
	public LoginTest(){
		log = new Login();
	}
	
	/**
	 * This test essentially cover setUserName method as well
	 */
	@Test
	public void testGetName(){
		log.setUsername("admin");
		assertEquals("admin",log.getName());
	}
	
	/**
	 * This test should cover getPassword method as well
	 */
	@Test
	public void testSetPassWord(){
		log.setPassword("letmein");
		assertEquals("letmein",log.getPassword());
	}
}
