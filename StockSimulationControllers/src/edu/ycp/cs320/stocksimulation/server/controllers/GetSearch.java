package edu.ycp.cs320.stocksimulation.server.controllers;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.IDatabase;
import edu.ycp.cs320.stocksimulation.shared.Search;
import edu.ycp.cs320.stocksimulation.shared.Stock;

public class GetSearch {
	public Stock search( String symbol ) {
		IDatabase db = DatabaseProvider.getInstance();
		return db.search( symbol );
	}
}
