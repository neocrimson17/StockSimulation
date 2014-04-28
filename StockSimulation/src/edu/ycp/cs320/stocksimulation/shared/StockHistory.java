package edu.ycp.cs320.stocksimulation.shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StockHistory {
	
	private static class StockPriceTimestampComparator implements
			Comparator<StockPrice> {
		@Override
		public int compare(StockPrice o1, StockPrice o2) {
			if (o1.getTimestamp() < o2.getTimestamp()) {
				return -1;
			} else if (o1.getTimestamp() > o2.getTimestamp()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	private List<StockPrice> stockPrices;
	
	public StockHistory() {
		stockPrices = new ArrayList<StockPrice>();
	}
	
	public void add(StockPrice stockPrice) {
		stockPrices.add(stockPrice);
	}
	
	public void sortByTimestamp() {
		Collections.sort(stockPrices, new StockPriceTimestampComparator());
	}
	
	public StockPrice getStockPrice(long timestamp) {
		// Note: assumes that stock prices are sorted by timestamp
		StockPrice candidate = null;
		for (StockPrice stockPrice : stockPrices) {
			if (stockPrice.getTimestamp() <= timestamp) {
				candidate = stockPrice;
			} else {
				break;
			}
		}
		return candidate;
		
	}
	
	public List<StockPrice> getStockPrices() {
		return Collections.unmodifiableList(stockPrices);
	}
}
