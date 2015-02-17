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
	private Image iLogin = new Image("https://img0.etsystatic.com/000/0/6169781/il_fullxfull.284298540.jpg");
	

	public VerticalPanel getPanel() 
	{
		NewAccount newAccount = new NewAccount();
		TabPanel pMainTabPanel = new TabPanel();
		Label lSignIn = new Label("SIGN IN");
		Label lSignUp = new Label("SIGN UP");
		
		pMainLoginPanel.addStyleName("mainPanel");
		pMainLoginPanel.add(iLogin);
		iLogin.addStyleName("gwt-Image-login");
		pMainLoginPanel.add(pLoginContent);
		
		pLoginContent.addStyleName("loginContent");
		pLoginContent.add(tUsername);
		pLoginContent.add(tPassword);
		pLoginContent.add(bLogin);
		
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
	            newAccount.removePanel();
	            removePanel();
	            
	         }

		
	         });
	
	return pLoginContainer;
	}
	
	protected void removePanel()
	{
		this.getPanel().removeFromParent();
	}
	
	


}
       
