package edu.ycp.cs320.stocksimulation.server;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.stocksimulation.client.CashService;
import edu.ycp.cs320.stocksimulation.server.controllers.DepositController;
import edu.ycp.cs320.stocksimulation.server.controllers.WithdrawController;
import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.Deposit;
import edu.ycp.cs320.stocksimulation.shared.Login;
import edu.ycp.cs320.stocksimulation.shared.Money;
import edu.ycp.cs320.stocksimulation.shared.Withdrawal;

public class CashServiceImpl extends RemoteServiceServlet implements
		CashService {
	
	public CashServiceImpl(){
	}

	@Override
	public AccountSummary cashDeposit(String username, int amount) {
		DepositController controller = new DepositController();
		return controller.cashDeposit(username, amount);
	}

	@Override
	public AccountSummary cashWithdrawal(String username, int amount) {
		WithdrawController controller = new WithdrawController();
		return controller.cashWithdrawal(username, amount);
	}

}
