package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.stocksimulation.shared.Login;

public interface LoginServiceAsync {

	void login(String username, String password, AsyncCallback<Boolean> callback);

}
