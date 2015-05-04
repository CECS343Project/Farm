package com.example.farmwebapp.server;

import com.example.farmwebapp.client.dbobjects.UserData;
import com.example.farmwebapp.client.services.user.UserService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UserServiceImpl  extends RemoteServiceServlet implements UserService
{

	public UserData[] getUsers() {
		// TODO Auto-generated method stub
		return null;
	}



}
