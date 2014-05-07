package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrationServiceAsync {
	void register(String username, String password, String confirmPassword, AsyncCallback<Boolean> callback);
}
