package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.stocksimulation.shared.AccountSummary;

public interface StockServiceAsync {
	void buyStock( String username, int ammount, String stockType, AsyncCallback<AccountSummary> callback );
	void sellStock( String username, int ammount, String stockType, AsyncCallback<AccountSummary> callback );
}
