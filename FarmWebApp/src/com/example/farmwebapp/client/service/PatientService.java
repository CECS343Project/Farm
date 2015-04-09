package com.example.farmwebapp.client.service;

import com.example.farmwebapp.client.PatientDB;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("patients")
public interface PatientService extends RemoteService 
{
	PatientDB[] getPatients();

}
