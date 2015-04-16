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
		String query = "SELECT * FROM view_patient_detail;";
		
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
				
				patientData[k].pID = result.getString(1);
				patientData[k].fName = result.getString(2);
				patientData[k].lName = result.getString(3);
				patientData[k].address = result.getString(4);
				patientData[k].city = result.getString(5);
				patientData[k].state = result.getString(6);
				patientData[k].zip = result.getString(7);
				patientData[k].dob = result.getDate(10);
				patientData[k].complaint = result.getString(11);
				patientData[k].history = result.getString(12);
				patientData[k].medRecord = result.getString(13);
				patientData[k].progress = result.getString(14);
				patientData[k].sugicalHist = result.getString(15);
				patientData[k].testResult = result.getString(16);
				patientData[k].treatmentPlan = result.getString(17);
				
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
		String query = "SELECT * FROM view_patient_detail ";
		
		switch(field.toLowerCase())
		{
		case "id":
			query += "WHERE user_id = '" + value+ "';";
			break;
		case "fname":
			query += "WHERE first_name = '" + value+ "';";
			break;
		case "lname":
			query += "WHERE last_name = '" + value+ "';";
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
		case "cellphone":
			query += "WHERE cellphone = '" + value+ "';";
			break;
		case "homephone":
			query += "WHERE homephone = '" + value+ "';";
			break;
		case "dob":
			query += "WHERE birthdate = '" + value+ "';";
			break;
		case "complaint":
			query += "WHERE chief_complain = '" + value+ "';";
			break;
		case "history":
			query += "WHERE history = '" + value+ "';";
			break;
		case "medrecord":
			query += "WHERE medication_record = '" + value+ "';";
			break;
		case "progress":
			query += "WHERE progress_note = '" + value+ "';";
			break;
		case "sugicalhist":
			query += "WHERE sugical_history = '" + value+ "';";
			break;
		case "testresult":
			query += "WHERE test_result = '" + value+ "';";
			break;
		case "treatmentplan":
			query += "WHERE treatment_plan = '" + value+ "';";
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
				
				patientData[k].pID = result.getString(1);
				patientData[k].fName = result.getString(2);
				patientData[k].lName = result.getString(3);
				patientData[k].address = result.getString(4);
				patientData[k].city = result.getString(5);
				patientData[k].state = result.getString(6);
				patientData[k].zip = result.getString(7);
				patientData[k].dob = result.getDate(10);
				patientData[k].complaint = result.getString(11);
				patientData[k].history = result.getString(12);
				patientData[k].medRecord = result.getString(13);
				patientData[k].progress = result.getString(14);
				patientData[k].sugicalHist = result.getString(15);
				patientData[k].testResult = result.getString(16);
				patientData[k].treatmentPlan = result.getString(17);
				
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

}
