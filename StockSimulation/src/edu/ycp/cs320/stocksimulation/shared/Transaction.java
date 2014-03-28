package edu.ycp.cs320.stocksimulation.shared;

public class Transaction {
	private int id;
	private long timeStamp;
	
	public Transaction(){
		
	}
	
	private void getId(int id){
		this.id = id;
	}
	
	private void getTimeStamp(long timeStamp){
		this.timeStamp = timeStamp;
	}
}
