package com.example.farmwebapp.client.service;

import com.example.farmwebapp.client.FarmWebApp;
import com.example.farmwebapp.client.gui.MainGUI;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class PatientServiceImpl implements PatientServiceInt
{
	private PatientServiceAsync service;
	private MainGUI gui;
	
	public PatientServiceImpl(String url)
	{
		this.service = GWT.create(PatientService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);
		gui = new MainGUI(this);
	}

	@Override
	public void getPatients() 
	{
		this.service.getPatients(new DefaultCallBack());
	}
	
	private class DefaultCallBack implements AsyncCallback
	{

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured.");
			
			
		}

		@Override
		public void onSuccess(Object result) {
			System.out.println("Response recieved");
			
		}
		
	}

}
