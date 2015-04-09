package com.example.farmwebapp.client;

import com.example.farmwebapp.client.gui.AddPatient;
import com.example.farmwebapp.client.gui.Doctor;
import com.example.farmwebapp.client.gui.FindPatient;
import com.example.farmwebapp.client.gui.MainGUI;
import com.example.farmwebapp.client.gui.Pharmacy;
import com.example.farmwebapp.client.gui.SignIn;
import com.example.farmwebapp.client.gui.SignUp;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class FarmWebApp implements EntryPoint {
	
	private MainGUI gui = new MainGUI();



		

	
	public void onModuleLoad() {
		RootLayoutPanel rootPanel = RootLayoutPanel.get();
	    rootPanel.add(gui.getPanel());
	    
	}
}