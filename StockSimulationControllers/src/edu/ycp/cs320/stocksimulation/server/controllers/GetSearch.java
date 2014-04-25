package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.IDatabase;
import edu.ycp.cs320.stocksimulation.shared.Search;

public class GetSearch {
	public boolean search( String symbol ) {
		IDatabase db = DatabaseProvider.getInstance();
		return db.search( symbol );
	}
}
