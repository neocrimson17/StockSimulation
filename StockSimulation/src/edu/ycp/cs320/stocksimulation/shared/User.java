package edu.ycp.cs320.stocksimulation.shared;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	
	public User(){
		firstName = null;
		lastName = null;
		email = null;
	}
	
	public void setUser(String lastName, String firstName, String email){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getEmail(){
		return email;
	}
}
