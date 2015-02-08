package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.*;

public class Home 
{
	
	
	public VerticalPanel getPanel()
	{
		VerticalPanel pHome = new  VerticalPanel();
		//private VerticalPanel pLogo;
		VerticalPanel pButtons = new VerticalPanel();
		Button bNewPatient = new Button("New Patient");
		Button bSearchPatients = new Button("Search Patients");
		Button bSettings = new Button("Settings");
		//private Button bUpdates = new Button("Updates");
		Button bLogout = new Button("Logout");
		
		pButtons.add(bNewPatient);
		pButtons.add(bSearchPatients);
		pButtons.add(bSettings);
		pButtons.add(bLogout);
		
		pHome.add(pButtons);

		return pHome;
	}
	
	public void removePanel()
	{
		this.getPanel().removeFromParent();
	}

}
