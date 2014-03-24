package edu.ycp.cs320.stocksimulation.shared;

import java.util.Date;
public class Transaction {
	// field(s)
	private int id;
	private Date day;
	
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
	public Long timeStamp(Date day){
		this.day = day;
		
		return day.getTime();
	}
}
