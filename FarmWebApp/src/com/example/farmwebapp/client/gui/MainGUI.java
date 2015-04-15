/**
 * 
 * 
 * 
 * 
 * 
 * @author Russell Tan 
 */
package com.example.farmwebapp.client.gui;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class MainGUI 
{	
	private TabLayoutPanel homePage = new TabLayoutPanel(2, Unit.EM);
	
	//Default constructor
	public MainGUI() {}

	/**
	 * @return
	 */
	public TabLayoutPanel getPanel()
	{
		SignUp signUpPage = new SignUp();
		SignIn signInPage = new SignIn();
		Doctor doctorMain = new Doctor();
		Pharmacy pharmacyMain = new Pharmacy();
		AddPatient addPatientPanel = new AddPatient();
		FindPatient findPatientPanel = new FindPatient();
		PrescribeMeds prescribeMedicaiton = new PrescribeMeds();
		
		homePage.setPixelSize(700, 440);
		homePage.setAnimationDuration(1000);
		homePage.add(signInPage.getSignInPanel(), "SIGN IN");
		homePage.add(signUpPage.getSignUpPanel(), "SIGN UP");
		homePage.add(doctorMain.getDoctorPanel(), "DOCTOR");
		homePage.add(pharmacyMain.getPharmacyPanel(), "PHARMACY");
		homePage.add(findPatientPanel.getFindPatientPanel(), "FIND PATIENT");
		homePage.add(addPatientPanel.getAddPatientPanel(), "ADD PATIENT");
		homePage.add(prescribeMedicaiton.getPrescribeMedsPanel(), "PRESCRIBE");
		
		homePage.addSelectionHandler(new SelectionHandler<Integer>() {
			@Override
			public void onSelection(SelectionEvent<Integer> event) {
				if (homePage.getSelectedIndex() == 4 || homePage.getSelectedIndex() == 6) {
					homePage.setPixelSize(700, 600);
			    }
				else {
					homePage.setPixelSize(700, 440);
				}
			 }
		});
		
		return homePage;
	}
}
