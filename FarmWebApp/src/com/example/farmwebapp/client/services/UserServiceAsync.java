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

import com.example.farmwebapp.client.dbobjects.UserData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync 
{
	public void getUsers(AsyncCallback<UserData[]> callback);
	public void getUsers(String field, String value, AsyncCallback<UserData[]> callback);
}
