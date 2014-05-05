package edu.ycp.cs320.stocksimulation.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.stocksimulation.client.CashService;
import edu.ycp.cs320.stocksimulation.client.StockService;
import edu.ycp.cs320.stocksimulation.shared.AccountSummary;

public class StockServiceImpl extends RemoteServiceServlet implements
StockService{

	@Override
	public AccountSummary buyStock(String username, int ammount,
			String stockType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountSummary sellStock(String username, int ammount,
			String stockType) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
