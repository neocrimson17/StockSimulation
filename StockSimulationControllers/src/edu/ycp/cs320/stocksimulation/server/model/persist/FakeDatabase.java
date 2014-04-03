package edu.ycp.cs320.stocksimulation.server.model.persist;

import java.util.List;
import java.util.ArrayList;

import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Stock;
import edu.ycp.cs320.stocksimulation.shared.StockHistory;

public class FakeDatabase implements IDatabase{
    
	// field(s)
	private List<Login> LoginList;
	
	// constructor
	public FakeDatabase() {
		LoginList = new ArrayList<Login>();
		// Populate initial list with master account
		LoginList.add(new Login("admin", "admin"));
	}
	
	@Override
	public StockHistory getStockPricesForStock(Stock stock,
			long beginTimestamp, long endTimestamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getLogin(String username, String password) {
		//Check for existing login
		for(Login login : LoginList)
		{
			if (login.getName().equals(username)) {
				if (login.getPassword().equals(password))
				{
				//return a copy
				//return new Login(login.getName(), login.getPassword());
				return true;
				}
			}
		}
		return false;
	}

	@Override
	public Login postLogin(String username, String password) {
		// Add account if it does not exist
		boolean result = false;
		//Check to make sure
		for (Login login: LoginList){
			if (login.getName().equals(username) && login.getPassword().equals(password)){
				result = true;
				break;
			}
		}
		if (result == false){
			Login newLogin = new Login(username, password);
			LoginList.add(newLogin);
			return newLogin;
		}
		return null;
	}

	
}
