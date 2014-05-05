package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.stocksimulation.shared.AccountSummary;

@RemoteServiceRelativePath("stockService")
public interface StockService extends RemoteService {
	public AccountSummary buyStock( String username, int ammount, String stockType );
	public AccountSummary sellStock( String username, int ammount, String stockType );
}
