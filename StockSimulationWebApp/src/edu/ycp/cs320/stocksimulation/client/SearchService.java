package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.stocksimulation.shared.Search;

@RemoteServiceRelativePath("search")
public interface SearchService extends RemoteService {
	public boolean search(String symbol);
}
