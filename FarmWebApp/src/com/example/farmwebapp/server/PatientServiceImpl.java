package com.example.farmwebapp.server;

import com.example.farmwebapp.client.PatientData;
import com.example.farmwebapp.client.PatientService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class PatientServiceImpl extends RemoteServiceServlet implements PatientService
{
	@Override
	public PatientData[] getPatients() 
	{
		DB_Patient db = new DB_Patient();
		PatientData[] patients = db.getPatients();
		
		return patients;
	}
}
