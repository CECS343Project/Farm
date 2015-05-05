package com.example.farmwebapp.client.services;
import com.example.farmwebapp.client.dbobjects.medicationData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("medicationService")
public interface MedicationService extends RemoteService 
{
	public medicationData[] getMedications();
	public medicationData[] getMedications(String field, String value);
}
