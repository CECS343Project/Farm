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
				patientData[k].dob = result.getDate(8);
				patientData[k].complaint = result.getString(9);
				patientData[k].history = result.getString(10);
				patientData[k].medRecord = result.getString(11);
				patientData[k].progress = result.getString(12);
				patientData[k].sugicalHist = result.getString(13);
				patientData[k].testResult = result.getString(14);
				patientData[k].treatmentPlan = result.getString(15);
				
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
