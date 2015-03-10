package com.example.farmwebapp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;


//look up username / key down to search database to make sure 

public class FarmWebApp implements EntryPoint

{
	public void onModuleLoad()
	{
		Login login = new Login();
		Home homePage = new Home();
		NewPatient newPatient = new NewPatient();
		Search searchPatient =new Search();
		DoctorInfo doctorInfo = new DoctorInfo();
		Meds meds = new Meds();
		PatientInfo patientInfo = new PatientInfo();
		PrescriptionClass prescriptionC = new PrescriptionClass();
		PrescriptionInfo prescriptionI = new PrescriptionInfo();
		PrescriptionLabel prescriptionL = new PrescriptionLabel();
		PrescriptionNotes prescriptionN = new PrescriptionNotes();
		//RetrievedData retrievedData = new RetrievedData();

		RootPanel.get("main").add(login.getPanel());
		RootPanel.get("homePage").add(homePage.getPanel());
		RootPanel.get("newPatient").add(newPatient.getPanel());
		RootPanel.get("searchPatient").add(searchPatient.getPanel());
		RootPanel.get("doctorInfo").add(doctorInfo.addPanel());
		RootPanel.get("meds").add(meds.getPanel());
		RootPanel.get("patientInfo").add(patientInfo.addPanel());
		RootPanel.get("prescriptionClass").add(prescriptionC.getPanel());
		RootPanel.get("prescriptionInfo").add(prescriptionI.getPanel());
		RootPanel.get("prescriptionLabel").add(prescriptionL.getPanel());
		RootPanel.get("prescriptionNotes").add(prescriptionN.getPanel());
		//RootPanel.get("retrievedData").add(retrievedData.addPanel());

		
		

	}
	
}
