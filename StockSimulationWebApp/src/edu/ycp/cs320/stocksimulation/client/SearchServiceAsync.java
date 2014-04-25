package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Search;

public interface SearchServiceAsync {

	void search(String symbol, AsyncCallback<Boolean> asyncCallback);

}
