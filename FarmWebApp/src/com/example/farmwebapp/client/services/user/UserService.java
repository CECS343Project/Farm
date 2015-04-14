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

import com.example.farmwebapp.client.dbobjects.PatientData;
import com.example.farmwebapp.client.dbobjects.UserData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService
{
	public UserData[] getUsers();
}
