package com.example.farmwebapp.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.farmwebapp.client.dbobjects.UserData;

public class DB_User extends DB_Conn
{
	DB_User(){}
	
	public UserData[] getUsers()
	{
		String query = "SELECT * FROM users;";
		
		UserData[] users = null;
		
		try
		{
			Connection conn = getConn();
			Statement select = conn.createStatement();
			ResultSet result = select.executeQuery(query);
			
			int rSize = getResultSetSize(result);
			users = new UserData[rSize];
			
			int k = 0;
			while(result.next())
			{
				users[k] = new UserData();
				
				users[k].userID = result.getInt(1);
				users[k].uName = result.getString(2);
				users[k].password = result.getString(3);
				users[k].fName = result.getString(4);
				users[k].lName = result.getString(5);
				users[k].uType = result.getString(6);
				users[k].phone = result.getInt(7);
				users[k].pharmacy = result.getString(8);
				users[k].address = result.getString(9);
				users[k].city = result.getString(10);
				users[k].state = result.getString(11);
				users[k].zip = result.getInt(12);
				users[k].email = result.getString(13);
				users[k].pharmAddress = result.getString(14);
				users[k].pharmCity = result.getString(15);
				users[k].pharmState = result.getString(16);
				users[k].pharmZip = result.getInt(17);
				k++;
			}
			result.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return users;
	}
}
