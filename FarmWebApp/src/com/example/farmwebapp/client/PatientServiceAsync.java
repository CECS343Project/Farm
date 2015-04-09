package com.example.farmwebapp.client;

import java.sql.ResultSet;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PatientServiceAsync 
{
	public void getPatients(AsyncCallback<PatientData[]> callback);

}
