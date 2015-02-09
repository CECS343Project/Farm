package com.example.farmwebapp.client;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class Login extends PopUps
{

	private HorizontalPanel mainPanel = new HorizontalPanel();
	private HorizontalPanel loginTop = new HorizontalPanel();
	private VerticalPanel loginMainVert = new VerticalPanel();
	private VerticalPanel loginContent = new VerticalPanel();
	private Hyperlink signIn = new Hyperlink("SIGN IN","d.java");
	private Hyperlink signUp = new Hyperlink("SIGN UP","f.java");
	private Button buttonLogin = new Button("LOGIN");	
	private TextBox username = new TextBox();
	private PasswordTextBox password = new PasswordTextBox();
	

	public HorizontalPanel getPanel() 
	{
		loginMainVert.add(loginTop);
		loginMainVert.addStyleName("loginMainVert");
		loginTop.addStyleName("loginTop");
		loginTop.add(signIn);
		loginTop.add(signUp);
		
		loginMainVert.add(mainPanel);
		
		mainPanel.addStyleName("mainPanel");
		//loginMain.add(image);
		mainPanel.add(loginContent);
		
		loginContent.add(username);
		loginContent.add(password);
		loginContent.add(buttonLogin);
		loginContent.add(buttonLogin);
		loginContent.add(buttonLogin);
		buttonLogin.addStyleName("loginButton");
		//return loginMain ;
	
	//
	buttonLogin.addClickHandler(new ClickHandler()
	{
        public void onClick(ClickEvent event) 
        {
           // Create the new popup.
           final Confirmation popup = new Confirmation();
           // Position the popup 1/3rd of the way down and across 
           // the screen, and show the popup. Since the position 
           // calculation is based on the offsetWidth and offsetHeight 
           // of the popup, you have to use the 
           // setPopupPositionAndShow(callback)  method. The alternative 
           // would be to call show(), calculate  the left and
           // top positions, and call setPopupPosition(left, top). 
           // This would have the ugly side effect of the popup jumping 
           // from its original position to its new position.
           popup.setPopupPositionAndShow(new PopupPanel.PositionCallback()
           {
              public void setPosition(int offsetWidth, int offsetHeight) 
              {
            	  Confirmation dds = new Confirmation();
                 int left = (Window.getClientWidth() - offsetWidth) / 3;
                 int top = (Window.getClientHeight() - offsetHeight) / 3;
                 popup.setPopupPosition(left, top);
                  dds.show();
              }
             
           });
        };
	});
	
	return mainPanel;
	}
	
}

       
