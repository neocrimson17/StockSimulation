package edu.ycp.cs320.stocksimulation.server;

import javax.servlet.ServletContextEvent;
import java.util.Scanner;
import javax.servlet.ServletContextListener;

import edu.ycp.cs320.stocksimulation.server.model.persist.DatabaseProvider;
import edu.ycp.cs320.stocksimulation.server.model.persist.DerbyDatabase;
import edu.ycp.cs320.stocksimulation.server.model.persist.FakeDatabase;

public class DatabaseInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		// Webapp is started
//		DatabaseProvider.setInstance(new FakeDatabase()); // FIXME: replace with real database
//		System.out.println("FakeDatabase initialized!");
		DatabaseProvider.setInstance(new DerbyDatabase());
		System.out.println("DerbyDatabase initialized!");

	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// Webapp is shutting down
	}

}
