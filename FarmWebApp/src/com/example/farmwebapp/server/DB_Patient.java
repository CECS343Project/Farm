/**
 * @author branflake2267
 * @author Russell Tan
 */


package com.example.farmwebapp.server;

import java.sql.*;
import com.example.farmwebapp.client.dbobjects.PatientData;

public class DB_Patient extends DB_Conn
{
	public DB_Patient(){}
	
	public PatientData[] getPatients()
	{
		String query = "SELECT * FROM patients;";
		
		PatientData[] patientData = null;
		
		try
		{
			Connection conn = getConn();
			Statement select = conn.createStatement();
			ResultSet result = select.executeQuery(query);
			
			int rSize = getResultSetSize(result);
			patientData = new PatientData[rSize];
			
			int k = 0;
			while(result.next())
			{
				patientData[k] = new PatientData();
				
				patientData[k].patientID = result.getInt(1);
				patientData[k].fName = result.getString(2);
				patientData[k].lName = result.getString(3);
				patientData[k].email = result.getString(4);
				patientData[k].phone = result.getInt(5);
				patientData[k].dateOfBirth = result.getString(6);
				patientData[k].address = result.getString(7);
				patientData[k].city = result.getString(8);
				patientData[k].state = result.getString(9);
				patientData[k].zip = result.getInt(10);
				patientData[k].status = result.getString(11);
				patientData[k].prescription = result.getString(12);
				patientData[k].userID = result.getInt(13);				
				k++;
			}
			result.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return patientData;
				
	}
	public PatientData[] getPatients(String field, String value)
	{
		String query = "SELECT * FROM patients ";
		
		switch(field.toLowerCase())
		{
		case "patientid":
			query += "WHERE patientID = '" + value+ "';";
			break;
		case "fname":
			query += "WHERE fName = '" + value+ "';";
			break;
		case "lname":
			query += "WHERE lName = '" + value+ "';";
			break;
		case "address":
			query += "WHERE address = '" + value+ "';";
			break;
		case "city":
			query += "WHERE city = '" + value+ "';";
			break;
		case "state":
			query += "WHERE state = '" + value+ "';";
			break;
		case "zip":
			query += "WHERE zipcode = '" + value+ "';";
			break;
		case "phone":
			query += "WHERE phone = '" + value+ "';";
			break;
		case "dob":
			query += "WHERE dateOfBirth = '" + value+ "';";
			break;
		default:
			query += ";";
			break;
		}
		PatientData[] patientData = null;
		try
		{
			Connection conn = getConn();
			Statement select = conn.createStatement();
			ResultSet result = select.executeQuery(query);
			
			int rSize = getResultSetSize(result);
			patientData = new PatientData[rSize];
			
			int k = 0;
			while(result.next())
			{
				patientData[k] = new PatientData();
				
				patientData[k].patientID = result.getInt(1);
				patientData[k].fName = result.getString(2);
				patientData[k].lName = result.getString(3);
				patientData[k].email = result.getString(4);
				patientData[k].phone = result.getInt(5);
				patientData[k].dateOfBirth = result.getString(6);
				patientData[k].address = result.getString(7);
				patientData[k].city = result.getString(8);
				patientData[k].state = result.getString(9);
				patientData[k].zip = result.getInt(10);
				patientData[k].status = result.getString(11);
				patientData[k].prescription = result.getString(12);
				patientData[k].userID = result.getInt(13);				
				k++;
			}
			result.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return patientData;		
	}

	public void insertPatient(PatientData patient) 
	{
		String query = null;
		query = "INSERT INTO `pillbug`.`patients`"+
				"(`fName`,lName,email,phone,dateOfBirth,address,city,state,zip,userID)"+
				"VALUES"+
				"('"+patient.fName+"',"
				+ "'"+patient.lName+"',"
				+ "'"+patient.email+"',"
				+ ""+patient.phone+","
				+ "'"+patient.dateOfBirth+"',"
				+ "'"+patient.address+"',"
				+ "'"+patient.city+"',"
				+ "'"+patient.state+"',"
				+ ""+patient.zip+","
				+ ""+patient.userID+""
				+ ");";				
		try
		{
			Connection conn = getConn();
			Statement select = conn.createStatement();
			select.executeUpdate(query);
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}

	public void updatePatient(PatientData patient) 
	{
		String query = null;
		query = "UPDATE `pillbug`.`patients` SET `prescription` = '"+patient.prescription+"', `status` = 'Unfilled' WHERE `patientID` = "+patient.userID+";";				
		try
		{
			Connection conn = getConn();
			Statement select = conn.createStatement();
			select.executeUpdate(query);
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
