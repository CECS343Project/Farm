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
import com.example.farmwebapp.client.services.patient.PatientServiceAsync;
import com.example.farmwebapp.client.services.patient.PatientServiceInit;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.datepicker.client.DateBox;

public class FindPatient extends MainGUI
{
	private final int CELLWIDTH = 150;
	private final int CELLHEIGHT = 15;

	private FlexTable ft = new FlexTable();
	
	private TextBox tb_email = new TextBox();
	private TextBox tb_phoneNo = new TextBox();
	private TextBox tb_nameLast = new TextBox();
	private TextBox tb_licenseNo = new TextBox();
	private TextBox tb_nameFirst = new TextBox();
	private TextBox tb_nameSuffix = new TextBox();
	private TextBox tb_addressStreet = new TextBox();
	private TextBox tb_addressCityStateZip = new TextBox();
	
	private final DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
	private DateBox db_dob = new DateBox();
	
	private ListBox lb_nameSuffix = new ListBox();
	
	private CellTable<PatientData> ct_Results = new CellTable<PatientData>();
	
	private VerticalPanel vp = new VerticalPanel();
	private HorizontalPanel hp = new HorizontalPanel();
	
	private PatientServiceAsync rpc;
	private PatientData[] patients; 
	
	/**
	 * Default constructor instantiates the rpc async service 
	 * for querying the database
	 */
	public FindPatient() 
	{
		lb_nameSuffix.addItem("   ");
		lb_nameSuffix.addItem("Jr.");
		lb_nameSuffix.addItem("Sr.");
		patients = super.getPatients();
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
		
		tb_nameFirst.addValueChangeHandler(new ValueChangeHandler<String>()
			{

			@Override
			public void onValueChange(ValueChangeEvent<String> event) 
			{
				//getPatientsDB("fName",tb_nameFirst.getText());
				PatientData[] temp = new PatientData[patients.length];
				int count = 0;
				//drawTable(temp);
				PopUps pop = new PopUps();
				
				int k;
				for(k = 0; k < patients.length; k++)
				{
					pop.showDialog(patients[k].fName);
					if(patients[k].fName == tb_nameFirst.getText())
					{
						pop.showDialog("AAAAAAAAAAHHHHHHHHHHHH");
						temp[k] = patients[k];
						
						
					}
					else
					{
						temp[k] = null;
					}
				}
				drawTable(temp);
			}		
		});

		ft.setWidget(0, 2, tb_nameLast);
		tb_nameLast.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_nameLast.addValueChangeHandler(new ValueChangeHandler<String>()
				{

				@Override
				public void onValueChange(ValueChangeEvent<String> event) 
				{
					//getPatientsDB("lname",tb_nameLast.getText());
					//PatientData[] temp = patients;
					//drawTable(temp);
					drawTable(patients);
				}		
			});
		
		ft.setWidget(0, 3, lb_nameSuffix);
		tb_nameSuffix.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_nameSuffix.addValueChangeHandler(new ValueChangeHandler<String>()
				{

				@Override
				public void onValueChange(ValueChangeEvent<String> event) 
				{
					//getPatientsDB("fName",tb_nameSuffix.getText());
					//PatientData[] temp = patients;
					//drawTable(temp);
					drawTable(patients);
				}		
			});

		/**
		 * ADDRESS FIELD
		 */
		ft.setText(1, 0, "ADDRESS");
		ft.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 1, tb_addressStreet);
		tb_addressStreet.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_addressStreet.addValueChangeHandler(new ValueChangeHandler<String>()
				{

				@Override
				public void onValueChange(ValueChangeEvent<String> event) 
				{
					//getPatientsDB("address",tb_addressStreet.getText());
					//PatientData[] temp = patients;
					//drawTable(temp);
					drawTable(patients);
					
				}		
			});

		ft.setWidget(2, 1, tb_addressCityStateZip);
		tb_addressCityStateZip.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_addressCityStateZip.addValueChangeHandler(new ValueChangeHandler<String>()
				{

				@Override
				public void onValueChange(ValueChangeEvent<String> event) 
				{
					//getPatientsDB("address",tb_addressCityStateZip.getText());
					//PatientData[] temp = patients;
					//drawTable(temp);
					drawTable(patients);
					
				}		
			});

