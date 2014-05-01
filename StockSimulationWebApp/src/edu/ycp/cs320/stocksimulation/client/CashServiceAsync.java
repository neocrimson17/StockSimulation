package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.stocksimulation.shared.AccountSummary;


public interface CashServiceAsync {

	void cashDeposit( String username, int ammount, AsyncCallback<AccountSummary> callback );
	void cashWithdrawal( String username, int ammount, AsyncCallback<AccountSummary> callback );

}
