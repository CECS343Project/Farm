package com.example.farmwebapp.server;

import com.example.farmwebapp.client.dbobjects.PharmData;
import com.example.farmwebapp.client.services.pharm.PharmService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class PharmServiceImpl  extends RemoteServiceServlet implements PharmService
{

	@Override
	public PharmData[] getPharms() {
		// TODO Auto-generated method stub
		return null;
	}



}
