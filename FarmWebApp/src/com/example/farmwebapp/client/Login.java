package com.example.farmwebapp.client;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

//create tab panel
//do both sign in and sign up page using tab panel
//add dialogue box
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

	public VerticalPanel getPanel() 
	{
		
		TabPanel pMainTabPanel = new TabPanel();
		Label lSignIn = new Label("SIGN IN");
		Label lSignUp = new Label("SIGN UP");
		
		pLoginContent.addStyleName("loginContent");
		pLoginContent.add(tUsername);
		pLoginContent.add(tPassword);
		pLoginContent.add(bLogin);
		
		pMainLoginPanel.add(iLogin);
		pMainLoginPanel.add(pLoginContent);
		
		tUsername.setText("Username");
		tPassword.setText("Password");
		
		
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
		pLoginContainer.addStyleName("mainPanel");
	
	return pLoginContainer;
	}
	
	protected void removePanel()
	{
		this.getPanel().removeFromParent();
		newAccount.removePanel();
	}
	
	


}
       
