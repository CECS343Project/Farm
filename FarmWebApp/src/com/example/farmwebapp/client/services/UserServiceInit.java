/**
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Russell
 *
 */

package com.example.farmwebapp.client.services;

import com.google.gwt.core.client.GWT;

public class UserServiceInit 
{
	public static UserServiceAsync initRpc()
	{
		UserServiceAsync rpc = (UserServiceAsync) GWT.create(UserService.class);
		return rpc;
	}
}
