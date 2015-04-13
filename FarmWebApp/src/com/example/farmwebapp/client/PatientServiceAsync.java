package com.example.farmwebapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PatientServiceAsync 
{
	public void getPatients(AsyncCallback<PatientData[]> callback);

}
