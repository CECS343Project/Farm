package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.*;

public class NewAccount 
{
	private VerticalPanel pMainPanel = new VerticalPanel();
	private HorizontalPanel pProfession = new HorizontalPanel();
	private HorizontalPanel pContent = new HorizontalPanel();
	private HorizontalPanel pContent2 = new HorizontalPanel();
	private HorizontalPanel pContent3 = new HorizontalPanel();
	private HorizontalPanel pContent4 = new HorizontalPanel();
	
	
	private VerticalPanel pData1 = new VerticalPanel();
	private VerticalPanel pData2 = new VerticalPanel();
	private VerticalPanel pData3 = new VerticalPanel();
	private VerticalPanel pData4 = new VerticalPanel();
	private VerticalPanel pData5 = new VerticalPanel();
	private VerticalPanel pData6 = new VerticalPanel();
	
	private TextBox tFirstName = new TextBox();
	private TextBox tLastName = new TextBox();
	private TextBox tSuffix = new TextBox();
	private TextBox tUsername = new TextBox();
	private TextBox tPassword = new TextBox();
	private TextBox tRePassword = new TextBox();
	private TextBox tEmail = new TextBox();
	private TextBox tReEmail = new TextBox();
	private TextBox tLicense= new TextBox();
	private TextBox tPhone = new TextBox();
	
	//date of birth is a drop down
	
	private Label lName = new Label("NAME: ");
	private Label lUserName = new Label("USERNAME: ");
	private Label lEmail = new Label("EMAIL:");
	private Label lPassword = new Label("PASSWORD:");
	private Label lLicense = new Label("LICENSE No:");
	private Label lPhone = new Label("PHONE No:");
	private Label lDoB = new Label("DATE OF BIRTH:");
	
	private RadioButton rDoctor = new RadioButton("radioButtons", "Doctor",true);
	private RadioButton rPharmacist = new RadioButton("radioButtons", "Pharmacist");
	
	private ListBox lbMonth = new ListBox();
	private ListBox lbDay = new ListBox();
	private ListBox lbYear = new ListBox();
	 
	
	public VerticalPanel getPanel()
	{
		pMainPanel.addStyleName("mainPanel");
		pMainPanel.add(pProfession);
		pProfession.add(rDoctor);
		pProfession.add(rPharmacist);
		pMainPanel.add(pContent);
		pContent.add(lName);
		pContent.add(tFirstName);
		pContent.add(tLastName);
		pContent.add(tSuffix);
		
		//second row
		pMainPanel.add(pContent2);
		pContent2.add(lUserName);
		pContent2.add(pData1);
		pData1.add(tUsername);
		
		pContent2.add(lEmail);
		pContent2.add(pData2);
		pData2.add(tEmail);
		pData2.add(tReEmail);
		
		//third row
		pMainPanel.add(pContent3);
		pContent3.add(lPassword);
		pContent3.add(pData3);
		pData3.add(tPassword);
		pData3.add(tRePassword);
		
		
		pContent3.add(pData4);
		pData4.add(lLicense);
		pData4.add(lPhone);
		pContent3.add(pData5);
		pData5.add(tLicense);
		pData5.add(tPhone);
		
		pMainPanel.add(pContent4);
		pContent4.add(lDoB);
		pContent4.add(lbMonth);
		//for(int i=1; i<31;i++)
		//{
		//	lbDay.addItem(i);
		//}
		pContent4.add(lbDay);
		pContent4.add(lbYear);
		
		
		
		
		
		return pMainPanel;
		
	}
	
	protected void removePanel()
	{
		this.getPanel().removeFromParent();
	}
}
