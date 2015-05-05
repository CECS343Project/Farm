/**
 * 
 * 
 * 
 * 
 * @author Russell Tan
 */
package com.example.farmwebapp.server;

import com.example.farmwebapp.client.dbobjects.PatientData;
import com.example.farmwebapp.client.services.PatientService;
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
	@Override
	public PatientData[] getPatients(String field, String value) 
	{
		DB_Patient db = new DB_Patient();
		PatientData[] patients = db.getPatients(field, value);
		
		
		return patients;
	}
	@Override
	public void insertPatient(PatientData patient) 
	{
		DB_Patient db = new DB_Patient();
		db.insertPatient(patient);
		
	}
	@Override
	public void updatePatient(PatientData patient) 
	{
		DB_Patient db = new DB_Patient();
		db.updatePatient(patient);
		
	}
}
