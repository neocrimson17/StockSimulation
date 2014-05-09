package edu.ycp.cs320.stocksimulation.server.model.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Stock;
import edu.ycp.cs320.stocksimulation.shared.StockHistory;
import edu.ycp.cs320.stocksimulation.shared.StockPortfolio;
import edu.ycp.cs320.stocksimulation.shared.Transaction;

public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby JDBC driver");
		}
	}
	
	private interface ITransaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}
	//nothing
	private static final int MAX_ATTEMPTS = 10;

	@Override
	public StockHistory getStockPricesForStock(Stock stock,
			long beginTimestamp, long endTimestamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getLogin(final String username, final String password) {
		return executeTransaction(new ITransaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
						"select logins.*" +
						" from logins" + 
						" where logins.username = ?" +
						" and logins.password = ?"
					);
					stmt.setString(1, username);
					stmt.setString(2, password);
					
					resultSet = stmt.executeQuery();
					//System.out.println("resultSet: "+resultSet.next());
					
					if (resultSet.next()){
						return true;
					}else{
						return false;
					}
					
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public boolean postLogin(final String username, final String password,
			String confirmPassword) {
		if (!password.equals(confirmPassword)){
			System.out.println("password confirmation failed!");
			return false;
		}
		
		return executeTransaction(new ITransaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				Login existing = doFindLogin(username, conn);
				if (existing != null) {
					System.out.println("That username has already been registered!");
					return false;
				}
				
				PreparedStatement stmt = null;
				
				try {
					stmt = conn.prepareStatement(
						"insert into logins (username, password) values (?, ?)"
					);
					stmt.setString(1, username);
					stmt.setString(2, password);
					
					stmt.executeUpdate();
				
					return true;
					
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});
		
	}

	@Override
	public Stock search(String symbol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cashDeposit(String user, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cashWithdrawal(String user, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buyStock(String user, int amount, Stock stockType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sellStock(String user, int amount, Stock stockType) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	public Transaction[] getTransactionsForAccount(final String username) {
		return executeTransaction(new ITransaction<Transaction[]>() {
			@Override
			public Transaction[] execute(Connection conn) throws SQLException {
				
				Login accountLogin = doFindLogin(username, conn);
				if (accountLogin == null) {
					// Unknown username?
					System.out.println("Can't find transactions for " + username + " (no such user?");
					return new Transaction[0];
				}
				
				ArrayList<Transaction> result = new ArrayList<Transaction>();
				List<Transaction> transactionList = new ArrayList<Transaction>();
				
				for (Transaction txn : transactionList) {
					if (txn.getAccountId() == accountLogin.getId()) {
						result.add(txn);
					}
				}
				
				return result.toArray(new Transaction[result.size()]);
			}
		});
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:H:/stocksimulation.db;create=true");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}

	public<ResultType> ResultType executeTransaction(ITransaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	public<ResultType> ResultType doExecuteTransaction(ITransaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						System.out.println("SQLException error has occured!");
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	public void createTables() {
		executeTransaction(new ITransaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				try {
					// login table
					stmt = conn.prepareStatement(
							"create table logins (" +
							"   id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY," +
							"   username varchar(40) not null unique," +
							"   password varchar(40) not null" +
							")"
							);
					stmt.executeUpdate();
					// cash table
					stmt2 = conn.prepareStatement(
							"create table cash (" +
							"   id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY," +
							"   cashAmount money not null" +
							")"
							);
					stmt2.executeUpdate();
					// stock table
					stmt3 = conn.prepareStatement(
							"create table stock (" +
							"   id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY," +
							"   stockName varchar(40) not null unique" +
							"   stockSymbol varchar(40) not null unique" +
							"   stockAmount int not null" +
							")"
							);
					stmt3.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new ITransaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				

				PreparedStatement insertLogin = null;
				PreparedStatement insertStock = null;
				
				// initial user
				Login log = new Login();
				log.setUsername("admin");
				log.setPassword("admin");
				
				// initial stock
				Stock google = new Stock();
				google.setName("Google, Inc.");
				google.setSymbol("GOOG");
				StockPortfolio port = new StockPortfolio();
				port.addShares(google, 0);
				
				try {
					// login
					insertLogin = conn.prepareStatement("insert into logins (username, password) values (?, ?)");
					insertLogin.setString(1, log.getName());
					insertLogin.setString(2, log.getPassword());
					
					insertLogin.executeUpdate();
					
					// stock
					insertStock = conn.prepareStatement("insert into stock (stockName, stockSymbol, stockAmount) values (?, ?, ?)");
					insertStock.setString(1, log.getName());
					insertStock.setString(2, log.getPassword());
					insertStock.setInt(3, port.getNumShares(google));
					
					insertStock.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertLogin);
					DBUtil.closeQuietly(insertStock);	
				}
			}
		});
	}
	
	private Login doFindLogin(final String username, Connection conn)
			throws SQLException {
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		Login accountLogin = null;
		try {
			stmt = conn.prepareStatement(
				"select logins.*" +
				" from logins" + 
				" where logins.username = ?"
			);
			stmt.setString(1, username);
			
			resultSet = stmt.executeQuery();
			
			if (resultSet.next()){;
				accountLogin = new Login();
				accountLogin.setUsername(username);
				return accountLogin;
			}else{
				return accountLogin;
			}
			
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
		}
	}

	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("Success!");
	}
}
