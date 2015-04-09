package com.example.farmwebapp.server;

import com.example.farmwebapp.client.PatientDB;
import com.example.farmwebapp.client.service.PatientService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PatientServiceImpl extends RemoteServiceServlet implements PatientService
{
	public PatientDB[] getPatients()
	{
		return null;
	}
}
