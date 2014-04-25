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
import java.util.Map;
import java.util.StringTokenizer;

import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.CashTransaction;
import edu.ycp.cs320.stocksimulation.shared.Deposit;
import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Money;
import edu.ycp.cs320.stocksimulation.shared.Search;
import edu.ycp.cs320.stocksimulation.shared.Stock;
import edu.ycp.cs320.stocksimulation.shared.StockHistory;
import edu.ycp.cs320.stocksimulation.shared.StockPrice;
import edu.ycp.cs320.stocksimulation.shared.Transaction;
import edu.ycp.cs320.stocksimulation.shared.Withdrawal;

public class FakeDatabase implements IDatabase {
	
	private List<Stock> stockList;
	private List<StockPrice> stockPriceList;
	//private List<StockPrice> googleStockPrices;
	//private List<StockPrice> yahooStockPrices;
	private List<Login> LoginList;
	private AccountSummary accountSummary;
	
	//private Map<String, List<StockPrice>> symbolToStockPriceList;
	
	
	public FakeDatabase() {
		stockList = new ArrayList<Stock>();
		Stock google = new Stock();
		google.setId(1);
		google.setName("Google, Inc.");
		google.setSymbol("GOOG");
		stockList.add(google);
		// etc. for other stocks
		//stockList.add(new Stock())
		
		//googleStockPrices = new ArrayList<StockPrice>();
		//yahooStockPrices = new ArrayList<StockPrice>();
		stockPriceList = new ArrayList<StockPrice>();
		
		addStockPrices("edu/ycp/cs320/stocksimulation/server/model/persist/res/stockPrices.csv"/*, googleStockPrices*/);
		//addStockPrices("edu/ycp/cs320/stocksimulation/server/model/persist/res/yahooPrices.csv", yahooStockPrices);
		
		LoginList = new ArrayList<Login>();
		// Populate initial list with master account
		LoginList.add(new Login("admin", "admin"));
	}

	private void addStockPrices(String resourceName/*, List<StockPrice> stockPrices*/) {
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
					
					String symbol = parseToken(tok.nextToken());
					String companyName = parseToken(tok.nextToken());
					BigDecimal price = new BigDecimal(parseToken(tok.nextToken()));
					long timestamp = Long.parseLong(parseToken(tok.nextToken()));
					
					//long timestamp = Long.parseLong(tok.nextToken());
					//BigDecimal price = new BigDecimal(tok.nextToken());
					
					StockPrice stockPrice = new StockPrice();
					stockPrice.setPrice(new Money(price));
					stockPrice.setTimestamp(timestamp);
					//stockPrices.add(stockPrice);
					
					Stock stock = findStockBySymbol(symbol);
					stockPrice.setStockId(stock.getId());
					
					stockPriceList.add(stockPrice);
				}
			}
		} catch (IOException e) {
			throw new IllegalStateException("Error reading " + resourceName, e);
		}
	}

	private Stock findStockBySymbol(String symbol) {
		for (Stock stock : stockList) {
			if (stock.getSymbol().equals(symbol)) {
				return stock;
			}
		}
		throw new IllegalArgumentException("Unknown stock symbol: " + symbol);
	}

	private String parseToken(String token) {
		if (token.startsWith("")) {
			token = token.substring(1);
		}
		if (token.endsWith("\"")) {
			token = token.substring(0, token.length() - 1);
		}
		return token;
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
	
	@Override
	public boolean cashDeposit( String username, int ammount ){
		
		
		// Link account 
		Boolean valid = false;
		Deposit deposit = new Deposit(null);
		Transaction transaction = new Transaction();
		int id = 1234;
		
		// Checks that username is valid
		for(Login login : LoginList)
		{
			if (login.getName().equals(username)) {
					valid = true;
			}
		}
		
		//Deposit
		if( valid == true) // Only deposit if the username is valid
		{
			BigDecimal val = new BigDecimal( ammount );
			Money money = new Money(val);
		
			transaction.setTransaction( id , System.currentTimeMillis() );
			deposit.moneyTransaction( money );
			accountSummary.setAmountMoney( money );
		}
		
		
		return valid;
			
	}
	
	@Override
	public boolean cashWithdrawal( String username, int ammount ){
		
		Boolean valid = false;
		Withdrawal withdrawal = new Withdrawal(null);
		Transaction transaction = new Transaction();
		int id = 4321;
		
		// Checks that username is valid
		for(Login login : LoginList)
		{
			if (login.getName().equals(username)) {
					valid = true;
			}
		}
		
		//Withdrawal
		if( valid == true) // Only withdraw if the username is valid
		{
			BigDecimal val = new BigDecimal( ammount );
			Money money = new Money(val);
		
			transaction.setTransaction( id , System.currentTimeMillis() );
			withdrawal.moneyTransaction( money );
			accountSummary.setAmountMoney( money );
		}
		
		
		return valid;
	}
	
}
