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

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

import com.example.farmwebapp.client.dbobjects.PatientData;
import com.example.farmwebapp.client.services.PatientServiceAsync;
import com.example.farmwebapp.client.services.PatientServiceInit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.view.client.ListDataProvider;

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
	private Button b_Search = new Button("SEARCH");
	private Button b_Select = new Button("Select Patient");
	private Button b_Delete = new Button("Delete Patient");
	
	private ListBox lb_nameSuffix = new ListBox();
	
	private CellTable<PatientData> ct_Results = new CellTable<PatientData>();
	private ScrollPanel sp_ctContainer = new ScrollPanel();
	private SimplePager pager = new SimplePager();
	
	private VerticalPanel vp = new VerticalPanel();
	private VerticalPanel vpTable = new VerticalPanel();
	private HorizontalPanel hpCRUD = new HorizontalPanel();
	
	private PatientData[] patients; 
	private String userType = super.getUserType();
	private PatientServiceAsync rpc;
	
	
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
	public FindPatient(String string) 
	{
		userType = string;
	}
	
	/**
	 * Sends an asynchronous call to the database and 
	 * populates the celltable with the results when query succeeds
	 * @return 
	 */
	public void getPatientsDB()
	{
		rpc = PatientServiceInit.initRpc();
		AsyncCallback<PatientData[]> callback = new AsyncCallback<PatientData[]>()
		{
			@Override
			public void onFailure(Throwable caught) 
			{
				PopUps popUp = new PopUps();		
				//popUp.showDialog(caught.toString());
			}

			@Override
			public void onSuccess(PatientData[] result) 
			{
				PopUps popUp = new PopUps();		
				//popUp.showDialog("Got the patients!");
				patients = result;
				drawTable(patients);
				//findPatientPanel = new FindPatient(PatientsDB);
				//findPatientPanel.getFindPatientPanel().asWidget().removeFromParent();
				//homePage.add(findPatientPanel.getFindPatientPanel(), "FIND PATIENT");
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
		
		tb_nameFirst.addValueChangeHandler(new ValueChangeHandler<String>()
			{

			@Override
			public void onValueChange(ValueChangeEvent<String> event) 
			{
				getPatientsSuper();
				drawTable(patients);
			}		
		});

		ft.setWidget(0, 2, tb_nameLast);
		tb_nameLast.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_nameLast.addValueChangeHandler(new ValueChangeHandler<String>()
				{

				@Override
				public void onValueChange(ValueChangeEvent<String> event) 
				{
					getPatientsSuper();
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
					getPatientsSuper();
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
					getPatientsSuper();
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
					getPatientsSuper();
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
					getPatientsSuper();
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
					getPatientsSuper();
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
					getPatientsSuper();
					drawTable(patients);
				}		
			});
		
		b_Search.addClickHandler(new ClickHandler()
		{

			@Override
			public void onClick(ClickEvent event) 
			{
				getPatientsDB();
			}
		});
		
		ft.setWidget(4, 2, b_Search);
		
		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.getElement().setAttribute("cellpadding", "10");
		//Add necessary panels 
		vp.add(ft);
		vp.add(vpTable);
		vp.setCellVerticalAlignment(vpTable, HasVerticalAlignment.ALIGN_MIDDLE);
		vp.setCellHorizontalAlignment(vpTable, HasHorizontalAlignment.ALIGN_CENTER);
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
		ListDataProvider<PatientData> ldp_CellData = new ListDataProvider<PatientData>();
		
		TextColumn<PatientData> tc_Name = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) 
			{
				return ""+object.lName+", "+object.fName;
			}				
		};
		tc_Name.setSortable(true);
		TextColumn<PatientData> tc_Address = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object)
			{
				return object.address+", " + object.city + " " +object.state
						+" "+ object.zip;
			}				
		};
		tc_Address.setSortable(true);
		TextColumn<PatientData> tc_Email = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) 
			{
				return object.email;
			}				
		};
		tc_Email.setSortable(true);
		TextColumn<PatientData> tc_PhoneNumber = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) 
			{
				return ""+object.phone;
			}				
		};
		tc_PhoneNumber.setSortable(true);
		TextColumn<PatientData> tc_DOB = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object)
			{
				return object.dateOfBirth;
			}				
		};
		tc_DOB.setSortable(true);
		
		ListHandler<PatientData> columnSortHandler = new ListHandler<PatientData>(l_DummyData);
		columnSortHandler.setComparator(tc_Name,new Comparator<PatientData>() 
			{
		          public int compare(PatientData o1, PatientData o2) 
		          {
		            if (o1 == o2) {
		              return 0;
		            }

		            // Compare the name columns.
		            if (o1 != null) {
		              return (o2 != null) ? o1.lName.compareTo(o2.lName) : 1;
		            }
		            return -1;
		          }
		    });
		    
		ldp_CellData.setList(l_DummyData);
		ldp_CellData.addDataDisplay(ct_Results);
		ct_Results.getColumnSortList().push(tc_Name);
		
		ct_Results.addColumnSortHandler(columnSortHandler);
		
		//Add the columns to the table
		ct_Results.addColumn(tc_Name, "Name");
		ct_Results.addColumn(tc_Address, "Address");
		ct_Results.addColumn(tc_Email, "Email");
		ct_Results.addColumn(tc_PhoneNumber, "Phone");
		ct_Results.addColumn(tc_DOB, "Date Of Birth");		
		ct_Results.setRowCount(7,true);
		ct_Results.setRowData(l_DummyData);
		
		//Add table to the horizontal panel
		//Call the main panel generator again 
		//after populating to place table in main panel
		ct_Results.setPageSize(5);
		ct_Results.setWidth("642px");
		pager.setDisplay(ct_Results);
		
		b_Select.addClickHandler(new ClickHandler(){

			

			@Override
			public void onClick(ClickEvent event) 
			{
				PopUps pop = new PopUps();
				String tempID = ct_Results.getRowElement(ct_Results.getKeyboardSelectedRow()).getLastChild().toString();
				moveToPrescribe(userType,tempID);
			}
			
		});
		
		hpCRUD.add(b_Select);
		hpCRUD.add(b_Delete);
		
		vpTable.add(ct_Results);
		vpTable.add(pager);
		vpTable.add(hpCRUD);
		getFindPatientPanel();
	}
	
	protected void moveToPrescribe(String userID,String tempID) 
	{
		if(userID == "doctor")
		{
			super.refreshUI("doctor", 3,tempID);
		}
		else if(userID == "pharmacist")
		{
			super.refreshUI("pharmacist", 4,tempID);
		}
		
		
	}
	public void getPatientsSuper()
	{
		patients = super.getPatients();
	}
	
	public PatientData[] filterPatients(String field)
	{
		return null;
	
	}
	
	public String getUserType()
	{
		return super.getUserType();
	
	}
}