/**
 * 
 * 
 * 
 * 
 * @author Russell Tan
 */
package com.example.farmwebapp.client.services.patient;

import com.google.gwt.core.client.GWT;

public class PatientServiceInit 
{
	public PatientServiceInit(){}
	
	public static PatientServiceAsync initRpc()
	{
		PatientServiceAsync rpc = (PatientServiceAsync) GWT.create(PatientService.class);
		return rpc;
	}
}
