package com.example.farmwebapp.client.service;

import com.example.farmwebapp.client.gui.PatientDB;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PatientServiceAsync 
{
	void getPatients(AsyncCallback callback);

}
