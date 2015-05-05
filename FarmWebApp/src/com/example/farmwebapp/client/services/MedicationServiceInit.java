package com.example.farmwebapp.client.services;

import com.google.gwt.core.client.GWT;

public class MedicationServiceInit 
{
	public MedicationServiceInit(){}
	
	public static MedicationServiceAsync initRpc()
	{
		MedicationServiceAsync rpc = (MedicationServiceAsync) GWT.create(MedicationService.class);
		return rpc;
	}
}
