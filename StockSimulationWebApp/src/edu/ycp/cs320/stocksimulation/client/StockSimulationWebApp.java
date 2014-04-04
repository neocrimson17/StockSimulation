package edu.ycp.cs320.stocksimulation.client;

import edu.ycp.cs320.stocksimulation.server.controllers.*;
import edu.ycp.cs320.stocksimulation.server.model.*;
import edu.ycp.cs320.stocksimulation.shared.FieldVerifier;
import edu.ycp.cs320.stocksimulation.shared.IPublisher;
import edu.ycp.cs320.stocksimulation.shared.ISubscriber;
import edu.ycp.cs320.stocksimulation.shared.Result;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Grid;

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
	private String userName, passWord;
	
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	private Button sendButton;


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		this.result = new Result();

		

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		
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
		TextBox searchBox = new TextBox();
		searchBox.setText("Search Box");
		absolutePanel.add(searchBox, 10, 10);
		searchBox.setSize("100px", "18px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		absolutePanel.add(scrollPanel, 10, 50);
		scrollPanel.setSize("110px", "415px");
		
		Label lblStockGrid = new Label("Stock Grid");
		scrollPanel.setWidget(lblStockGrid);
		lblStockGrid.setSize("100%", "100%");
		
		AbsolutePanel mainPanel = new AbsolutePanel();
		absolutePanel.add(mainPanel, 126, 42);
		mainPanel.setSize("543px", "415px");
		
		Label lblMainPanel = new Label("Main Panel");
		mainPanel.add(lblMainPanel, 264, 178);
		
		// Login button
				sendButton = new Button("Login");
				sendButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {

						//GetLogin controller = new GetLogin();						//Can't find GetLogin()
						userName = String.valueOf(nameField.getText());
						passWord = String.valueOf(passwordField.getText());
						//if(controller.getLogin( userName , passWord )){
							result.setValue("Welcome " + userName);
							System.out.println("\nWelcome " + userName);
							System.out.println("Password: " + passWord);
						//} else {
						//	result.setValue("Invalid Password");
						//}
					}
				});
				absolutePanel.add(sendButton, 608, 10);
				
		/**
		*  ResultView for user login. Will return "Welcome (user)" if correct,
		*  "Incorrect password" if incorrect.
		*/
		
		

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				//sendButton.setEnabled(true);
				//sendButton.setFocus(true);
			}
		});
		
		

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				//sendNameToServer();
				
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					//sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			/*private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();*/
		}
		
		
	}
}

