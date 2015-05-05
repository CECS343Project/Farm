package com.example.farmwebapp.client.services;

import com.example.farmwebapp.client.dbobjects.medicationData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MedicationServiceAsync 
{
	public void getMedications(AsyncCallback<medicationData[]> callback);
	public void getMedications(String field,String value,AsyncCallback<medicationData[]> callback);
}
