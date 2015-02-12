package com.example.farmwebapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

//key down listener to check password matches repassword
//look up date list boxes 
//look up username / key down to search database to make sure 
//put guiding text inside textbox
public class FarmWebApp 
{
	public void onModuleLoad()
	{
		Login login = new Login();
		NewAccount newAccount = new NewAccount();
		//RootPanel.get("login").add(login.getWidget());
		TabPanel pMainTabPanel = new TabPanel();
		Label lSignIn = new Label("SIGN IN");
		Label lSignUp = new Label("SIGN UP");
		pMainTabPanel.add(login.getPanel(), lSignIn);
		pMainTabPanel.add(newAccount.getPanel(), lSignUp);
		
		pMainTabPanel.selectTab(0);
		 pMainTabPanel.setWidth("600");
		 pMainTabPanel.setHeight("100");
		RootPanel.get("main").add(pMainTabPanel);
	}
}
