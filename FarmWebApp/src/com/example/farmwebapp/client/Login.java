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

	CheckBox cbLogin = new CheckBox("Show Text");
	

	public VerticalPanel getPanel() 
	{
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
		
		bLogin.addClickHandler(new ClickHandler() 
		{
	        public void onClick(ClickEvent event) 
	        {
	        	try
	        	{
		            PopUps popups = new PopUps();
		            popups.showDialog("Welcome "  + tUsername.getText() + "!");
	        	}
	        	catch(Exception e)
	        	{
	        		
	        	}
	        }

		
	    });
		 cbLogin.addClickHandler(new ClickHandler() 
		 {
		      public void onClick(ClickEvent event) 
		      {
		        boolean checked = ((CheckBox) event.getSource()).getValue();
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

		pLoginContainer.add(pMainLoginPanel);
		cbLogin.setValue(false);
		 
		 return pLoginContainer;
		}

	protected void removePanel()
	{
		this.getPanel().removeFromParent();
	}
}
       
