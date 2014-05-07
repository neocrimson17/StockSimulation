package edu.ycp.cs320.stocksimulation.server.model.persist;

import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Search;
import edu.ycp.cs320.stocksimulation.shared.Stock;
import edu.ycp.cs320.stocksimulation.shared.StockHistory;
import edu.ycp.cs320.stocksimulation.shared.Transaction;

public interface IDatabase {
	public StockHistory getStockPricesForStock(Stock stock, long beginTimestamp, long endTimestamp); 
	
	public boolean getLogin(String username, String password);
	
	public boolean postLogin(String username, String password, String confirmPassword);
	
	public boolean search( String symbol );
	
	public boolean cashDeposit( String user, int amount );
	
	public boolean cashWithdrawal( String user, int amount );
	
	public boolean buyStock( String user, int amount, Stock stockType);
	
	public boolean sellStock( String user, int amount, Stock stockType );

	public Transaction[] getTransactionsForAccount(String username);

	//public StockHistory getStockHistory(String stockType);

}
