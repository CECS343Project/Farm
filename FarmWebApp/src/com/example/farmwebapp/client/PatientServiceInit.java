package com.example.farmwebapp.client;

import com.google.gwt.core.shared.GWT;

public class PatientServiceInit {
	public PatientServiceInit(){}
	
	public static PatientServiceAsync initRpc()
	{
		PatientServiceAsync rpc = (PatientServiceAsync) GWT.create(PatientServiceAsync.class);
		return rpc;
	}
}
