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
}