		/**
		 * DATE OF BIRTH FIELD
		 */
		db_dob.setFormat(new DateBox.DefaultFormat(dateFormat));
		ft.setText(3, 0, "DATE OF BIRTH");
		ft.getCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 1, db_dob);
		db_dob.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * EMAIL FIELD
		 */
		ft.setText(1, 2, "EMAIL");
		ft.getCellFormatter().setVerticalAlignment(1, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 3, tb_email);
		tb_email.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_email.addValueChangeHandler(new ValueChangeHandler<String>()
				{

				@Override
				public void onValueChange(ValueChangeEvent<String> event) 
				{
					//getPatientsDB("fname",tb_email.getText());
					//PatientData[] temp = patients;
					//drawTable(temp);
					drawTable(patients);
					
				}		
			});
		
		/**
		 * PHONE NUMBER FIELD
		 */
		ft.setText(2, 2, "PHONE NUMBER");
		ft.getCellFormatter().setVerticalAlignment(2, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(2, 3, tb_phoneNo);
		tb_phoneNo.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_phoneNo.addValueChangeHandler(new ValueChangeHandler<String>()
				{

				@Override
				public void onValueChange(ValueChangeEvent<String> event) 
				{
					//getPatientsDB("cellphone",tb_phoneNo.getText());
					//PatientData[] temp = patients;
					//drawTable(temp);
					drawTable(patients);
					
				}		
			});
		tb_phoneNo.addKeyPressHandler(new KeyPressHandler() 
	    {
	      public void onKeyPress(KeyPressEvent event) 
	      {
	        if (!Character.isDigit(event.getCharCode())) 
	        {
	          ((TextBox) event.getSource()).cancelKey();
	        }
	      }
	    });

		/**
		 * LICENSE NUMBER
		 */
		ft.setText(3, 2, "POLICY NUMBER");
		ft.getCellFormatter().setVerticalAlignment(3, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 3, tb_licenseNo);
		tb_licenseNo.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_licenseNo.addValueChangeHandler(new ValueChangeHandler<String>()
				{

				@Override
				public void onValueChange(ValueChangeEvent<String> event) 
				{
					//getPatientsDB("fName",tb_licenseNo.getText());
					PatientData[] temp = patients;
					drawTable(temp);
				}		
			});
		
		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.getElement().setAttribute("cellpadding", "10");
		//Add necessary panels 
		vp.add(ft);
		vp.add(hp);
		vp.setCellVerticalAlignment(hp, HasVerticalAlignment.ALIGN_MIDDLE);
		vp.setCellHorizontalAlignment(hp, HasHorizontalAlignment.ALIGN_CENTER);
		return vp;
	}
	
	

	/**
	 * Populates the celltable using the PatientData class 
	 * and the result of the query(PatientData[]) 
	 */
	public void drawTable(PatientData[] temp)
	{
		/**
		 * CELL TABLE FIELD
		 */
		final List<PatientData> l_DummyData = Arrays.asList(temp);
		
		TextColumn<PatientData> tc_Name = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) 
			{
				return ""+object.lName+", "+object.fName;
			}				
		};
		TextColumn<PatientData> tc_Address = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object)
			{
				return object.address;
			}				
		};
		TextColumn<PatientData> tc_Email = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) 
			{
				return object.testResult;
			}				
		};
		TextColumn<PatientData> tc_PhoneNumber = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) 
			{
				if(object.cellPhone == null)
				{
					return object.cellPhone;
				}
				else if(object.homePhone == null)
				{
					return object.homePhone;
				}
				else
				{
					return "No number provided";
				}
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
		ct_Results.addColumn(tc_Name, "");
		ct_Results.addColumn(tc_Address, "");
		ct_Results.addColumn(tc_Email, "");
		ct_Results.addColumn(tc_PhoneNumber, "");
		ct_Results.addColumn(tc_DOB, "");
		ct_Results.addColumn(tc_LicenseNo, "");		
		ct_Results.setRowCount(2,true);
		ct_Results.setRowData(l_DummyData);
		
		//Add table to the horizontal panel
		//Call the main panel generator again 
		//after populating to place table in main panel
		ct_Results.setPageSize(14);
		ct_Results.setWidth("640px");
		hp.add(ct_Results);
		getFindPatientPanel();
	}
}