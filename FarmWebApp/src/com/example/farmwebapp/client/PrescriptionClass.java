package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.*;

/**
 * Main class to contain 
 * 	PatientInfo 
 * 	DoctorInfo
 * 	Meds
 * 	PrescriptionInfo
 * 	PrescriptionNots
 * PrescriptionLabel
 * @author Acer
 *
 */
public class PrescriptionClass 
{
	//may need to wrap in a complex panel
	private VerticalPanel pMainPresc = new VerticalPanel();
	private HorizontalPanel pTopPresc = new HorizontalPanel();
	private HorizontalPanel pBottomPresc = new HorizontalPanel();
	
	
	
	PatientInfo patientInfo = new PatientInfo();
	DoctorInfo doctorInfo = new DoctorInfo();
	Meds meds = new Meds();
	PrescriptionInfo prescriptionInfo = new PrescriptionInfo();
	PrescriptionLabel prescriptionLabel = new PrescriptionLabel();
	
	public VerticalPanel getPanel()
	{
		pMainPresc.add(pTopPresc);
		pMainPresc.add(pBottomPresc);
		
		//pTopPresc.add(patientInfo);
		return pMainPresc;
		
	}
}
