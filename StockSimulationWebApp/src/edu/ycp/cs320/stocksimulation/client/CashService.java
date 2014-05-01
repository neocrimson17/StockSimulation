package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.stocksimulation.shared.AccountSummary;

@RemoteServiceRelativePath("cashService")
public interface CashService extends RemoteService {
	public AccountSummary cashDeposit( String username, int ammount );
	public AccountSummary cashWithdrawal( String username, int ammount );
}
