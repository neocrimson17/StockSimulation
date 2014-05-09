package edu.ycp.cs320.stocksimulation.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.stocksimulation.client.CashService;
import edu.ycp.cs320.stocksimulation.client.SearchService;
import edu.ycp.cs320.stocksimulation.server.controllers.GetSearch;
import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.Stock;

public class SearchServiceImpl extends RemoteServiceServlet implements
SearchService {
	public SearchServiceImpl(){
		
	}

	@Override
	public Stock search(String symbol) {
		Stock errorStock = new Stock();
		
		errorStock.setId(1111);
		errorStock.setName("ERROR");
		errorStock.setSymbol("ERR");
		
		GetSearch controller = new GetSearch();
		
		System.out.println("Attempt to search for " + symbol );
		
		return controller.search(symbol);
	}

	
	
	

}
