package com.example.farmwebapp.client;

import com.example.farmwebapp.client.gui.MainGUI;
import com.example.farmwebapp.client.service.PatientServiceImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class FarmWebApp implements EntryPoint {
	
	private MainGUI gui;


	public void onModuleLoad() {
		PatientServiceImpl clientImpl = new PatientServiceImpl(GWT.getModuleBaseURL() + "PatientService");
		gui = new MainGUI(clientImpl);
		
		RootLayoutPanel rootPanel = RootLayoutPanel.get();
	    rootPanel.add(gui.getPanel());
	}
}