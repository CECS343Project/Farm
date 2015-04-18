/**
 * 
 * 
 * 
 * 
 * 
 * @author Russell Tan 
 */
package com.example.farmwebapp.client.gui;

import com.example.farmwebapp.client.dbobjects.PatientData;
import com.example.farmwebapp.client.services.patient.PatientServiceAsync;
import com.example.farmwebapp.client.services.patient.PatientServiceInit;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class MainGUI 
{	
	private TabLayoutPanel homePage = new TabLayoutPanel(2, Unit.EM);
	
	private PatientServiceAsync rpc;
	private PatientData PatientsDB[];

	protected FindPatient findPatientPanel; 
	
	//Default constructor
	public MainGUI() 
	{
		rpc = PatientServiceInit.initRpc();
		getPatientsDB();
	}
	
	/**
	 * Sends an asynchronous call to the database and 
	 * populates the celltable with the results when query succeeds
	 * @return 
	 */
	public void getPatientsDB()
	{
		AsyncCallback<PatientData[]> callback = new AsyncCallback<PatientData[]>()
		{
			@Override
			public void onFailure(Throwable caught) 
			{
				PopUps popUp = new PopUps();		
				popUp.showDialog(caught.toString());
			}

			@Override
			public void onSuccess(PatientData[] result) 
			{
				PopUps popUp = new PopUps();		
				popUp.showDialog("Got the patients!");
				PatientsDB = result;
				findPatientPanel = new FindPatient(PatientsDB);
				//findPatientPanel.getFindPatientPanel().asWidget().removeFromParent();
				homePage.add(findPatientPanel.getFindPatientPanel(), "FIND PATIENT");
			}
		};
		rpc.getPatients(callback);
	}
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
		findPatientPanel = new FindPatient(PatientsDB);
		PrescribeMeds prescribeMedicaiton = new PrescribeMeds();
		
		homePage.setPixelSize(700, 440);
		homePage.setAnimationDuration(1000);
		homePage.add(signInPage.getSignInPanel(), "SIGN IN");
		homePage.add(signUpPage.getSignUpPanel(), "SIGN UP");
		homePage.add(doctorMain.getDoctorPanel(), "DOCTOR");
		homePage.add(pharmacyMain.getPharmacyPanel(), "PHARMACY");
		//homePage.add(findPatientPanel.getFindPatientPanel(), "FIND PATIENT");
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

	public PatientData[] getPatients() 
	{
		return PatientsDB;
	}
}
