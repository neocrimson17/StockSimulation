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
						"where logins.username = ?" +
						"and logins.password = ?"
					);
					stmt.setString(1, username);
					stmt.setString(2, password);
					
					resultSet = stmt.executeQuery();
					
					if (resultSet.next()){
						if (resultSet.getString(1).equals(username)&& resultSet.getString(2).equals(password)){
							return true;
						}else{
							return false;
						}	
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
	public boolean postLogin(String username, String password,
			String confirmPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean search(String symbol) {
		// TODO Auto-generated method stub
		return false;
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
	
	private Login findLogin(String username) {
		Login accountLogin = null;
//		for(Login login : LoginList)
//		{
//			if (login.getName().equals(username)) {
//					//valid = true;
//					//accountId = login.getId();
//				accountLogin = login;
//				break;
//			}
//		}
		return accountLogin;
	}
	
// need to fix this/////////////////////////////////////////////////////////
	@Override
	public Transaction[] getTransactionsForAccount(String username) {
		Login accountLogin = findLogin(username);
		if (accountLogin == null) {
			// Unknown username?
			System.out.println("Can't find transactions for " + username + " (no such user?");
			return new Transaction[0];
		}
		
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		List<Transaction> transactionList = new ArrayList<Transaction>();
		
		for (Transaction txn : transactionList) {
			//if (txn.getAccountId() == accountLogin.getId()) {
				result.add(txn);
			//}
		}
		
		return result.toArray(new Transaction[result.size()]);
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
				
				try {
					stmt = conn.prepareStatement(
							"create table logins (" +
							"   id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY," +
							"   username varchar(40) not null unique," +
							"   password varchar(40) not null" +
							")"
							);
					stmt.executeUpdate();
					
					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new ITransaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				

				PreparedStatement insertLogin = null;
				Login log = new Login();
				log.setUsername("admin");
				log.setPassword("admin");
				
				try {
					insertLogin = conn.prepareStatement("insert into logins (username, password) values (?, ?)");
					insertLogin.setString(1, log.getName());
					insertLogin.setString(2, log.getPassword());
					
					insertLogin.executeUpdate();
					
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertLogin);
					
				}
			}
		});
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
