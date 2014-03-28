package edu.ycp.cs320.stocksimulation.shared;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	
	public User(String firstName, String lastName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public void getFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void getLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void getEmail(String email){
		this.email = email;
	}
}
