package com.example.farmwebapp.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("patientService")
public interface PatientService extends RemoteService 
{
	public PatientData[] getPatients();

}
