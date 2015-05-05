/**
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Russell
 *
 */

package com.example.farmwebapp.client.dbobjects;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserData implements IsSerializable 
{
	public int    userID;
	public String uName;
	public String password;
	public String fName;
	public String lName;
	public String uType;
	public int    phone;
	public String pharmacy;
	public String address;
	public String city;
	public String state;
	public int    zip;
	public String email;
	public String pharmAddress;
	public String pharmCity;
	public String pharmState;
	public int    pharmZip;
}
