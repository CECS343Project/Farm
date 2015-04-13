package com.example.farmwebapp.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PatientData implements IsSerializable
{
	public String pID;
	public String fName;
	public String lName;
	public String address;
	public String city;
	public String state;
	public String zip;
	public Date dob;
	public String complaint;
	public String history;
	public String medRecord;
	public String progress;
	public String sugicalHist;
	public String testResult;
	public String treatmentPlan;
}
