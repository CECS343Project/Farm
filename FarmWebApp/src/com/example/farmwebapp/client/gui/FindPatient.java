/**
 * FindPatient
 * Gui for searching the database for a patients record
 * contains the text fields for searching 
 * and rpc functionality to query the database
 * 
 * @author Russell Tan
 * @author Napoleon Fulinara Jr.
 */
package com.example.farmwebapp.client.gui;

import java.util.List;
import java.util.Arrays;

import com.example.farmwebapp.client.dbobjects.PatientData;
import com.example.farmwebapp.client.services.PatientServiceAsync;
import com.example.farmwebapp.client.services.PatientServiceInit;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.cellview.client.*;

public class FindPatient 
{
	private final int CELLWIDTH = 150;
	private final int CELLHEIGHT = 15;

	private FlexTable ft = new FlexTable();

	private TextBox tb_dob = new TextBox();
	private TextBox tb_email = new TextBox();
	private TextBox tb_phoneNo = new TextBox();
	private TextBox tb_nameLast = new TextBox();
	private TextBox tb_licenseNo = new TextBox();
	private TextBox tb_nameFirst = new TextBox();
	private TextBox tb_nameSuffix = new TextBox();
	private TextBox tb_addressStreet = new TextBox();
	private TextBox tb_addressCityStateZip = new TextBox();
	
	private ListBox lb_nameSuffix = new ListBox();
	
	private CellTable<PatientData> ct_Results = new CellTable<PatientData>();
	
	private VerticalPanel vp = new VerticalPanel();
	private HorizontalPanel hp = new HorizontalPanel();
	
	private PatientServiceAsync rpc;
	private PatientData PatientsDB[]; 
	
	/**
	 * Default constructor instantiates the rpc async service 
	 * for querying the database
	 */
	public FindPatient() {
		rpc = PatientServiceInit.initRpc();
		getPatientsDB();
	}
	
	/**
	 * Sends an asynchronous call to the database and 
	 * populates the celltable with the results when query succeeds
	 */
	public void getPatientsDB()
	{
		AsyncCallback<PatientData[]> callback = new AsyncCallback<PatientData[]>()
		{
			@Override
			public void onFailure(Throwable caught) {
				PopUps popUp = new PopUps();		
				popUp.showDialog(caught.toString());
			}

			@Override
			public void onSuccess(PatientData[] result) {
				PatientsDB = result;

				//Populates the celltable
				drawTable();
			}
		};
		rpc.getPatients(callback);
	}

	/**
	 * @return Vertical panel with necessary text-boxes to search for a patient
	 */
	public IsWidget getFindPatientPanel() {
		
		/**
		 * NAME FIELD
		 */
		ft.setText(0, 0, "NAME");
		ft.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(0, 1, tb_nameFirst);
		tb_nameFirst.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(0, 2, tb_nameLast);
		tb_nameLast.setPixelSize(CELLWIDTH, CELLHEIGHT);

		lb_nameSuffix.addItem("   ");
		lb_nameSuffix.addItem("Jr.");
		lb_nameSuffix.addItem("Sr.");
		
		ft.setWidget(0, 3, lb_nameSuffix);
		tb_nameSuffix.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * ADDRESS FIELD
		 */
		ft.setText(1, 0, "ADDRESS");
		ft.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 1, tb_addressStreet);
		tb_addressStreet.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(2, 1, tb_addressCityStateZip);
		tb_addressCityStateZip.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * DATE OF BIRTH FIELD
		 */
		ft.setText(3, 0, "DATE OF BIRTH");
		ft.getCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 1, tb_dob);
		tb_dob.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * EMAIL FIELD
		 */
		ft.setText(1, 2, "EMAIL");
		ft.getCellFormatter().setVerticalAlignment(1, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 3, tb_email);
		tb_email.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		/**
		 * PHONE NUMBER FIELD
		 */
		ft.setText(2, 2, "PHONE NUMBER");
		ft.getCellFormatter().setVerticalAlignment(2, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(2, 3, tb_phoneNo);
		tb_phoneNo.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * LICENSE NUMBER
		 */
		ft.setText(3, 2, "LICENSE NUMBER");
		ft.getCellFormatter().setVerticalAlignment(3, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 3, tb_licenseNo);
		tb_licenseNo.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.getElement().setAttribute("cellpadding", "10");

		//Add necessary panels 
		vp.add(ft);
		vp.add(hp);
		
		return vp;
	}
	
	/**
	 * Populates the celltable using the PatientData class 
	 * and the result of the query(PatientData[]) 
	 */
	public void drawTable()
	{
		/**
		 * CELL TABLE FIELD
		 */
		final List<PatientData> l_DummyData = Arrays.asList(PatientsDB);
		
		TextColumn<PatientData> tc_Name = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) 
			{
				return object.fName;
			}				
		};
		TextColumn<PatientData> tc_Address = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object)
			{
				return object.lName;
			}				
		};
		TextColumn<PatientData> tc_Email = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) 
			{
				return object.fName;
			}				
		};
		TextColumn<PatientData> tc_PhoneNumber = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) 
			{
				return object.fName;
			}				
		};
		TextColumn<PatientData> tc_DOB = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object)
			{
				return object.dob.toString();
			}				
		};
		TextColumn<PatientData> tc_LicenseNo = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) 
			{
				return object.pID;
			}				
		};	
		
		//Add the columns to the table
		ct_Results.addColumn(tc_Name, "Name");
		ct_Results.addColumn(tc_Address, "Address");
		ct_Results.addColumn(tc_Email, "Email");
		ct_Results.addColumn(tc_PhoneNumber, "PhoneNumber");
		ct_Results.addColumn(tc_DOB, "Date of Birth");
		ct_Results.addColumn(tc_LicenseNo, "License Number");		
		ct_Results.setRowCount(2,true);
		ct_Results.setRowData(l_DummyData);
		
		//Add table to the horizontal panel
		//Call the main panel generator again 
		//after populating to place table in main panel
		hp.add(ct_Results);
		getFindPatientPanel();
	}
}