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

import com.example.farmwebapp.client.services.patient.PatientService;
import com.example.farmwebapp.client.services.patient.PatientServiceAsync;
import com.google.gwt.core.client.GWT;

public class UserServiceInit 
{
	public static UserServiceAsync initRpc()
	{
		UserServiceAsync rpc = (UserServiceAsync) GWT.create(UserService.class);
		return rpc;
	}

}
