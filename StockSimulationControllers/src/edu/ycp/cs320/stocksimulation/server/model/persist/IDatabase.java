package edu.ycp.cs320.stocksimulation.server.model.persist;

import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Search;
import edu.ycp.cs320.stocksimulation.shared.Stock;
import edu.ycp.cs320.stocksimulation.shared.StockHistory;

public interface IDatabase {
	public StockHistory getStockPricesForStock(Stock stock, long beginTimestamp, long endTimestamp); 
	
	public boolean getLogin(String username, String password);
	
	public Login postLogin(String username, String password);
	
	public boolean search( String symbol );
	
	public boolean cashDeposit( String user, int ammount );
	
	public boolean cashWithdrawal( String user, int ammount );

}
