package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface CashServiceAsync {

	void cashDeposit( String username, int ammount, AsyncCallback<Boolean> callback );
	void cashWithdrawal( String username, int ammount, AsyncCallback<Boolean> callback );

}
