package com.example.farmwebapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;


//look up username / key down to search database to make sure 

public class FarmWebApp implements EntryPoint

{
	public void onModuleLoad()
	{
		Login login = new Login();
		Home homePage = new Home();
		NewPatient newPatient = new NewPatient();

		
		
		NewAccount newAccount = new NewAccount();
		//RootPanel.get("login").add(login.getWidget());
		TabPanel pMainTabPanel = new TabPanel();
		Label lSignIn = new Label("SIGN IN");


		RootPanel.get("login").add(login.getPanel());

		RootPanel.get("homePage").add(homePage.getPanel());
		RootPanel.get("newPatient").add(newPatient.getPanel());

	}
	
}
