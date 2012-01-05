package com.ipinyou.test.service;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class ServerPasswordCallback implements CallbackHandler {

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {

		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

		// Set the password on the callback. This will be compared to the
		// password which was sent from the client.
		// We can call pc.getIdentifer() right here to check the username
		// if we want each client to have it's own password.
		if (pc.getIdentifier().equals("1111")) {
			pc.setPassword("optimuspasswd");
		} else if (pc.getIdentifier().equals("test")) {
			pc.setPassword("testtest");
		} else {
			throw new SecurityException("Wrong Password!");
		}
	}

}
