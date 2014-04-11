package edu.ycp.cs320.stocksimulation.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import edu.ycp.cs320.stocksimulation.shared.Result;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class StockSimulationWebApp implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private Result result;
	private ResultView resultView;
	private String userName, passWord,search;
	
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	private Button sendButton;
	private TextBox searchBox;


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		this.result = new Result();

		

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get();
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		rootPanel.add(absolutePanel, 0, 10);
		absolutePanel.setSize("679px", "547px");
		

		this.resultView = new ResultView();
		absolutePanel.add(resultView, 200, 10);
		resultView.setModel(result);

		
		// Username entry
		final TextBox nameField = new TextBox();
		nameField.setText("Username");
		absolutePanel.add(nameField, 365, 10);
		nameField.setSize("88px", "16px");	
		
		// Password entry
		final PasswordTextBox passwordField = new PasswordTextBox();
		passwordField.setText("Password");
		absolutePanel.add(passwordField, 469, 10);
		passwordField.setSize("111px", "16px");
		
		/**
		 * Search Box to search for stocks
		 */
		searchBox = new TextBox();
		searchBox.setText("Search Box");
		absolutePanel.add(searchBox, 10, 10);
		searchBox.setSize("100px", "18px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		absolutePanel.add(scrollPanel, 10, 50);
		scrollPanel.setSize("110px", "415px");
		
		Label lblStockGrid = new Label("Search Results");
		scrollPanel.setWidget(lblStockGrid);
		lblStockGrid.setSize("100%", "100%");
		
		AbsolutePanel mainPanel = new AbsolutePanel();
		absolutePanel.add(mainPanel, 126, 50);
		mainPanel.setSize("543px", "415px");
		
		Label lblMainPanel = new Label("Main Panel");
		mainPanel.add(lblMainPanel, 264, 178);
		
		// Login button
				sendButton = new Button("Login");
				sendButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {

						userName = String.valueOf(nameField.getText());
						passWord = String.valueOf(passwordField.getText());
						RPC.loginService.login(userName, passWord, new AsyncCallback<Boolean>() {
							@Override
							public void onSuccess(Boolean r) {
								if( r )
									result.setValue("Welcome " + userName );
								else
									result.setValue("Invalid username/password");
							}

							@Override
							public void onFailure(Throwable caught) {
								result.setValue("RPC Error!");
							}
						});
					}
				});
				absolutePanel.add(sendButton, 608, 10);
				
				Button btnSearch = new Button("Search");
				btnSearch.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						URL url;
						String symbol = String.valueOf(searchBox.getText());
						try {
							
							String baseUrl = "http://download.finance.yahoo.com/d/quotes.csv?s=%40%5EDJI," + symbol + "&f=nsl1op&e=.csv";
						
							url = new URL(baseUrl);
							URLConnection conn = url.openConnection();
						
							BufferedReader br = new BufferedReader( new InputStreamReader(conn.getInputStream()));
					
							String inputLine;
							while( (inputLine = br.readLine()) != null ) {
								System.out.println( inputLine );
							}
						
							br.close();
						
							System.out.println("Done");
						} catch ( MalformedURLException e) {
							e.printStackTrace();
						} catch ( IOException e ) {
							e.printStackTrace();
						}
					
					}
				});
				absolutePanel.add(btnSearch, 126, 10);
	}
}

