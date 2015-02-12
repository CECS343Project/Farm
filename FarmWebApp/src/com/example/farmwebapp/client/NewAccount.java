package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NewAccount 
{
	private VerticalPanel pMainPanel = new VerticalPanel();
	private HorizontalPanel pProfession = new HorizontalPanel();
	private HorizontalPanel pContent = new HorizontalPanel();
	private VerticalPanel pData1 = new VerticalPanel();
	private VerticalPanel pData2 = new VerticalPanel();
	
	private TextBox tFirstName = new TextBox();
	private TextBox tMiddleName = new TextBox();
	private TextBox tLastName = new TextBox();
	private TextBox tUsername = new TextBox();
	private TextBox tPassword = new TextBox();
	private TextBox tRepassword = new TextBox();
	
	 RadioButton rDoctor = new RadioButton("radioButtons", "Doctor",true);
	 RadioButton rPharmacist = new RadioButton("radioButtons", "Pharmacist");

	
	public VerticalPanel getPanel()
	{
		pMainPanel.addStyleName("mainPanel");
		pMainPanel.add(pProfession);
		pProfession.add(rDoctor);
		pProfession.add(rPharmacist);
		
		return pMainPanel;
		
	}
}
