package edu.ycp.cs320.stocksimulation.server.model.persist;

import java.sql.Connection;
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
	
	private interface Transaction<ResultType> {
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
	public boolean getLogin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
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
	
//	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
//		try {
//			return doExecuteTransaction(txn);
//		} catch (SQLException e) {
//			throw new PersistenceException("Transaction failed", e);
//		}
//	}

}
