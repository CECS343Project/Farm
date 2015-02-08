package com.example.farmwebapp.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


public class FarmWebApp implements EntryPoint
{
	
	public void onModuleLoad() 
	{
		Home homePage = new Home();
		
		RootPanel.get("homePage").add(homePage.getPanel());		
	}
	
	
}
