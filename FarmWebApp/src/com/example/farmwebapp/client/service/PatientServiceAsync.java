package com.example.farmwebapp.client.service;

import com.example.farmwebapp.client.PatientDB;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PatientServiceAsync 
{
	void getPatients(AsyncCallback callback);

}
