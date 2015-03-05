package com.example.farmwebapp.client;


import java.util.EventListener;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

//do key down handler implement keyboardlistener
public class Login
{

	private VerticalPanel pLoginContainer = new VerticalPanel();
	private HorizontalPanel pMainLoginPanel = new HorizontalPanel();
	private VerticalPanel pLoginContent = new VerticalPanel();
	private Button bLogin = new Button("LOGIN");	
	private TextBox tUsername = new TextBox();
	
	private PasswordTextBox tPassword = new PasswordTextBox();
	private Image iLogin = new Image("pill_bug_logo.jpg");
	private NewAccount newAccount = new NewAccount();
	//to 
	CheckBox cbLogin = new CheckBox("Show Text");
	

	public VerticalPanel getPanel() 
	{
		
		TabPanel pMainTabPanel = new TabPanel();
		Label lSignIn = new Label("SIGN IN");
		Label lSignUp = new Label("SIGN UP");
		
		pLoginContent.addStyleName("loginContent");
		pLoginContent.add(tUsername);
		pLoginContent.add(tPassword);
		pLoginContent.add(cbLogin);
		pLoginContent.add(bLogin);
		
		pMainLoginPanel.add(iLogin);
		pMainLoginPanel.add(pLoginContent);
		
		tUsername.setText("Username");
		tPassword.setText("Password");
		cbLogin.setValue(false);
		//tPassword.addKeyboardListener(this);
		pMainTabPanel.add(pMainLoginPanel, lSignIn);
		pMainTabPanel.add(newAccount.getPanel(), lSignUp);
		bLogin.addClickHandler(new ClickHandler() 
		{
	 
	        public void onClick(ClickEvent event) 
	        {
	           PopUps popups = new PopUps();
	           popups.showDialog("Wrong password or username");
	           removePanel();
	            
	        }

		
	    });
		
		pMainTabPanel.selectTab(0);
		pLoginContainer.add(pMainTabPanel);
		     // @Override
		      public void onClick(ClickEvent event) 
		      {
		        boolean checked = ((CheckBox) event.getSource()).getValue();
		      //  Window.alert("It is " + (checked ? "" : "not ") + "checked");
		        if(checked)
		        {
		        	tPassword.getElement().setAttribute("type", "text");
		        }
		        else
		        {
		        	tPassword.getElement().setPropertyString("type", "password");
		        }
		        }
		      });
		    
		 
	
	protected void removePanel()
	{
		this.getPanel().removeFromParent();
		newAccount.removePanel();
	}
	//keydown listener
	
		
		
	


}
       
