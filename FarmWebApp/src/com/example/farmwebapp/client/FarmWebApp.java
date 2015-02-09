package com.example.farmwebapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;


public class FarmWebApp implements EntryPoint
{
	
	//@Override
	public void onModuleLoad() 
	{
		Login login = new Login();
		RootPanel.get("login").add(login.getPanel());
		
	
	}
	
}
