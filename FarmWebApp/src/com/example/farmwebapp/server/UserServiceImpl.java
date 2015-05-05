package com.example.farmwebapp.server;

import com.example.farmwebapp.client.dbobjects.UserData;
import com.example.farmwebapp.client.services.UserService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UserServiceImpl  extends RemoteServiceServlet implements UserService
{

	@Override
	public UserData[] getUsers() 
	{
		DB_User db = new DB_User();
		return db.getUsers();
	}

	@Override
	public UserData[] getUsers(String field, String value) 
	{
		return null;
	}



}
