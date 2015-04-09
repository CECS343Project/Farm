package com.example.farmwebapp.server;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import com.example.farmwebapp.client.gui.PatientDB;
import com.example.farmwebapp.client.service.PatientService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PatientServiceImpl extends RemoteServiceServlet implements PatientService
{
	private static String dbURL = "jdbc:mysql://192.168.70.144:3306/lab61DB";
	private static Connection connection=null;
	private static String userName="thejoeja_russell";
	private static String password="teleport77";
	private static Statement stmt = null;
	private static Scanner inScan = new Scanner(System.in);

	@Override
	public PatientDB[] getPatients() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public void createConnection()
	{
	
	}
	
}
