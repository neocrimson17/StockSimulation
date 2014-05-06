package edu.ycp.cs320.stocksimulation.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.stocksimulation.client.StockService;
import edu.ycp.cs320.stocksimulation.server.controllers.BuyStockController;
import edu.ycp.cs320.stocksimulation.server.controllers.SellStockController;
import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.Stock;

public class StockServiceImpl extends RemoteServiceServlet implements
StockService{

	public StockServiceImpl(){
		
	}
	// buy stock
	@Override
	public AccountSummary buyStock(String username, int amount,
			Stock stockType) {
		BuyStockController controller = new BuyStockController();
		return controller.buyStock(username, amount, stockType);
	}
	// sell stock
	@Override
	public AccountSummary sellStock(String username, int amount,
			Stock stockType) {
		SellStockController controller = new SellStockController();
		return controller.sellStock(username, amount, stockType);
	}

	
	
}
