package edu.ycp.cs320.stocksimulation.shared;

public class Transaction {
	private int id;
	private String timeStamp;
	
	private void getId(int id){
		this.id = id;
	}
	
	private void getTimeStamp(String timeStamp){
		this.timeStamp = timeStamp;
	}
}
