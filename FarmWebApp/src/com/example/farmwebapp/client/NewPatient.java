package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.*;

public class NewPatient 
{
	public VerticalPanel getPanel()
	{
		VerticalPanel pNewPatientMain = new VerticalPanel();
		HorizontalPanel pDOB = new HorizontalPanel();
		HorizontalPanel pDosage = new HorizontalPanel();
		FlexTable ftPatientInfo = new FlexTable();
		
		Image iPatient = new Image("patient_picture.jpg");
		
		TextBox tbFName = new TextBox();
		TextBox tbLName = new TextBox();
		TextBox tbMName = new TextBox();
		TextBox tbSuffix = new TextBox();
		TextBox tbAddress = new TextBox();
		TextBox tbCity = new TextBox();
		TextBox tbState = new TextBox();
		TextBox tbZip = new TextBox();
		TextBox tbEmail = new TextBox();
		TextBox tbHPhone = new TextBox();
		TextBox tbCPhone = new TextBox();
		ListBox lbDOBDay = new ListBox();
		ListBox lbDOBMonth = new ListBox();
		ListBox lbDOBYear = new ListBox();
		TextBox tbPolicyNo = new TextBox();
		TextBox tbPolicyIssuer = new TextBox();
		TextBox tbPolicyStatus = new TextBox();
		TextBox tbMedicine = new TextBox();
		TextBox tbDose = new TextBox();
		TextBox tbAllergies = new TextBox();
		ListBox lbFrequency = new ListBox();
		TextBox tbMedStartDate = new TextBox();
		TextBox tbMedEndDate = new TextBox();
		TextArea taNotes = new TextArea();		
		
		Label lNewPatient = new Label("New Patient");
		Label lFName = new Label("First Name:");
		Label lLName = new Label("Last Name:");
		Label lMName = new Label("Middle Name:");
		Label lSuffix = new Label("Suffix:");
		Label lAddress = new Label("Address:");
		Label lCity = new Label("City:");
		Label lState = new Label("State:");
		Label lZip = new Label("Zip:");
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
		
		Button bPlus = new Button("+");
		Button bMinus = new Button("-");
		
		pDosage.add(bPlus);
		pDosage.add(bMinus);
		pDosage.add(tbDose);
		
		pDOB.add(lbDOBDay);
		pDOB.add(lbDOBMonth);
		pDOB.add(lbDOBYear);
		
		ftPatientInfo.setWidget(0, 0, lFName);
		ftPatientInfo.setWidget(0, 1, tbFName);
		ftPatientInfo.setWidget(0, 2, lMName);
		ftPatientInfo.setWidget(0, 3, tbMName);
		ftPatientInfo.setWidget(0, 4, lLName);
		ftPatientInfo.setWidget(0, 5, tbLName);
		ftPatientInfo.setWidget(0, 6, lSuffix);
		ftPatientInfo.setWidget(0, 7, tbSuffix);
		ftPatientInfo.setWidget(1, 0, lAddress);
		ftPatientInfo.setWidget(1, 1, tbAddress);
		ftPatientInfo.setWidget(1, 2, lCity);
		ftPatientInfo.setWidget(1, 3, tbCity);
		ftPatientInfo.setWidget(1, 4, lState);
		ftPatientInfo.setWidget(1, 5, tbState);
		ftPatientInfo.setWidget(1, 6, lZip);
		ftPatientInfo.setWidget(1, 7, tbZip);
		ftPatientInfo.setWidget(3, 0, lEmail);
		ftPatientInfo.setWidget(3, 1, tbEmail);
		ftPatientInfo.setWidget(4, 0, lHPhone);
		ftPatientInfo.setWidget(4, 1, tbHPhone);
		ftPatientInfo.setWidget(4, 2, lCPhone);
		ftPatientInfo.setWidget(4, 3, tbCPhone);
		ftPatientInfo.setWidget(5, 0, lDOB);
		ftPatientInfo.setWidget(5, 1, pDOB);
		ftPatientInfo.setWidget(6, 0, lPolicyNo);
		ftPatientInfo.setWidget(6, 1, tbPolicyNo);
		ftPatientInfo.setWidget(6, 2, lPolicyIssuer);
		ftPatientInfo.setWidget(6, 3, tbPolicyIssuer);
		ftPatientInfo.setWidget(6, 4, lPolicyStatus);
		ftPatientInfo.setWidget(6, 5, tbPolicyStatus);
		ftPatientInfo.setWidget(7, 0, lMedicine);
		ftPatientInfo.setWidget(7, 1, tbMedicine);
		ftPatientInfo.setWidget(7, 2, lDose);
		ftPatientInfo.setWidget(7, 3, pDosage);
		ftPatientInfo.setWidget(7, 4, lFrequency);
		ftPatientInfo.setWidget(7, 5, lbFrequency);
		ftPatientInfo.setWidget(8, 0, lAllergies);
		ftPatientInfo.setWidget(8, 1, tbAllergies);
		ftPatientInfo.setWidget(9, 0, lMedStartDate);
		ftPatientInfo.setWidget(9, 1, tbMedStartDate);
		ftPatientInfo.setWidget(9, 2, lMedEndDate);
		ftPatientInfo.setWidget(9, 3, tbMedEndDate);
		
		taNotes.setCharacterWidth(120);
	    taNotes.setVisibleLines(5);
		
	    pNewPatientMain.add(lNewPatient);
	    pNewPatientMain.add(iPatient);
		pNewPatientMain.add(ftPatientInfo);
		pNewPatientMain.add(lNotes);
		pNewPatientMain.add(taNotes);
		
		pNewPatientMain.addStyleName("mainPanel");
			
		return pNewPatientMain;
	}

}
