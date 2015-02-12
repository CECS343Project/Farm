package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.*;

public class NewPatient 
{
	public VerticalPanel getPanel()
	{
		VerticalPanel pNewPatientMain = new VerticalPanel();
		FlexTable ftPatientInfo = new FlexTable();
		
		TextBox tbFName = new TextBox();
		TextBox tbLName = new TextBox();
		TextBox tbMName = new TextBox();
		TextBox tbSuffix = new TextBox();
		TextBox tbAddress = new TextBox();
		TextBox tbEmail = new TextBox();
		TextBox tbHPhone = new TextBox();
		TextBox tbCPhone = new TextBox();
		TextBox tbDOB = new TextBox();
		TextBox tbPolicyNo = new TextBox();
		TextBox tbPolicyIssuer = new TextBox();
		TextBox tbPolicyStatus = new TextBox();
		
		TextBox tbMedicine = new TextBox();
		TextBox tbDose = new TextBox();
		TextBox tbAllergies = new TextBox();
		
		TextBox tbFrequency = new TextBox();
		TextBox tbMedStartDate = new TextBox();
		TextBox tbMedEndDate = new TextBox();
		
		TextArea taNotes = new TextArea();
		
		
		
		Label lFName = new Label("First Name:");
		Label lLName = new Label("Last Name:");
		Label lMName = new Label("Middle Name:");
		Label lSuffix = new Label("Suffix:");
		Label lAddress = new Label("Address:");
		Label lEmail = new Label("Email:");
		Label lHPhone = new Label("Home Phone:");
		Label lCPhone = new Label("Mobile Phone:");
		Label lDOB = new Label("Date Of Birth:");
		Label lPolicyNo = new Label("Policy Number:");
		Label lPolicyIssuer = new Label("Policy Issuer:");
		Label lPolicyStatus = new Label("Policy Status:");
		Label lMedicine = new Label("Medicine:");
		Label lDose = new Label("Dosage:");
		Label lAllergies = new Label("Allergies:");
		Label lFrequency = new Label("Frequency:");
		Label lMedStartDate = new Label("Start Date:");
		Label lMedEndDate = new Label("End Date:");
		
		Label lNotes = new Label("Doctors Notes:");			
		
		ftPatientInfo.setWidget(0, 1, tbFName);
		ftPatientInfo.setWidget(0, 3, tbMName);
		ftPatientInfo.setWidget(0, 5, tbLName);
		ftPatientInfo.setWidget(0, 7, tbSuffix);
		ftPatientInfo.setWidget(1, 1, tbAddress);
		ftPatientInfo.setWidget(2, 1, tbEmail);
		
		ftPatientInfo.setWidget(3, 1, tbHPhone);
		ftPatientInfo.setWidget(3, 3, tbCPhone);
		ftPatientInfo.setWidget(4, 1, tbDOB);
		ftPatientInfo.setWidget(5, 1, tbPolicyNo);
		ftPatientInfo.setWidget(5, 3, tbPolicyIssuer);
		
		ftPatientInfo.setWidget(5, 5, tbPolicyStatus);
		ftPatientInfo.setWidget(6, 1, tbMedicine);
		ftPatientInfo.setWidget(6, 3, tbDose);
		ftPatientInfo.setWidget(6, 5, tbFrequency);
		ftPatientInfo.setWidget(7, 1, tbAllergies);
		
		ftPatientInfo.setWidget(8, 1, tbMedStartDate);
		ftPatientInfo.setWidget(8, 2, tbMedEndDate);
		
		pNewPatientMain.add(ftPatientInfo);
		pNewPatientMain.add(taNotes);

		
		
		ftPatientInfo.setWidget(0, 0, lFName);
		ftPatientInfo.setWidget(0, 2, lMName);
		ftPatientInfo.setWidget(0, 4, lLName);
		ftPatientInfo.setWidget(0, 6, lSuffix);
		ftPatientInfo.setWidget(1, 0, lAddress);
		ftPatientInfo.setWidget(2, 0, lEmail);
		
		ftPatientInfo.setWidget(3, 0, lHPhone);
		ftPatientInfo.setWidget(3, 2, lCPhone);
		ftPatientInfo.setWidget(4, 0, lDOB);
		ftPatientInfo.setWidget(5, 0, lPolicyNo);
		ftPatientInfo.setWidget(5, 2, lPolicyIssuer);
		
		ftPatientInfo.setWidget(5, 4, lPolicyStatus);
		ftPatientInfo.setWidget(6, 0, lMedicine);
		ftPatientInfo.setWidget(6, 2, lDose);
		ftPatientInfo.setWidget(6, 4, lFrequency);
		ftPatientInfo.setWidget(7, 0, lAllergies);
		
		ftPatientInfo.setWidget(8, 0, lMedStartDate);
		ftPatientInfo.setWidget(8, 1, lMedEndDate);
		
		pNewPatientMain.add(ftPatientInfo);
		pNewPatientMain.add(lNotes);
		pNewPatientMain.add(taNotes);
		
		pNewPatientMain.addStyleName("mainPanel");
			
	
	
		return pNewPatientMain;
	}

}
