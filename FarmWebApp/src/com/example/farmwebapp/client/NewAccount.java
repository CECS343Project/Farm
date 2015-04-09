package com.example.farmwebapp.client;

//import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
//import com.google.gwt.event.logical.shared.ValueChangeEvent;
//import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

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
	
	private TextBox tFirstName = new TextBox();
	private TextBox tLastName = new TextBox();
	//date of birth is a drop down
	private ListBox lbSuffix = new ListBox();
	
	private TextBox tUsername = new TextBox();
	private TextBox tPassword = new TextBox();
	private TextBox tRePassword = new TextBox();
	private TextBox tEmail = new TextBox();
	private TextBox tReEmail = new TextBox();
	private TextBox tLicense= new TextBox();
	private TextBox tPhone = new TextBox();
	
	private Label lName = new Label("NAME: ");
	private Label lUserName = new Label("USERNAME: ");
	private Label lEmail = new Label("EMAIL:");
	private Label lPassword = new Label("PASSWORD:");
	private Label lLicense = new Label("LICENSE No:");
	private Label lPhone = new Label("PHONE No:");
	private Label lDoB = new Label("DATE OF BIRTH:");
	
	private RadioButton rDoctor = new RadioButton("radioButtons", "Doctor",true);
	private RadioButton rPharmacist = new RadioButton("radioButtons", "Pharmacist");
	
	private Button bSignIn = new Button("SIGN UP");
	
	private DatePicker dpSignUp = new DatePicker();
    final Label lDate = new Label();

	public VerticalPanel getPanel()
	{
		pMainPanel.add(pProfession);
		pProfession.add(rDoctor);
		pProfession.add(rPharmacist);
		pMainPanel.add(pContent);
		pContent.add(lName);
		pContent.add(tFirstName);
		pContent.add(tLastName);
		pContent.add(lbSuffix);
		lbSuffix.addItem("Jr.");
	    lbSuffix.addItem("Sr.");
	    // Make enough room for all five items (setting this value to 1 turns it
	    // into a drop-down list).
	    lbSuffix.setVisibleItemCount(1);
		
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
		
     // Create a DateBox
     DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
     DateBox dbSignIn = new DateBox();
     dbSignIn.setFormat(new DateBox.DefaultFormat(dateFormat));
	
     pContent4.add(dbSignIn);
        dbSignIn.addStyleName("dateBox"); //style this to make it smaller
	pContent4.add(bSignIn);
	bSignIn.addStyleName("newAccountButton");


	
     	pContent4.add(dbSignIn);
     	pContent4.add(bSignIn);
		bSignIn.addStyleName("newAccountButton");
	
		bSignIn.addClickHandler(new ClickHandler() 
		{
	 
	        public void onClick(ClickEvent event) 
	        {
	           PopUps popups = new PopUps();
	           popups.showDialog("Thank you for signing up");           
	        }
	    });

		return pMainPanel;
	}
	
	protected void removePanel()
	{
		this.getPanel().removeFromParent();
	}
}
