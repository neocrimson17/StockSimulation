package stocksimulation.tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.ycp.cs320.stocksimulation.shared.Account;
import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.AccountSummaryCalculator;
import edu.ycp.cs320.stocksimulation.shared.BuyStock;
import edu.ycp.cs320.stocksimulation.shared.CashTransaction;
import edu.ycp.cs320.stocksimulation.shared.Deposit;
import edu.ycp.cs320.stocksimulation.shared.Money;
import edu.ycp.cs320.stocksimulation.shared.Stock;
import edu.ycp.cs320.stocksimulation.shared.StockHistory;
import edu.ycp.cs320.stocksimulation.shared.StockPrice;
import edu.ycp.cs320.stocksimulation.shared.Transaction;

public class AccountSummaryCalculatorTest {

	
	public AccountSummaryCalculatorTest(){

	}
	
	@Test
	public void testCalculateCashTransaction(){
		// Create account
		Account account = new Account();
		
		// Create a Deposit transaction
		Deposit dep = new Deposit(new Money(new BigDecimal(100)));
		dep.setTimestamp(100);
		account.addTransaction(dep);
		
		// There will be no stock transactions in this test, so
		// an empty StockHistory is fine
		StockHistory hist = new StockHistory();

		// Use an AccountSummaryCalculator to determine the effect of the
		// transactions in the account
		AccountSummaryCalculator cal = new AccountSummaryCalculator();
		AccountSummary summary = cal.calculate(account, hist, 0, 1000);
		
		// Total cash should be $100
		assertEquals(new Money(new BigDecimal(100)), summary.getAmountMoney());
	}
	
	@Test
	public void testCalculateStockTransaction(){
		// Create account
		Account account = new Account();
		StockHistory hist = new StockHistory();
		StockPrice price = new StockPrice();
		Stock stock = new Stock();
		
		stock.setId(0);
		stock.setName("Google");
		stock.setSymbol("GOOG");
		
		BuyStock buy = new BuyStock(100,stock);
		price.setStockId(0);
		price.setTimestamp(10L);
		price.setPrice(new Money(new BigDecimal(100)));
		hist.add(price);
		account.addTransaction(buy);
		
		AccountSummaryCalculator cal = new AccountSummaryCalculator();
		AccountSummary summary = cal.calculate(account, hist, 0, 1000);
		
		assertEquals(100,summary.getAmountStock().getNumShares(stock));
	}
	
}
