package com.example.farmwebapp.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.example.farmwebapp.client.gui.PatientDB;
import com.example.farmwebapp.client.service.PatientService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PatientServiceImpl extends RemoteServiceServlet implements PatientService
{
	private static String dbURL = "jdbc:mysql://173.254.28.65:3306/thejoeja_ePrescription_version_1";
	private static Connection connection=null;
	private static String userName="thejoeja_russell";
	private static String password="teleport77";
	private static Statement stmt = null;
	private static Scanner inScan = new Scanner(System.in);

	@Override
	public PatientDB[] getPatients() 
	{
		PatientDB[] patients = new PatientDB[1];
		checkForDriver();
		try {
			stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("select * from `patient`;");
			ResultSetMetaData rsmd = results.getMetaData();
			int numberCols = rsmd.getColumnCount();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void checkForDriver()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		System.out.println("MySQL JDBC Driver Registered!");
	}
	
	public void CreateConnection()
	{
		try {
			// connect 
			connection = DriverManager
					.getConnection(dbURL,userName, password); 

		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
		}
	}
	
}
