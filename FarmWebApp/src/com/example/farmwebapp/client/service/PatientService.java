package com.example.farmwebapp.client.service;

import com.example.farmwebapp.client.gui.PatientDB;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PatientService")
public interface PatientService extends RemoteService 
{
	PatientDB[] getPatients();

}
