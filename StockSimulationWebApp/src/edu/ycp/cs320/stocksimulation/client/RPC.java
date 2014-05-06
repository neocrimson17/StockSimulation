package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.core.client.GWT;

public class RPC {
	public static final LoginServiceAsync loginService =
			GWT.create(LoginService.class);
	
	public static final SearchServiceAsync searchService = 
			GWT.create(SearchService.class);
	
	public static final CashServiceAsync cashService =
			GWT.create(CashService.class);
	
	public static final StockServiceAsync stockService =
			GWT.create(StockService.class);

}
