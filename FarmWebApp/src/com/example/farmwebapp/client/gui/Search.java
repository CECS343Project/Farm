package com.example.farmwebapp.client.gui;

import com.google.gwt.user.client.ui.*;

public class Search 
{

	private VerticalPanel pMain = new VerticalPanel();
	private HorizontalPanel pName = new HorizontalPanel();
	private HorizontalPanel pInfo = new HorizontalPanel(); 
	private HorizontalPanel pInfo2 = new HorizontalPanel();
	
	private VerticalPanel pAddress = new VerticalPanel();
	private VerticalPanel pEmail = new VerticalPanel();
	
	//first row
	private Label lName = new Label("Name: ");
	private TextBox tFirstName = new TextBox();
	private TextBox tLastName = new TextBox();
	private ListBox lbSuffix = new ListBox();
	
	//second row
	private Label lAddress = new Label("Address:: ");
	private TextBox tStreet = new TextBox();
	private TextBox tCity = new TextBox();
	private ListBox lbState = new ListBox();
	private TextBox tZip = new TextBox();
	
	 public VerticalPanel getPanel()
	 {
		 pMain.add(pName);
		 pMain.add(pInfo);
		 pMain.add(pInfo2);
		 
		 pName.add(tFirstName);
		 pName.add(tLastName);
		 pName.add(lbSuffix);
		return pMain;
		 
		 
	 }
	
}
