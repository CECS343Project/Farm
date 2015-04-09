package com.example.farmwebapp.client.gui;

import com.example.farmwebapp.client.service.PatientServiceImpl;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class MainGUI {
	
	private TabLayoutPanel homePage = new TabLayoutPanel(2, Unit.EM);
	private PatientServiceImpl patientServiceImpl;
	
	public MainGUI(PatientServiceImpl patientServiceImpl) {
		this.patientServiceImpl = patientServiceImpl;
	}

	public TabLayoutPanel getPanel()
	{
		SignUp signUpPage = new SignUp(patientServiceImpl);
		SignIn signInPage = new SignIn(patientServiceImpl);
		Doctor doctorMain = new Doctor(patientServiceImpl);
		Pharmacy pharmacyMain = new Pharmacy(patientServiceImpl);
		FindPatient findPatientPanel = new FindPatient(patientServiceImpl);
		AddPatient addPatientPanel = new AddPatient(patientServiceImpl);
		
		homePage.setPixelSize(700, 440);
		homePage.setAnimationDuration(1000);
		homePage.add(signInPage.getSignInPanel(), "SIGN IN");
		homePage.add(signUpPage.getSignUpPanel(), "SIGN UP");
		homePage.add(doctorMain.getDoctorPanel(), "DOCTOR");
		homePage.add(pharmacyMain.getPharmacyPanel(), "PHARMACY");
		homePage.add(findPatientPanel.getFindPatientPanel(), "FIND PATIENT");
		homePage.add(addPatientPanel.getAddPatientPanel(), "ADD PATIENT");
		
		return homePage;
	}
}
