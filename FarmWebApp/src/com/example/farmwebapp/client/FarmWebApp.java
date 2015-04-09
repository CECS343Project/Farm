package com.example.farmwebapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class FarmWebApp implements EntryPoint {
	
	private MainGUI gui;


	public void onModuleLoad() {
		gui = new MainGUI();
		
		RootLayoutPanel rootPanel = RootLayoutPanel.get();
	    rootPanel.add(gui.getPanel());
	}
}