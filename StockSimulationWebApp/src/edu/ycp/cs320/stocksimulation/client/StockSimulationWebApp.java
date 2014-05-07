package edu.ycp.cs320.stocksimulation.client;

import java.math.BigDecimal;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.cs320.stocksimulation.shared.AccountSummary;
import edu.ycp.cs320.stocksimulation.shared.Money;
import edu.ycp.cs320.stocksimulation.shared.Result;
import edu.ycp.cs320.stocksimulation.shared.Search;
import edu.ycp.cs320.stocksimulation.shared.Stock;

import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.widget.client.TextButton;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class StockSimulationWebApp implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private Result result;
	private Result fundsResult;
	private Result stockResult;
	private ResultView resultView;
	private ResultView fundsResultView;
	private ResultView stockResultview;
	private String userName, passWord,search, confirmPassword;
	private int ammount;
	private int stockAmount;
	private String stockType;

	
	
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	private Button sendButton;
	private Button btnRegister;
	private Button btnAddFunds;
	private Button btnWithdraw;
	private Button SellStock;
	private Button BuyStock;
	private TextBox searchBox;
	private TextBox fundsTextBox;
	private TextBox stockTextBoxAmount;
	private TextBox StockTypeTextBox;
	private TextBox nameField;
	private PasswordTextBox passwordField;
	private PasswordTextBox confirmPasswordField;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		this.result = new Result();
		this.fundsResult = new Result();
		this.stockResult = new Result();

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get();
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		rootPanel.add(absolutePanel, 0, 10);
		absolutePanel.setSize("679px", "547px");
		
		this.resultView = new ResultView();
		this.fundsResultView = new ResultView();
		this.stockResultview = new ResultView();
		absolutePanel.add(resultView, 200, 39);
		absolutePanel.add(fundsResultView, 570, 87 );
		absolutePanel.add(stockResultview, 400, 87);
		resultView.setModel(result);
		fundsResultView.setModel(fundsResult);
		stockResultview.setModel(stockResult);
		
		// Username entry
		this.nameField = new TextBox();
		nameField.setText("Username");
		absolutePanel.add(nameField, 290, 10);
		nameField.setSize("88px", "16px");	
		
		// Password entry
		this.passwordField = new PasswordTextBox();
		passwordField.setText("Password");
		absolutePanel.add(passwordField, 394, 10);
		passwordField.setSize("111px", "16px");
		
		// confirm password to register
		this.confirmPasswordField = new PasswordTextBox();
		confirmPasswordField.setText("ConfirmPassword");
		absolutePanel.add(confirmPasswordField, 394, 39);
		confirmPasswordField.setSize("111px", "16px");
		
		/**
		 * Search Box to search for stocks
		 */
		searchBox = new TextBox();
		searchBox.setText("Search Box");
		absolutePanel.add(searchBox, 10, 10);
		searchBox.setSize("100px", "18px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		absolutePanel.add(scrollPanel, 10, 46);
		scrollPanel.setSize("110px", "415px");
		
		// Search results grid
		Label lblStockGrid = new Label("Search Results");
		scrollPanel.setWidget(lblStockGrid);
		lblStockGrid.setSize("100%", "100%");
		
		AbsolutePanel mainPanel = new AbsolutePanel();
		absolutePanel.add(mainPanel, 126, 67);
		mainPanel.setSize("543px", "399px");
		
		Label lblAccountFunds = new Label("Account funds: ");
		mainPanel.add(lblAccountFunds, 348, 20);
		
		this.fundsTextBox = new TextBox();
		mainPanel.add(fundsTextBox, 348, 45);
		fundsTextBox.setSize("140px", "18px");
		
		// Deposit button to allow user to deposit money
		this.btnAddFunds = new Button("Deposit");
		btnAddFunds.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleDeposit();
			}
		});
		mainPanel.add(btnAddFunds, 348, 81);
		
		// withdraw button to allow user to withdraws money 
		this.btnWithdraw = new Button("Withdraw");
		btnWithdraw.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleWithdrawal();
			}
		});
		mainPanel.add(btnWithdraw, 414, 81);
		
		this.stockTextBoxAmount = new TextBox();
		mainPanel.add(stockTextBoxAmount, 174, 45);
		stockTextBoxAmount.setSize("140px", "18px");
		
		// Label Account Stock
		Label lblAccountStock = new Label("Account stock: ");
		mainPanel.add(lblAccountStock, 174, 20);
		lblAccountStock.setSize("88px", "18px");
		
		// Buy stock button
		this.BuyStock = new Button("BuyStock");
		BuyStock.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleBuyStock();
			}
		});
		mainPanel.add(BuyStock, 173, 114);
		
		// Sell Stock Button
		this.SellStock = new Button("SellStock");
		SellStock.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleSellStock();
			}
		});
		//SellStock.setText("SellStock");
		mainPanel.add(SellStock, 252, 114);
		//SellStock.setSize("73px", "30px");
		
		// text box to allow user to enter stock type to buy
		this.StockTypeTextBox = new TextBox();
		mainPanel.add(StockTypeTextBox, 173, 81);
		StockTypeTextBox.setSize("140px", "18px");
		
		// Label "Enter stock type"
		Label lblEnterStockType = new Label("Enter Stock Type:");
		mainPanel.add(lblEnterStockType, 56, 79);
		lblEnterStockType.setSize("111px", "18px");
		
		// Label "Enter Stock Amount" 
		Label lblEnterStockAmount = new Label("Enter Stock Amount:");
		mainPanel.add(lblEnterStockAmount, 42, 45);
		lblEnterStockAmount.setSize("127px", "18px");
		
		
		
		// Login button
		sendButton = new Button("Login");
		sendButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleLogin();
			}
		});
		absolutePanel.add(sendButton, 521, 10);
		
		// register button
		this.btnRegister = new Button("Register");
		btnRegister.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleRegistration();
			}
		});
		btnRegister.setText("Register");
		absolutePanel.add(btnRegister, 570, 10);
		btnRegister.setSize("66px", "30px");
		
		// search button
		Button btnSearch = new Button("Search");
		btnSearch.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				search = String.valueOf(searchBox.getText());
				RPC.searchService.search(search, new AsyncCallback<Boolean>(){

					@Override
					public void onFailure(Throwable caught) {
						result.setValue("RPC Error!");	
					}

					@Override
					public void onSuccess(Boolean r) {
						if(r)
							result.setValue("Search success");
						else
							result.setValue("Search fail");
						
					}
					
				});
