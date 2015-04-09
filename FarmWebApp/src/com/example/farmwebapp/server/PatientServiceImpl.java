package com.example.farmwebapp.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.example.farmwebapp.client.PatientData;
import com.example.farmwebapp.client.PatientService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public class PatientServiceImpl extends RemoteServiceServlet implements PatientService
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String dbURL = "jdbc:mysql://173.254.28.65:3306/thejoeja_ePrescription_version_1";
	private static Connection connection=null;
	private static String userName="thejoeja_russell";
	private static String password="teleport77";
	private static Statement stmt = null;
	private static Scanner inScan = new Scanner(System.in);

	public PatientServiceImpl(String string) {
		// TODO Auto-generated constructor stub
	}

	public PatientServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PatientData[] getPatients() 
	{
		checkForDriver();
		try {
			
			PatientData[] patients = new PatientData[1];
			stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("select * from `patient`;");
			ResultSetMetaData rsmd = results.getMetaData();
			int numberCols = rsmd.getColumnCount();
			
			return patients;
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
