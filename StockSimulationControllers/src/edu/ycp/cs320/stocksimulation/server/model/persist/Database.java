package edu.ycp.cs320.stocksimulation.server.model.persist;

/**
 * Allow access to the singleton {@link IDatabase} implementation.
 */
public class Database {
	private static final IDatabase theInstance = new FakeDatabase();
	
	/**
	 * Get the singleton {@link IDatabase} implementation.
	 * 
	 * @return the singleton {@link IDatabase} implementation
	 */
	public static IDatabase getInstance() {
		return theInstance;
	}
}
