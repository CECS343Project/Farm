package com.example.farmwebapp.client.gui;

import com.example.farmwebapp.client.service.PatientServiceImpl;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class MainGUI {
	private SignUp signUpPage = new SignUp();
	private SignIn signInPage = new SignIn();
	private Doctor doctorMain = new Doctor();
	private Pharmacy pharmacyMain = new Pharmacy();
	private FindPatient findPatientPanel = new FindPatient();
	private AddPatient addPatientPanel = new AddPatient();
	private TabLayoutPanel homePage = new TabLayoutPanel(2, Unit.EM);
	private PatientServiceImpl patientServiceImpl;
	public MainGUI(PatientServiceImpl patientServiceImpl) {
		this.patientServiceImpl = patientServiceImpl;
	}

	public TabLayoutPanel getPanel()
	{
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
