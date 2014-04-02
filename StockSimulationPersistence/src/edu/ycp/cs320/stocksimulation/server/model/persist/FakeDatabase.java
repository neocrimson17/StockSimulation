package edu.ycp.cs320.stocksimulation.server.model.persist;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Stock;
import edu.ycp.cs320.stocksimulation.shared.StockHistory;
import edu.ycp.cs320.stocksimulation.shared.StockPrice;

public class FakeDatabase implements IDatabase {
	
	//private List<StockPrice> stockPriceList;
	private List<StockPrice> googleStockPrices;
	private List<StockPrice> yahooStockPrices;
	
	public FakeDatabase() {
		googleStockPrices = new ArrayList<StockPrice>();
		// TODO: add data
		
		yahooStockPrices = new ArrayList<StockPrice>();
		// TODO: add data
	}

	@Override
	public StockHistory getStockPricesForStock(Stock stock, long beginTimestamp, long endTimestamp) {
		if (stock.getSymbol().equals("GOOG")) {
			// return StockHistory for Google within given range
			throw new UnsupportedOperationException("TODO - implement");
		} else if (stock.getSymbol().equals("YHOO")) {
			// return StockHistory for Yahoo within given range
			throw new UnsupportedOperationException("TODO - implement");
		} else {
			// No information
			return new StockHistory();
		}
	}

	@Override
	public boolean getLogin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Login postLogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
