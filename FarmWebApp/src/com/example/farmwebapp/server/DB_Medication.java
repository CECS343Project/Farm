package com.example.farmwebapp.server;

import java.sql.*;

import com.example.farmwebapp.client.dbobjects.MedicationData;

public class DB_Medication extends DB_Conn
{
	public MedicationData[] getMedications()
	{
		String query = "SELECT * FROM medications;";
		
		MedicationData[] medications = null;
		
		try
		{
			Connection conn = getConn();
			Statement select = conn.createStatement();
			ResultSet result = select.executeQuery(query);
			
			int rSize = getResultSetSize(result);
			medications = new MedicationData[rSize];
			
			int k = 0;
			while(result.next())
			{
				medications[k] = new MedicationData();
				
				medications[k].MedicationID = result.getInt(1);
				medications[k].medicationName = result.getString(2);	
				k++;
			}
			result.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return medications;
	}
}
