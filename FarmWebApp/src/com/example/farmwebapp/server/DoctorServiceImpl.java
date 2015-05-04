package com.example.farmwebapp.server;

import com.example.farmwebapp.client.dbobjects.DoctorData;
import com.example.farmwebapp.client.services.doctor.DoctorService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DoctorServiceImpl  extends RemoteServiceServlet implements DoctorService
{

	public DoctorData[] getDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

}
