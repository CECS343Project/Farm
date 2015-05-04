/**
 * 
 * 
 * 
 * 
 * 
 * @author Russell Tan 
 */
package com.example.farmwebapp.client.gui;

import com.example.farmwebapp.client.FarmWebApp;
import com.example.farmwebapp.client.dbobjects.PatientData;
import com.example.farmwebapp.client.dbobjects.UserData;
import com.example.farmwebapp.client.services.patient.PatientServiceAsync;
import com.example.farmwebapp.client.services.patient.PatientServiceInit;
import com.example.farmwebapp.client.services.user.UserServiceAsync;
import com.example.farmwebapp.client.services.user.UserServiceInit;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class MainGUI extends FarmWebApp 
{	
	private TabLayoutPanel homePage = new TabLayoutPanel(2, Unit.EM);
	
	private PatientServiceAsync rpc;
	private PatientData PatientsDB[];
	private UserServiceAsync rpcUsers;
	protected FindPatient findPatientPanel;
	private int desiredIndex = 0;

	private String selectedPatient;
	private String userType = "doctor";
	
	//Default constructor
	public MainGUI() 
	{
		PopUps pop = new PopUps();
		
		pop.showDialog("Host Base: " + GWT.getHostPageBaseURL());
		pop.showDialog("Module Base: " + GWT.getModuleBaseURL());
		rpc = PatientServiceInit.initRpc();
		rpcUsers = UserServiceInit.initRpc();
		getPatientsDB();
		getUsersDB();
	}
	
	public MainGUI(int index) 
	{
		desiredIndex = index;
	}
	
	public MainGUI(int i, String tempID) 
	{
		desiredIndex = i;
		setSelectedPatient(tempID);
	}

	public void  setDesiredIndex(int indx)
	{
		desiredIndex = indx;
	}
	
	public int getDesiredIndex()
	{
		return desiredIndex;
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
			public void onFailure(Throwable caught) 
			{
				PopUps popUp = new PopUps();		
				//popUp.showDialog(caught.toString());
			}

			public void onSuccess(PatientData[] result) 
			{
				PopUps popUp = new PopUps();		
				//popUp.showDialog("Got the patients!");
				PatientsDB = result;
				//findPatientPanel = new FindPatient(PatientsDB);
				//findPatientPanel.getFindPatientPanel().asWidget().removeFromParent();
				//homePage.add(findPatientPanel.getFindPatientPanel(), "FIND PATIENT");
			}
		};
		rpc.getPatients(callback);
	}
	public PatientData[] getPatientsDB(int temp)
	{
		return this.PatientsDB;
	}
	/**
	 * Sends an asynchronous call to the database and 
	 * populates the celltable with the results when query succeeds
	 * @return 
	 */
	public void getUsersDB()
	{
		AsyncCallback<UserData[]> callback = new AsyncCallback<UserData[]>()
		{
			public void onFailure(Throwable caught) 
			{
				PopUps popUp = new PopUps();		
				//popUp.showDialog(caught.toString());
			}

			public void onSuccess(UserData[] result) 
			{
				PopUps popUp = new PopUps();		
				//popUp.showDialog("Got the users!");
			}
		};
		rpcUsers.getUsers(callback);
	}	
	
	/**
	 * @return
	 */
	public TabLayoutPanel getPanel()
	{
		SignUp signUpPage = new SignUp();
		SignIn signInPage = new SignIn();
		new Doctor();
		new Pharmacy();
		new AddPatient();
		findPatientPanel = new FindPatient();
		new PrescribeMeds();
		
		homePage.setPixelSize(700, 440);
		homePage.setAnimationDuration(1000);
		homePage.add(signInPage.getSignInPanel(), "SIGN IN");
		homePage.add(signUpPage.getSignUpPanel(), "SIGN UP");
		
		homePage.addSelectionHandler(new SelectionHandler<Integer>() {
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
	/**
	 * @return
	 */
	public TabLayoutPanel getPanelDoc()
	{
		userType = "doctor";
		new SignUp();
		new SignIn();
		Doctor doctorMain = new Doctor();
		AddPatient addPatientPanel = new AddPatient();
		findPatientPanel = new FindPatient("doctor");
		PrescribeMeds prescribeMedicaiton = new PrescribeMeds();
		Logout logoutPanel = new Logout();
		
		homePage.setPixelSize(700, 440);
		homePage.setAnimationDuration(1000);
		homePage.add(doctorMain.getDoctorPanel(), "MAIN MENU");
		homePage.add(addPatientPanel.getAddPatientPanel(), "ADD PATIENT");
		homePage.add(findPatientPanel.getFindPatientPanel(), "FIND PATIENT");
		homePage.add(prescribeMedicaiton.getPrescribeMedsPanel(), "PRESCRIBE");
		homePage.add(logoutPanel.getLogoutPanel(),"LOGOUT");
		
		homePage.addSelectionHandler(new SelectionHandler<Integer>() {
			public void onSelection(SelectionEvent<Integer> event) {
				if (homePage.getSelectedIndex() == 2 || homePage.getSelectedIndex() == 3) {
					homePage.setPixelSize(700, 600);
			    }
				else if(homePage.getSelectedIndex() == 4)
				{
					logout();
				}
				else {
					homePage.setPixelSize(700, 440);
				}
			 }
		});
		homePage.selectTab(desiredIndex);
		return homePage;
	}
	/**
	 * @return
	 */
	public TabLayoutPanel getPanelPharm()
	{
		userType = "pharmacist";
		new SignUp();
		new SignIn();
		Pharmacy pharmacyMain = new Pharmacy();
		AddPatient addPatientPanel = new AddPatient();
		PharmacyUpdate pharmacyUpdate = new PharmacyUpdate();
		PrintMeds printMedication = new PrintMeds();
		Logout logoutPanel = new Logout();
		findPatientPanel = new FindPatient("pharmacist");
		
		homePage.setPixelSize(700, 440);
		homePage.setAnimationDuration(1000);
		homePage.add(pharmacyMain.getPharmacyPanel(), "MAIN MENU");
		homePage.add(addPatientPanel.getAddPatientPanel(), "ADD PATIENT");
		homePage.add(findPatientPanel.getFindPatientPanel(), "FIND PATIENT");
		homePage.add(pharmacyUpdate.getPharmacyUpdatePanel(), "UPDATE");
		homePage.add(printMedication.getPrintMedsPanel(), "PRINT");
		homePage.add(logoutPanel.getLogoutPanel(), "LOGOUT");
		
		
		homePage.addSelectionHandler(new SelectionHandler<Integer>() {
			public void onSelection(SelectionEvent<Integer> event) {
				if (homePage.getSelectedIndex() == 2 || homePage.getSelectedIndex() == 4) {
						
					homePage.setPixelSize(700, 600);
			    }
				else if(homePage.getSelectedIndex() == 5)
				{
					logout();
				}
				else {
					homePage.setPixelSize(700, 440);
				}
			 }
		});
		homePage.selectTab(desiredIndex);
		return homePage;
	}

	protected void logout()
	{
		super.setUserType("null");
		super.refreshUI("null");
		
	}

	public PatientData[] getPatients() 
	{
		return PatientsDB;
	}
	public TabLayoutPanel getHomePage()
	{
		return homePage;
	}

	public void setUserType(String string) 
	{
		super.setUserType(string);
		
	}
	public void refreshUI(String user,int i)
	{
		super.refreshUI(user, i);
	}

	protected void insertIntoDB(PatientData patient2) 
	{
		AsyncCallback<PatientData[]> callback = new AsyncCallback<PatientData[]>()
				{
					public void onFailure(Throwable caught) 
					{
						PopUps popUp = new PopUps();		
						popUp.showDialog(caught.toString());
					}

					public void onSuccess(PatientData[] result) 
					{
						PopUps popUp = new PopUps();		
						popUp.showDialog("added the patient");

					}
				};
				rpc.insertPatient(patient2,callback);
	}

	//public String getUserType() 
	//{
		
	//	return super.getUserType();
	//}

	public void refreshUI(String string, int i, String tempID) 
	{
		super.refreshUI(string, i,tempID);
		
	}

	public String getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(String selectedPatient) {
		this.selectedPatient = selectedPatient;
	}
	
	public String getUserType()
	{
		return userType;
	}
}
