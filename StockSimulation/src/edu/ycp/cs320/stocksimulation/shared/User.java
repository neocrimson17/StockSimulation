package edu.ycp.cs320.stocksimulation.shared;

/*public class User {
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
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.IOException;
/**
 * This is a user class
 * @author hdao2
 *
 */
public class User {
	public void login() {
	    
		Scanner keyboard = new Scanner (System.in);
	    System.out.println("Enter 1 to login or 2 to register.");
	    int option = 0;
	    boolean error = false;
	    // loop again if user doesn't enter correct value
	    while(!error){
	    	if(keyboard.hasNextInt()){
	    		option = keyboard.nextInt();
	    	}
	    	if (option == 1 || option == 2){
	    		error = true;
	    	}else{
	    		System.out.println("You must enter either 1 (integer) to login or 2 (integer) to register an account");
	    	}
	    
	    }
	    
	  
	    if (option == 1){
	    	// login
	    	String username = "";
	 	    String password = "";
	    	System.out.println("Enter username: ");
	    	username = keyboard.next();
	    	System.out.println("Enter password: ");
	    	password = keyboard.next();
	    	//TODO  //GetLogin controller = new GetLogin(); need to figure out how to use
	    	/// the class in the StockSimulationControllers packet
	    	
	    	boolean loginCheck = false;
	    	
	    	
	    	while(!loginCheck){
	    		if (keyboard.hasNext()){
	    			username = keyboard.next();
	    		}
	    	}
	    }else if (option == 2){
	    	// register account
	    }
	    
	    
	}
}
