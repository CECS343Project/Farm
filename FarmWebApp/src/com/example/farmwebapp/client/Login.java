package com.example.farmwebapp.client;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

//create tab panel
//do both sign in and sign up page using tab panel
//add dialogue box
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
	

	public TabPanel getPanel() 
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
	
	return pMainTabPanel;
	}
	
	protected void removePanel()
	{
		this.getPanel().removeFromParent();
	}
	
	


}
       
