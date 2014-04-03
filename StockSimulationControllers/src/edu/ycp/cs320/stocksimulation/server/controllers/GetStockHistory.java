package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.shared.Stock;
import edu.ycp.cs320.stocksimulation.shared.StockHistory;

public class GetStockHistory {
	public StockHistory getStockPricesForStock(Stock stock, long beginTimestamp, long endTimestamp) {
		return DatabaseProvider.getInstance().getStockPricesForStock(stock, beginTimestamp, endTimestamp);
	}
}
