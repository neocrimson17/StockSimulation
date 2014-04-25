package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("cashService")
public interface CashService extends RemoteService {
	public boolean cashDeposit( String username, int ammount );
	public boolean cashWithdrawal( String username, int ammount );
}
