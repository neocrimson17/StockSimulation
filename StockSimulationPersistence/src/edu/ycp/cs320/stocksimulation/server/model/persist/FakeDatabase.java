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
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import edu.ycp.cs320.stocksimulation.shared.Account;
import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.BuyStock;
import edu.ycp.cs320.stocksimulation.shared.CashTransaction;
import edu.ycp.cs320.stocksimulation.shared.Deposit;
import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Money;
import edu.ycp.cs320.stocksimulation.shared.Search;
import edu.ycp.cs320.stocksimulation.shared.SellStock;
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
	private int nextLoginId = 1;
	//private AccountSummary accountSummary;
	//private Account account;
	//private Map<String, List<StockPrice>> symbolToStockPriceList;
	
	private List<Transaction> transactionList;
	private int nextTransactionId = 1;
	
	
	public FakeDatabase() {
		stockList = new ArrayList<Stock>();
		//account = new Account();
		
		// Google
		Stock google = new Stock();
		
		google.setId(1);
		google.setName("Google, Inc.");
		google.setSymbol("GOOG");
		stockList.add(google);
		
		// Yahoo
		Stock yahoo = new Stock();
		yahoo.setId(2);
		yahoo.setName("Yahoo! Inc.");
		yahoo.setSymbol("YHOO");
		stockList.add(yahoo);
		
		// Intel
		Stock intel = new Stock();
		intel.setId(3);
		intel.setName("INTL FCStone Inc.");
		intel.setSymbol("INTL");
		stockList.add(intel);
		
		
		stockPriceList = new ArrayList<StockPrice>();
		
		addStockPrices("edu/ycp/cs320/stocksimulation/server/model/persist/res/stockPrices.csv"/*, googleStockPrices*/);
		//addStockPrices("edu/ycp/cs320/stocksimulation/server/model/persist/res/yahooPrices.csv", yahooStockPrices);
		
		LoginList = new ArrayList<Login>();
		// Populate initial list with master account
		Login login = new Login("admin", "admin");
		login.setId(nextLoginId);
		nextLoginId++;
		LoginList.add(login);
		
		transactionList = new ArrayList<Transaction>();
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

			StockHistory stockHistory = new StockHistory();
			stockHistory.sortByTimestamp();
			stockHistory.getStockPrice( beginTimestamp );
			stockHistory.getStockPrice( endTimestamp );
			
			return stockHistory;
			
		} else if ( stock.getSymbol().equals("INTL")){
			
			StockHistory stockHistory = new StockHistory();
			stockHistory.sortByTimestamp();
			stockHistory.getStockPrice( beginTimestamp );
			stockHistory.getStockPrice( endTimestamp );
			
			return stockHistory;
			
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
	public boolean cashDeposit( String username, int amount ){
		
		Deposit deposit = new Deposit(new Money(new BigDecimal(amount)));
		
		// Checks that username is valid
		Login accountLogin = findLogin(username);
		
		//Deposit
		if( accountLogin != null ) // Only deposit if the username is valid
		{
			// Assign a unique id to this transaction
			deposit.setId(nextTransactionId);
			deposit.setAccountId(accountLogin.getId()); // associate transaction with the user's account
			nextTransactionId++;
			
			// Add the transaction to the list of transactions
			transactionList.add(deposit);
		}
		
		
		return accountLogin != null;
			
	}

	private Login findLogin(String username) {
		Login accountLogin = null;
		for(Login login : LoginList)
		{
			if (login.getName().equals(username)) {
					//valid = true;
					//accountId = login.getId();
				accountLogin = login;
				break;
			}
		}
		return accountLogin;
	}
	
	@Override
	public boolean cashWithdrawal( String username, int amount ){
		Withdrawal withdraw = new Withdrawal(new Money(new BigDecimal(amount)));
		
		// Checks that username is valid
		Login accountLogin = findLogin(username);
		
		//Withdraw
		if( accountLogin != null ) // Only deposit if the username is valid
		{
			// Assign a unique id to this transaction
			withdraw.setId(nextTransactionId);
			withdraw.setAccountId(accountLogin.getId()); // associate transaction with the user's account
			nextTransactionId++;
			
			// Add the transaction to the list of transactions
			transactionList.add(withdraw);
		}
		
		return accountLogin != null;
	}

	@Override
	public boolean buyStock(String user, int amount, Stock stockType) {
	
		BuyStock buyStock = new BuyStock(amount,stockType);
		
		// Checks that username is valid
		Login accountLogin = findLogin(user);
		
		//Withdraw
		if( accountLogin != null ) // Only deposit if the username is valid
		{
			// Assign a unique id to this transaction
			buyStock.setId(nextTransactionId);
			buyStock.setAccountId(accountLogin.getId()); // associate transaction with the user's account
			nextTransactionId++;
			
			// Add the transaction to the list of transactions
			transactionList.add(buyStock);
		}
		
		return accountLogin != null;
		
	}

	@Override
	public boolean sellStock(String user, int amount, Stock stockType) {
		SellStock sellStock = new SellStock(amount,stockType);
		
		// Checks that username is valid
		Login accountLogin = findLogin(user);
		
		//Withdraw
		if( accountLogin != null ) // Only deposit if the username is valid
		{
			// Assign a unique id to this transaction
			sellStock.setId(nextTransactionId);
			sellStock.setAccountId(accountLogin.getId()); // associate transaction with the user's account
			nextTransactionId++;
			
			// Add the transaction to the list of transactions
			transactionList.add(sellStock);
		}
		
		return accountLogin != null;
	}

	@Override
	public Transaction[] getTransactionsForAccount(String username) {
		Login accountLogin = findLogin(username);
		if (accountLogin == null) {
			// Unknown username?
			System.out.println("Can't find transactions for " + username + " (no such user?");
			return new Transaction[0];
		}
		
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		
		for (Transaction txn : transactionList) {
			if (txn.getAccountId() == accountLogin.getId()) {
				result.add(txn);
			}
		}
		
		return result.toArray(new Transaction[result.size()]);
	}
	
}
