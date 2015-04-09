package com.example.farmwebapp.client;

import java.sql.ResultSet;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

@RemoteServiceRelativePath("PatientService")
public interface PatientService extends RemoteService 
{
	public PatientData[] getPatients();

}
