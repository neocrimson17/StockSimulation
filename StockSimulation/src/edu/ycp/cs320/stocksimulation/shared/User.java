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

public class User {
	public void login() {
	   
		File fileName = new File("loginInfo.text");
		Scanner scan = null;
		try {
			scan = new Scanner (new File("loginInfo.text"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Scanner keyboard = new Scanner (System.in);
	    String user = scan.nextLine();
	    String pass = scan.nextLine(); // looks at selected file in scan

	    String inputUser = keyboard.nextLine();
	    String inputPass = keyboard.nextLine(); // gets input from user

	    if (inputUser.equals(user) && inputPass.equals(pass)) {
	        System.out.print("login successful!");
	    } else {
	        System.out.print("incorrect password or username!");
	    }
	}
}
