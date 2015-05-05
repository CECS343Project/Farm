package com.example.farmwebapp.client.services;

import com.example.farmwebapp.client.dbobjects.MedicationData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MedicationServiceAsync 
{
	public void getMedications(AsyncCallback<MedicationData[]> callback);
}
