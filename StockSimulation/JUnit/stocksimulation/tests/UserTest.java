package stocksimulation.tests;
import edu.ycp.cs320.stocksimulation.shared.User;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUser(){
		User test = new User();
		assertEquals("User: Failed to create", test, new User() );
		
	}
	
	@Test
	public void testSetUser(){
		User test = new User();
		test.setUser("lastName","firstName","email");
		assertEquals("User: Failed to get lastName","lastName", test.getLastName());
		assertEquals("User: Failed to get firstName", "firstName", test.getFirstName());
		assertEquals("User: Failed to get email", "email", test.getEmail());
	}
	
	@Test
	public void testSetLastName(){
		User test = new User();
		test.setLastName("Thebuilder");
		assertEquals("User: Failed to set lastName", "Thebuilder", test.getLastName());
	}
	
	@Test
	public void testSetFirstName(){
		User test = new User();
		test.setFirstName("Bob");
		assertEquals("User: Failed to set firstName", "Bob", test.getFirstName());
	}
	
	@Test
	public void testSetEmail(){
		User test = new User();
		test.setEmail("bobthebuilder@gmail.com");
		assertEquals("User: Failed to set email", "bobthebuilder@gmail.com", test.getEmail());
	}
	
	@Test
	public void testGetLastName() {
		User test = new User();
		test.setUser("lastName", "firstName", "email");
		assertEquals("User: Failed to get lastName", "lastName", test.getLastName());
	}
	
	@Test
	public void testGetFirstName() {
		User test = new User();
		test.setUser("lastName", "firstName", "email");
		assertEquals("User: Failed to get firstName", "firstName", test.getFirstName());
	}
	
	@Test
	public void testGetEmail() {
		User test = new User();
		test.setUser("lastName", "firstName", "email");
		assertEquals("User: Failed to get email", "email", test.getEmail());
	}

}
