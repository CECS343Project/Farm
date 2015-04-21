package com.example.farmwebapp.server;

package com.example.farmwebapp.server;

import java.sql.*;

import com.example.farmwebapp.client.dbobjects.PatientData;

public class DB_Doctor extends DB_Conn
{
	public DB_Doctor(){
		
	}//end constructor
	
	
	
	public PatientData[] getPatientsBy(String field, String value) {
		
	//	switch field
		
	//case value
		
		return null;
	}//end PatientData[] getPatientsBy(String field, String value) method
	
	public PatientData[] getPatients()
	{
		String query = "SELECT * FROM view_doctor_detail;";
		
		PatientData[] doctorData = null;
		
		try
		{
			Connection conn = getConn();
			Statement select = conn.createStatement();
			ResultSet result = select.executeQuery(query);
			
			int rSize = getResultSetSize(result);
			doctorData = new PatientData[rSize];
			
			int k = 0;
			while(result.next())
			{
				doctorData[k] = new PatientData();
				
				doctorData[k].pID = result.getString(1);
				doctorData[k].fName = result.getString(2);
				doctorData[k].lName = result.getString(3);
				doctorData[k].address = result.getString(4);
				doctorData[k].city = result.getString(5);
				doctorData[k].state = result.getString(6);
				doctorData[k].zip = result.getString(7);
				doctorData[k].dob = result.getDate(8);
				doctorData[k].license = result.getString(9);
				doctorData[k].history = result.getString(10);
				doctorData[k].medRecord = result.getString(11);
				doctorData[k].progress = result.getString(12);
				doctorData[k].sugicalHist = result.getString(13);
				doctorData[k].testResult = result.getString(14);
				doctorData[k].treatmentPlan = result.getString(15);
				
				k++;
			}//end while
			result.close();
			conn.close();
		}//end try
		catch(Exception e)
		{
			e.printStackTrace();
		}//end catch
		
		return patientData;
				
	}//end PatientData[] getPatients() method

}//end class

