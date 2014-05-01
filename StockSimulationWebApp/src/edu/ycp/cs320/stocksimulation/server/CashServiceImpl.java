package edu.ycp.cs320.stocksimulation.server;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.stocksimulation.client.CashService;
import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.Deposit;
import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Money;
import edu.ycp.cs320.stocksimulation.shared.Withdrawal;

public class CashServiceImpl extends RemoteServiceServlet implements
		CashService {
	
	private AccountSummary accountSummary;
	private List<Login> LoginList;
	
	public CashServiceImpl(){
		LoginList = new ArrayList<Login>();
		accountSummary = new AccountSummary();
	}

	@Override
	public AccountSummary cashDeposit(String username, int amount) {

		// Link account 
		//boolean valid = false;
		Deposit deposit = new Deposit(new Money(new BigDecimal(0))  );
		//Transaction transaction = new Transaction();
		int id = 1234;

		Money money = new Money(new BigDecimal(amount));
		
		deposit.setTransaction( id , System.currentTimeMillis() );
		accountSummary.setAmountMoney(deposit.moneyTransaction(money));
		System.out.println("it got to here!");
		
		return accountSummary;
	}

	@Override
	public AccountSummary cashWithdrawal(String username, int amount) {
		// Link account 
		boolean valid = false;
		Withdrawal withdraw = new Withdrawal(new Money(new BigDecimal(0)));
		//Transaction transaction = new Transaction();
		int id = 1234;
		
		// Checks that username is valid
		for(Login login : LoginList)
		{
			if (login.getName().equals(username)) {
					valid = true;
			}
		}
		
		//Deposit
		if(valid == true) // Only deposit if the username is valid
		{
			Money money = new Money(new BigDecimal(amount));
		
			withdraw.setTransaction( id , System.currentTimeMillis() );
			accountSummary.setAmountMoney(withdraw.moneyTransaction(money));
		}
		
		
		return accountSummary;
	}

}
