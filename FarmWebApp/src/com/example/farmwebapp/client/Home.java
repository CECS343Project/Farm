/**
 * 
 */

package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.*;

public class Home 
{
	
	/**
	 * 
	 * @return
	 */
	public HorizontalPanel getPanel()
	{
		HorizontalPanel pHome = new  HorizontalPanel();
		VerticalPanel pLogo = new VerticalPanel();
		VerticalPanel pButtons = new VerticalPanel();
		
		Image iLogo = new Image("pill_bug_logo.jpg");
		
		Button bNewPatient = new Button("New Patient");
		Button bSearchPatients = new Button("Search Patients");
		Button bSettings = new Button("Settings");
		Button bUpdates = new Button("Updates");
		Button bLogout = new Button("Logout");
		
		pButtons.add(bNewPatient);
		pButtons.add(bSearchPatients);
		pButtons.add(bSettings);
		pButtons.add(bLogout);
		
		pLogo.add(iLogo);
		
		pHome.add(pLogo);
		pHome.add(pButtons);
		
		pHome.addStyleName("mainPanel");

		return pHome;
	}
	
	/**
	 * 
	 */
	public void removePanel()
	{
		this.getPanel().removeFromParent();
	}

}
