package com.example.farmwebapp.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;


public class FarmWebApp implements EntryPoint
{

	@Override
	public void onModuleLoad() 
	{
		MGWT.applySettings(MGWTSettings.getAppSetting());
		
		Button myButton = new Button("Hello");
		
		RootPanel.get("helloWorld").add(myButton);
	}
	
}
