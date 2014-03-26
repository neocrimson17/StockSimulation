package edu.ycp.cs320.stocksimulation.shared;

import java.util.Date;
public class Transaction {
	// field(s)
	private int id;
	private long timestamp;
	
	// constructor
	public Transaction(){
		
	}

	// get id
	public int getId(){
		return id;
	}
	
	// set id
	public void setId(int id){
		this.id = id;
	}
	
	// timestamp
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
}
