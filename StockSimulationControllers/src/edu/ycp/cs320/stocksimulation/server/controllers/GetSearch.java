package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.shared.Search;

public class GetSearch {
	public Search search( String symbol ) {
		return DatabaseProvider.getInstance().search( symbol );
	}
}
