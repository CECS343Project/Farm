/**
 * 
 * 
 * 
 * @author Russell Tan
 */
package com.example.farmwebapp.client.services;

import com.example.farmwebapp.client.dbobjects.PatientData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("patientService")
public interface PatientService extends RemoteService 
{
	public PatientData[] getPatients();
}
