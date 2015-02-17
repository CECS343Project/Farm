package com.example.farmwebapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

//key down listener to check password matches repassword
//look up date list boxes 
//look up username / key down to search database to make sure 
//put guiding text inside textbox
public class FarmWebApp implements EntryPoint

{
	public void onModuleLoad()
	{
		Login login = new Login();
		Home homePage = new Home();
		NewPatient newPatient = new NewPatient();

		RootPanel.get("login").add(login.getPanel());
		RootPanel.get("homePage").add(homePage.getPanel());
		RootPanel.get("newPatient").add(newPatient.getPanel());

	}
	
}
