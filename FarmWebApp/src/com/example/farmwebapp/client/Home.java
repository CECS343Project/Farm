/**
 * 
 */

package com.example.farmwebapp.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

public class Home 
{
	private HorizontalPanel pHome = new  HorizontalPanel();
	private VerticalPanel pLogo = new VerticalPanel();
	private VerticalPanel pButtons = new VerticalPanel();
	/**
	 * 
	 * @return
	 */
	public HorizontalPanel getPanel()
	{
		
		
		Image iLogo = new Image("pill_bug_logo.jpg");
		
		Button bNewPatient = new Button("New Patient");
		Button bSearchPatients = new Button("Search Patients");
		Button bSettings = new Button("Settings");
		//Button bUpdates = new Button("Updates");
		Button bLogout = new Button("Logout");
		
		pButtons.add(bNewPatient);
		pButtons.add(bSearchPatients);
		pButtons.add(bSettings);
		pButtons.add(bLogout);
		
		pLogo.add(iLogo);
		
		pHome.add(pLogo);
		pHome.add(pButtons);
		
		pHome.addStyleName("mainPanel");
		
		bLogout.addClickHandler(new ClickHandler() 
		{
	 
	        public void onClick(ClickEvent event) 
	        {
	           PopUps popups = new PopUps();
	           popups.showDialog("Thank you for choosing Pill Bug!");
	           removePanel();
	            
	        }

		
	    });

		return pHome;
	}
	
	/**
	 * 
	 */
	protected void removePanel()
	{
		this.getPanel().removeFromParent();
	}

}
