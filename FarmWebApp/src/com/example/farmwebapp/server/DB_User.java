package com.example.farmwebapp.server;

import com.example.farmwebapp.client.dbobjects.UserData;

public class DB_User 
{
	public UserData[] getUsers()
	{
		return null;
	}
	
	public void insertUser(UserData user)
	{
		"INSERT INTO `pillbug`.`users`"+
				"("+
				"`fName`,"+
				"`lName`,"+
				"`fName`,"+
				"`lName`,"+
				"`uType`,"+
				"`phone`,"+
				"`pharmacy`,"+
				"`address`,"+
				"`city`,"+
				"`state`,"+
				"`zip`,"+
				"`email`,"+
				"`pharmAddress`,"+
				"`pharmCity`,"+
				"`pharmState`,"+
				"`pharmZip`)"+
				"VALUES"+
				"("+
				"'"+patient.fName+"',"+
				"'S\'aulgoodman',"+
				"'Jimmy',"+
				"'McGill',"+
				"'Doctor',"+
				"'310445688',"+
				"'CVS',"+
				"'13958 Joyce Road Suite C',"+
				"'Glendale',"+
				"'California',"+
				"95642,"+
				"'itsallgoodman@gmail.com',"+
				"'15864 Wells',"+
				"'Glendale',"+
				"'California',"+
				"'95642');";
	}

}
