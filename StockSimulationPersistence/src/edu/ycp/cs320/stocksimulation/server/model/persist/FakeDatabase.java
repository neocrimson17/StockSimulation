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
	private List<Login> LoginList;
	
	
	public FakeDatabase() {
		googleStockPrices = new ArrayList<StockPrice>();
		// TODO: add data
		
		yahooStockPrices = new ArrayList<StockPrice>();
		// TODO: add data
		
		LoginList = new ArrayList<Login>();
		// Populate initial list with master account
		LoginList.add(new Login("admin", "admin"));
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
		//Check for existing login
		for(Login login : LoginList)
		{
			if (login.getName().equals(username)) {
				if (login.getPassword().equals(password))
				{
				//return a copy
				//return new Login(login.getName(), login.getPassword());
				return true;
				}
			}
		}
		return false;
	}

	@Override
	public Login postLogin(String username, String password) {
		// Add account if it does not exist
		boolean result = false;
		//Check to make sure
		for (Login login: LoginList){
			if (login.getName().equals(username) && login.getPassword().equals(password)){
				result = true;
				break;
			}
		}
		if (result == false){
			Login newLogin = new Login(username, password);
			LoginList.add(newLogin);
			return newLogin;
		}
		return null;
	}

}
