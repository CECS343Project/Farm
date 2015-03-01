package com.example.farmwebapp.client;


import java.util.EventListener;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

//do key down handler implement keyboardlistener
public class Login
{

	//private TabPanel tabpanelLogin = new TabPanel();
	//private String signIn = "Sign In";
	//private String signUp = "Sign Up";
	
	private HorizontalPanel pMainLoginPanel = new HorizontalPanel();
	//private HorizontalPanel loginTop = new HorizontalPanel();
	//private VerticalPanel loginMainVert = new VerticalPanel();
	private VerticalPanel pLoginContent = new VerticalPanel();
	//private Hyperlink signIn = new Hyperlink("SIGN IN","d.java");
	//private Hyperlink signUp = new Hyperlink("SIGN UP","f.java");
	private Button bLogin = new Button("LOGIN");	
	private TextBox tUsername = new TextBox();
	
	private PasswordTextBox tPassword = new PasswordTextBox();
	private Image iLogin = new Image("https://img0.etsystatic.com/000/0/6169781/il_fullxfull.284298540.jpg");
	//iLogin.setUrl("https://img0.etsystatic.com/000/0/6169781/il_fullxfull.284298540.jpg");
	private AbsolutePanel pImagePanel = new AbsolutePanel();
	
	//to 
	CheckBox cbLogin = new CheckBox("Show Text");
	

	public HorizontalPanel getPanel() 
	{
		//TabPanel.add(mainPanel, signIn);
		//loginMainVert.add(loginTop);
		//loginMainVert.addStyleName("loginMainVert");
	//	loginTop.addStyleName("loginTop");
		
		
		//loginMainVert.add(mainPanel);
		
		pMainLoginPanel.addStyleName("mainPanel");
		pMainLoginPanel.add(iLogin);
		iLogin.addStyleName("gwt-Image-login");
		pMainLoginPanel.add(pLoginContent);
		
		pLoginContent.addStyleName("loginContent");
		pLoginContent.add(tUsername);
		pLoginContent.add(tPassword);
		pLoginContent.add(cbLogin);
		pLoginContent.add(bLogin);
		
		tUsername.setText("Username");
		tPassword.setText("Password");
		cbLogin.setValue(false);
		//tPassword.addKeyboardListener(this);
		
		 bLogin.addClickHandler(new ClickHandler() 
		 {
	 
	         public void onClick(ClickEvent event) 
	         {
	            // Instantiate the dialog box and show it.
	            PopUps popups = new PopUps();

	            //int left = Window.getClientWidth()/ 2;
	            //int top = Window.getClientHeight()/ 2;
	           // PopUps.setPopupPosition(left, top);
	            popups.showDialog("Wrong password or username");				
	         } 
	         });
		 cbLogin.addClickHandler(new ClickHandler() 
		 {
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
		    
		 
	
	return pMainLoginPanel;
	}
	//keydown listener
	
		
		
	


}
       
