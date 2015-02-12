package com.example.farmwebapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;


public class FarmWebApp implements EntryPoint
{
	
	//@Override
	public void onModuleLoad() 
	{
		Login login = new Login();
		Home homePage = new Home();
		
		RootPanel.get("login").add(login.getPanel());
		RootPanel.get("homePage").add(homePage.getPanel());
		
	
	}
	
}
