/**
 * 
 * 
 * 
 * 
 * 
 * @author Russell Tan
 */
package com.example.farmwebapp.client.services;

import com.example.farmwebapp.client.dbobjects.PatientData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PatientServiceAsync 
{
	public void getPatients(AsyncCallback<PatientData[]> callback);
	public void getPatientsUnfilled(AsyncCallback<PatientData[]> callback);
	public void getPatients(String field, String value,AsyncCallback<PatientData[]> callback);
	public void insertPatient(PatientData patient,AsyncCallback callback);
	public void updatePatient(PatientData patient, AsyncCallback callback);
}
