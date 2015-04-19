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

package com.example.farmwebapp.client.services.user;

import com.example.farmwebapp.client.dbobjects.UserData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync 
{
	public void getUsers(AsyncCallback<UserData[]> callback);
}
