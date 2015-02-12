package com.example.farmwebapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;


public class FarmWebApp 
{
	public void onModuleLoad()
	{
		Login login = new Login();
		NewAccount newAccount = new NewAccount();
		//RootPanel.get("login").add(login.getWidget());
		TabPanel pMainTabPanel = new TabPanel();
		Label lSignIn = new Label("Sign In");
		Label lSignUp = new Label("Sign Up");
		pMainTabPanel.add(login.getPanel(), lSignIn);
		pMainTabPanel.add(newAccount.getPanel(), lSignUp);
		
		pMainTabPanel.selectTab(0);
		 pMainTabPanel.setWidth("600");
		 pMainTabPanel.setHeight("200");
		RootPanel.get("main").add(pMainTabPanel);
	}
}
