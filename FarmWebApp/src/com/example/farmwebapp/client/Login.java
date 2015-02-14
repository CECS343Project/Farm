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
		pLoginContent.add(bLogin);
		
		
		
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
		/*
	PopUps popup = new PopUps();
	{
	if(tPassword == true)
	{
		//takes them to homepage
	}
	else if(tPassword ==  false)
	{
		popup.showDialog("Incorrect password or username");
	}	
		*/
	
	return pMainLoginPanel;
	}
	
	


}
       
