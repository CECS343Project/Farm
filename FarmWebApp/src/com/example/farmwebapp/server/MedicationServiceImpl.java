package com.example.farmwebapp.server;

import com.example.farmwebapp.client.dbobjects.MedicationData;
import com.example.farmwebapp.client.services.MedicationService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class MedicationServiceImpl extends RemoteServiceServlet implements MedicationService
{
	public MedicationData[] getMedications() 
	{
		DB_Medication db = new DB_Medication();
		MedicationData[] medications = db.getMedications();
		
		return medications;
	}
}
