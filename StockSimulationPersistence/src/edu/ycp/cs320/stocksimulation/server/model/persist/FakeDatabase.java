package edu.ycp.cs320.stocksimulation.server.model.persist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Money;
import edu.ycp.cs320.stocksimulation.shared.Search;
import edu.ycp.cs320.stocksimulation.shared.Stock;
import edu.ycp.cs320.stocksimulation.shared.StockHistory;
import edu.ycp.cs320.stocksimulation.shared.StockPrice;

public class FakeDatabase implements IDatabase {
	
	private List<StockPrice> stockPriceList;
	private List<StockPrice> googleStockPrices;
	private List<StockPrice> yahooStockPrices;
	private List<Login> LoginList;
	
	
	
	public FakeDatabase() {
		googleStockPrices = new ArrayList<StockPrice>();
		yahooStockPrices = new ArrayList<StockPrice>();
		
		addStockPrices("edu/ycp/cs320/stocksimulation/server/model/persist/res/googlePrices.csv", googleStockPrices);
		addStockPrices("edu/ycp/cs320/stocksimulation/server/model/persist/res/yahooPrices.csv", yahooStockPrices);
		
		LoginList = new ArrayList<Login>();
		// Populate initial list with master account
		LoginList.add(new Login("admin", "admin"));
	}

	private void addStockPrices(String resourceName, List<StockPrice> stockPrices) {
		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream(resourceName);
			if (in == null) {
				throw new IllegalStateException("Could not open " + resourceName);
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				StringTokenizer tok = new StringTokenizer(line, ",");
				while (tok.hasMoreTokens()) {
					long timestamp = Long.parseLong(tok.nextToken());
					BigDecimal price = new BigDecimal(tok.nextToken());
					StockPrice stockPrice = new StockPrice();
					stockPrice.setPrice(new Money(price));
					stockPrice.setTimestamp(timestamp);
					stockPrices.add(stockPrice);
				}
			}
		} catch (IOException e) {
			throw new IllegalStateException("Error reading " + resourceName, e);
		}
	}

	@Override
	public StockHistory getStockPricesForStock(Stock stock, long beginTimestamp, long endTimestamp) {
		if (stock.getSymbol().equals("GOOG")) {
			
			StockHistory stockHistory = new StockHistory();
			stockHistory.sortByTimestamp();
			stockHistory.getStockPrice( beginTimestamp );
			stockHistory.getStockPrice( endTimestamp );
			
			return stockHistory;
			
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
	
	@Override
	// Used to contain code to grab data from Yahoo API. 
	// Moved code to seperate program on request from Dr.Hovemeyer
	
	public boolean search( String symbol ){
		
		//TODO
		return true;
	}
	
}
