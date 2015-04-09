package com.example.farmwebapp.client;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class RetrievedData
/**
 * creates list of patients tied to the data
 */
{
/*
	  private static final ArrayList<Patient> patient = (ArrayList<Patient>) Arrays.asList(
		      new Patient("Joe", "Jack", "Camp Pedelton", new Date(4,3,1985)),
		      new Patient(null, null, null, null),
		      new Patient(null, null, null, null));
*/	  
	  


}

//for fake data
class Patient 
{
    private final String firstName, lastName , hospital;
    private final Date date;
    

    public Patient(String firstName, String lastName , String hospital, Date date) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.hospital = hospital;
       this.date = date;
       
    }
 }
