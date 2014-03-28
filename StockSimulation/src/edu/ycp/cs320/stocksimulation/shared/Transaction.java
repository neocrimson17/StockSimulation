package edu.ycp.cs320.stocksimulation.shared;

import java.util.Date;
public class Transaction {
	// field(s)
	private int id;
	private long timestamp;
	
	// constructor
	public Transaction(){
		id = 0;
		timestamp = 0;
	}
	
	public void setTransaction( int id, long timestamp ){
		this.id = id;
		this.timestamp = timestamp;
	}

	// Get Id
	public int getId(){
		return id;
	}
	
	// Get Timestamp
	public long getTimestamp() {
		return timestamp;
	}
	
	// set Id
	public void setId(int id){
		this.id = id;
	}
	
	// Set Timestamp
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
