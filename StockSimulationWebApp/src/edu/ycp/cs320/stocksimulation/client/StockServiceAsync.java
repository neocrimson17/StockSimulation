package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.Stock;

public interface StockServiceAsync {
	void buyStock( String username, int ammount, Stock stockType, AsyncCallback<AccountSummary> callback );
	void sellStock( String username, int ammount, Stock stockType, AsyncCallback<AccountSummary> callback );
}
