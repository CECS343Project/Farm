/**
 * FarmWebApp
 * GWT Web application for CECS 343 - Intro to Software Engineering
 * Developed using java with the gwt framework
 * Gui and styling is handled by css + html with jframe-like java objects
 * Mysql database access is handled by asynchronous RPC calls and jdbc driver
 * 
 * @author Russell Tan
 * @author Napoleon Fulinara Jr.
 * @author Daryl Blancaflor
 * @author Ted Kim
 */
package com.example.farmwebapp.client;

import com.example.farmwebapp.client.gui.MainGUI;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class FarmWebApp implements EntryPoint 
{	
	
	private MainGUI gui;
	private String userType = "null";
	
	/**
	 * Defines the entry point of the web application
	 * loads the main gui which holds the entirety of the application
	 */
	public void onModuleLoad() 
	{
		gui = new MainGUI();
		
		//Places gui into the root panel of the client screen
		RootLayoutPanel rootPanel = RootLayoutPanel.get();
		rootPanel.add(gui.getPanel());
	}
	
	public void refreshUI()
	{
		
		gui = new MainGUI();
		
		//Places gui into the root panel of the client screen
		RootLayoutPanel rootPanel = RootLayoutPanel.get();
		rootPanel.clear();
		
		if(userType == "null")
		{
			rootPanel.add(gui.getPanel());
		}
		else if(userType == "doctor")
		{
			rootPanel.add(gui.getPanelDoc());
		}
		else if(userType == "pharmacist")
		{
			rootPanel.add(gui.getPanelPharm());
		}
	}

	public void setUserType(String string) 
	{
		userType = string;
	}
}