//						URL url;
//						String symbol = String.valueOf(searchBox.getText());
//						try {
//							
//							String baseUrl = "http://download.finance.yahoo.com/d/quotes.csv?s=%40%5EDJI," + symbol + "&f=nsl1op&e=.csv";
//						
//							url = new URL(baseUrl);
//							URLConnection conn = url.openConnection();
//						
//							BufferedReader br = new BufferedReader( new InputStreamReader(conn.getInputStream()));
//					
//							String inputLine;
//							while( (inputLine = br.readLine()) != null ) {
//								System.out.println( inputLine );
//							}
//						
//							br.close();
//						
//							System.out.println("Done");
//						} catch ( MalformedURLException e) {
//							e.printStackTrace();
//						} catch ( IOException e ) {
//							e.printStackTrace();
//						}
					
					}
				});
				absolutePanel.add(btnSearch, 126, 10);
				
				
				
				
				
				
				
	}
	
	// log in
	protected void handleLogin(){
		userName = String.valueOf(nameField.getText());
		passWord = String.valueOf(passwordField.getText());
		RPC.loginService.login(userName, passWord, new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean r) {
				if( r ) {
					result.setValue("Welcome " + userName );
				}else
					result.setValue("Invalid username/password");
			}

			@Override
			public void onFailure(Throwable caught) {
				result.setValue("RPC Error!");
			}
		});
	}
	
	// register
	protected void handleRegistration(){
		userName = String.valueOf(nameField.getText());
		passWord = String.valueOf(passwordField.getText());
		confirmPassword = String.valueOf(confirmPasswordField.getText());
		RPC.registrationService.register(userName, passWord, confirmPassword, new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean r) {
				if( r ) {
					result.setValue("Registration is a success!");
				}else
					result.setValue("Invalid username/password");
			}

			@Override
			public void onFailure(Throwable caught) {
				result.setValue("RPC Error!");
			}
		});
	}
	
	// add money the user's account
	protected void handleDeposit() {
		ammount = Integer.parseInt(fundsTextBox.getText());
		RPC.cashService.cashDeposit( userName, ammount , new AsyncCallback<AccountSummary>(){
			@Override
			public void onFailure( Throwable caught ) {
				// error when failed
				fundsResult.setValue("RPC Error!");
			}

			@Override
			public void onSuccess(AccountSummary result) {
				// return the amount of money deposited if successful
				GWT.log("the result cash deposit value is: "+result.getAmountMoney().getAmount().toString());
				fundsResult.setValue(result.getAmountMoney().getAmount().toString());
			}
		});	
	}
	
	// withdraw cash from the user's account
	protected void handleWithdrawal() {
		ammount = Integer.parseInt(fundsTextBox.getText());
		RPC.cashService.cashWithdrawal( userName, ammount, new AsyncCallback<AccountSummary>(){
			@Override
			public void onFailure(Throwable caught) {
				// error when failed
				fundsResult.setValue("RPC Error!");
			}
			
			@Override
			public void onSuccess(AccountSummary result) {
				// return the amount of money deposited if successful
				GWT.log("the result of cast withdraw value is: "+result.getAmountMoney().getAmount().toString());
				fundsResult.setValue(result.getAmountMoney().getAmount().toString());
			}	
		});
	}
	
	// buy stock and add to the user's account
	protected void handleBuyStock() {
		stockAmount = Integer.parseInt(stockTextBoxAmount.getText());
		stockType = String.valueOf(StockTypeTextBox.getText());
		final Stock stock = new Stock();
		stock.setSymbol(stockType);
		RPC.stockService.buyStock(userName, stockAmount , stock, new AsyncCallback<AccountSummary>(){
			@Override
			public void onFailure( Throwable caught ) {
				// error when failed
				stockResult.setValue("RPC Error!");
			}

			@Override
			public void onSuccess(AccountSummary result) {
				// return the amount of money deposited if successful
				GWT.log("the result of buying stock value is: "+result.getAmountStock().getNumShares(stock));
				String string = String.valueOf(result.getAmountStock().getNumShares(stock));
				stockResult.setValue(string);
			}
		});	
	}
		
    // sell stock and add them to the user's account
	protected void handleSellStock() {
		stockAmount = Integer.parseInt(stockTextBoxAmount.getText());
		stockType = String.valueOf(StockTypeTextBox.getText());
		final Stock stock = new Stock();
		stock.setSymbol(stockType);
		RPC.stockService.sellStock(userName, stockAmount , stock, new AsyncCallback<AccountSummary>(){
			@Override
			public void onFailure( Throwable caught ) {
				// error when failed
				stockResult.setValue("RPC Error!");
			}

			@Override
			public void onSuccess(AccountSummary result) {
				// return the amount of money deposited if successful
				GWT.log("the result of buying stock value is: "+result.getAmountStock().getNumShares(stock));
				String string = String.valueOf(result.getAmountStock().getNumShares(stock));
				stockResult.setValue(string);
			}
		});	
	}
}

