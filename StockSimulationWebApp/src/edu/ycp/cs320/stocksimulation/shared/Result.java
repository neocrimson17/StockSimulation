package edu.ycp.cs320.stocksimulation.shared;

import edu.ycp.cs320.stocksimulation.shared.Publisher;
import edu.ycp.cs320.stocksimulation.shared.Result.Events;

public class Result extends Publisher {
	public enum Events {
		VALUE_CHANGED,
	}
	
	private String value;
	
	public Result() {
		value = "";
	}
	
	public void setValue(String value) {
		this.value = value;
		notifySubscribers(Events.VALUE_CHANGED, value);
	}
	
	public String getValue() {
		return value;
	}
}
