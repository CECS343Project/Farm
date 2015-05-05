/**
 * PatientData
 * Object class used for database access, this class defines the variables
 * Stored in the database for a particular table 
 * 
 * @author Russell Tan
 */

package com.example.farmwebapp.client.dbobjects;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PatientData implements IsSerializable
{
	public int    patientID;
	public String fName;
	public String lName;
	public String email;
	public int    phone;
	public String dateOfBirth;
	public String address;
	public String city;
	public String state;
	public int    zip;
	public String status;
	public String prescription;
	public int    userID;
}
