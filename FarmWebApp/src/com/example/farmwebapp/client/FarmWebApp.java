package com.example.farmwebapp.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class FarmWebApp implements EntryPoint {
	
	private SignUp signUpPage = new SignUp();
	private SignIn signInPage = new SignIn();
	private Doctor doctorMain = new Doctor();
	private Pharmacy pharmacyMain = new Pharmacy();
	private FindPatient findPatientPanel = new FindPatient();
	private AddPatient addPatientPanel = new AddPatient();
	private TabLayoutPanel homePage = new TabLayoutPanel(2, Unit.EM);
	
	public void onModuleLoad() {
	
		homePage.setPixelSize(700, 440);
		homePage.setAnimationDuration(1000);
		homePage.add(signInPage.getSignInPanel(), "SIGN IN");
		homePage.add(signUpPage.getSignUpPanel(), "SIGN UP");
		homePage.add(doctorMain.getDoctorPanel(), "DOCTOR");
		homePage.add(pharmacyMain.getPharmacyPanel(), "PHARMACY");
		homePage.add(findPatientPanel.getFindPatientPanel(), "FIND PATIENT");
		homePage.add(addPatientPanel.getAddPatientPanel(), "ADD PATIENT");
		RootLayoutPanel rootPanel = RootLayoutPanel.get();
	    rootPanel.add(homePage);
	}
}