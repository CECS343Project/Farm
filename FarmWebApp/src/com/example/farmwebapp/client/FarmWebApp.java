package com.example.farmwebapp.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;


public class FarmWebApp implements EntryPoint
{

	@Override
	public void onModuleLoad() 
	{

		
		Button myButton = new Button("Hello");
		
		RootPanel.get("helloWorld").add(myButton);
		RootPanel.get("helloWorld").add(myButton);
		RootPanel.get("helloWorld").add(myButton);
		RootPanel.get("helloWorld").add(myButton);
		RootPanel.get("helloWorld").add(myButton);
		RootPanel.get("helloWorld").add(myButton);
	}
	
}
