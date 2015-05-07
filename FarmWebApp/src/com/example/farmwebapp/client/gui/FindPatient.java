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
import java.util.Comparator;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.example.farmwebapp.client.dbobjects.PatientData;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.example.farmwebapp.client.services.PatientServiceInit;
import com.example.farmwebapp.client.services.PatientServiceAsync;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;

public class FindPatient extends MainGUI {
	private final int CELLWIDTH = 195;
	private final int CELLHEIGHT = 15;

	private FlexTable ft = new FlexTable();

	private PatientData[] patients;
	private PatientServiceAsync rpc;

	private DateBox db_dob = new DateBox();

	private TextBox tb_email = new TextBox();
	private TextBox tb_phoneNo = new TextBox();
	private TextBox tb_nameLast = new TextBox();
	private TextBox tb_nameFirst = new TextBox();
	private TextBox tb_addressZip = new TextBox();
	private TextBox tb_addressCity = new TextBox();
	private TextBox tb_addressState = new TextBox();
	private TextBox tb_addressStreet = new TextBox();
	
	private Button b_Select = new Button("Select Patient");
	private Button b_Delete = new Button("Delete Patient");

	private String userType = super.getUserType();

	private SimplePager pager = new SimplePager();

	private VerticalPanel vp = new VerticalPanel();
	private VerticalPanel vpTable = new VerticalPanel();

	private HorizontalPanel hpCRUD = new HorizontalPanel();
	
	private Image img_findPatient = new Image("/images/findPatientRed.png");

	private CellTable<PatientData> ct_Results = new CellTable<PatientData>();

	private final DateTimeFormat dateFormat = DateTimeFormat
			.getFormat("MM/dd/yyyy");

	/**
	 * Default constructor instantiates the rpc async service for querying the
	 * database
	 */
	public FindPatient() {
		//patients = super.getPatients();
	}

	public FindPatient(String string) {
		userType = string;
	}

	/**
	 * Sends an asynchronous call to the database and populates the celltable
	 * with the results when query succeeds
	 * 
	 * @return
	 */
	public void getPatientsDB() {
		rpc = PatientServiceInit.initRpc();
		AsyncCallback<PatientData[]> callback = new AsyncCallback<PatientData[]>() {
			@Override
			public void onFailure(Throwable caught) {
				PopUps popUp = new PopUps();
			} // popUp.showDialog(caught.toString());

			@Override
			public void onSuccess(PatientData[] result) {
				PopUps popUp = new PopUps();
				// popUp.showDialog("Got the patients!");
				patients = result;
				drawTable(patients);
				// findPatientPanel = new FindPatient(PatientsDB);
				// findPatientPanel.getFindPatientPanel().asWidget().removeFromParent();
				// homePage.add(findPatientPanel.getFindPatientPanel(),
				// "FIND PATIENT");
			}
		};
		
		
		rpc.getPatients(callback);
	}
	/**
	 * Sends an asynchronous call to the database and populates the celltable
	 * with the results when query succeeds
	 * 
	 * @return
	 */
	public void getPatientsDB(String name) {
		rpc = PatientServiceInit.initRpc();
		AsyncCallback<PatientData[]> callback = new AsyncCallback<PatientData[]>() {
			@Override
			public void onFailure(Throwable caught) {
				PopUps popUp = new PopUps();
			} // popUp.showDialog(caught.toString());

			@Override
			public void onSuccess(PatientData[] result) {
				PopUps popUp = new PopUps();
				// popUp.showDialog("Got the patients!");
				patients = result;
				drawTable(patients);
				// findPatientPanel = new FindPatient(PatientsDB);
				// findPatientPanel.getFindPatientPanel().asWidget().removeFromParent();
				// homePage.add(findPatientPanel.getFindPatientPanel(),
				// "FIND PATIENT");
			}
		};
		rpc.getPatients("fname",name,callback);
	}

	/**
	 * @return Vertical panel with necessary text-boxes to search for a patient
	 */
	public IsWidget getFindPatientPanel() {
		/**
		 * NAME FIELD
		 */
		ft.setText(0, 0, "FIRST NAME");
		ft.getCellFormatter().setVerticalAlignment(0, 0,
				HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(0, 1, tb_nameFirst);
		tb_nameFirst.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_nameFirst.setTitle("FIRST NAME");

		ft.setText(0, 2, "LAST NAME");
		ft.getCellFormatter().setVerticalAlignment(0, 2,
				HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(0, 3, tb_nameLast);
		tb_nameLast.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_nameLast.setTitle("LAST NAME");

		/**
		 * ADDRESS FIELD
		 */
		ft.setText(1, 0, "ADDRESS");
		ft.getCellFormatter().setVerticalAlignment(1, 0,
				HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 1, tb_addressStreet);
		tb_addressStreet.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_addressStreet.setTitle("ADDRESS");


		ft.setText(1, 2, "CITY");
		ft.getCellFormatter().setVerticalAlignment(1, 2,
				HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 3, tb_addressCity);
		tb_addressCity.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_addressCity.setTitle("CITY");

		ft.setText(2, 0, "STATE");
		ft.getCellFormatter().setVerticalAlignment(2, 0,
				HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(2, 1, tb_addressState);
		tb_addressState.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_addressState.setTitle("STATE\nFORMAT: CA");
		tb_addressState.getElement().setAttribute("maxlength", "2");
		tb_addressState.addKeyPressHandler(new KeyPressHandler() {

			public void onKeyPress(KeyPressEvent event) {
				if (!Character.isLetter(event.getCharCode())) {
					((TextBox) event.getSource()).cancelKey();
				}
			}
		}); // restricts tb_addressState to only allow 2 letters

		ft.setText(2, 2, "ZIP CODE");
		ft.getCellFormatter().setVerticalAlignment(2, 2,
				HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(2, 3, tb_addressZip);
		tb_addressZip.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_addressZip.setTitle("ZIP CODE\nFORMAT: #####");
		tb_addressZip.getElement().setAttribute("maxlength", "5");
		tb_addressZip.addKeyPressHandler(new KeyPressHandler() {

			public void onKeyPress(KeyPressEvent event) {
				if (!Character.isDigit(event.getCharCode())) {
					((TextBox) event.getSource()).cancelKey();
				}
			}
		}); // restricts tb_addressZip to only allow 5 numbers

		/**
		 * DATE OF BIRTH FIELD
		 */
		db_dob.setFormat(new DateBox.DefaultFormat(dateFormat));
		ft.setText(3, 0, "DATE OF BIRTH");
		ft.getCellFormatter().setVerticalAlignment(3, 0,
				HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 1, db_dob);
		db_dob.setPixelSize(CELLWIDTH, CELLHEIGHT);
		db_dob.setTitle("DATE\nFORMAT: MM/DD/YYYY");

		/**
		 * EMAIL FIELD
		 */
		ft.setText(3, 2, "EMAIL");
		ft.getCellFormatter().setVerticalAlignment(3, 2,
				HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 3, tb_email);
		tb_email.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_email.setTitle("EMAIL\nFORMAT: EXAMPLE@DOMAIN.COM");

		/**
		 * PHONE NUMBER FIELD
		 */
		ft.setText(4, 0, "PHONE NUMBER");
		ft.getCellFormatter().setVerticalAlignment(4, 0,
				HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(4, 1, tb_phoneNo);
		tb_phoneNo.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_phoneNo.setTitle("PHONE NUMBER\nFORMAT: ##########");
		tb_phoneNo.getElement().setAttribute("maxlength", "10");
		tb_phoneNo.addKeyPressHandler(new KeyPressHandler() {
			public void onKeyPress(KeyPressEvent event) {
				if (!Character.isDigit(event.getCharCode())) {
					((TextBox) event.getSource()).cancelKey();
				}
			}
		}); // restricts tb_phoneNo to only allow numbers
		
		img_findPatient.setPixelSize(25, 25);
		ft.getCellFormatter().setVerticalAlignment(4, 3,
				HasVerticalAlignment.ALIGN_BOTTOM);
		img_findPatient.setTitle("FIND PATIENT");
		img_findPatient.getElement().setAttribute("align", "right");
		img_findPatient.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(tb_nameFirst.getText()!= null)
				{
				getPatientsDB(tb_nameFirst.getText());
				}
				else
				{
					getPatientsDB();
				}
			}
		});
		
		/**
		 * Change mouse to pointer to indicate the arrow is a button
		 */
		img_findPatient.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				img_findPatient.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});

		ft.setWidget(4, 3, img_findPatient);

		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.getElement().setAttribute("cellpadding", "10");
		
		// Add necessary panels
		vp.add(ft);
		vp.add(vpTable);
		vp.setCellVerticalAlignment(vpTable, HasVerticalAlignment.ALIGN_MIDDLE);
		vp.setCellHorizontalAlignment(vpTable,
				HasHorizontalAlignment.ALIGN_CENTER);
		return vp;
	}

	/**
	 * Populates the celltable using the PatientData class and the result of the
	 * query(PatientData[])
	 */
	public void drawTable(PatientData[] temp) {
		/**
		 * CELL TABLE FIELD
		 */
		final List<PatientData> l_DummyData = Arrays.asList(temp);
		ListDataProvider<PatientData> ldp_CellData = new ListDataProvider<PatientData>();

		TextColumn<PatientData> tc_ID = new TextColumn<PatientData>()
		{

			@Override
			public String getValue(PatientData object) 
			{
				return ""+object.patientID;
			}
	
		};
		TextColumn<PatientData> tc_Name = new TextColumn<PatientData>()
		{
			@Override
			public String getValue(PatientData object) {
				return "" + object.lName + ", " + object.fName;
			}
		};
		tc_Name.setSortable(true);
		TextColumn<PatientData> tc_Address = new TextColumn<PatientData>() {
			@Override
			public String getValue(PatientData object) {
				return object.address + ", " + object.city + " " + object.state
						+ " " + object.zip;
			}
		};
		tc_Address.setSortable(true);
		TextColumn<PatientData> tc_Email = new TextColumn<PatientData>() {
			@Override
			public String getValue(PatientData object) {
				return object.email;
			}
		};
		tc_Email.setSortable(true);
		TextColumn<PatientData> tc_PhoneNumber = new TextColumn<PatientData>() {
			@Override
			public String getValue(PatientData object) {
				return "" + object.phone;
			}
		};
		tc_PhoneNumber.setSortable(true);
		TextColumn<PatientData> tc_DOB = new TextColumn<PatientData>() {
			@Override
			public String getValue(PatientData object) {
				return object.dateOfBirth;
			}
		};
		tc_DOB.setSortable(true);

		ListHandler<PatientData> columnSortHandler = new ListHandler<PatientData>(
				l_DummyData);
		columnSortHandler.setComparator(tc_Name, new Comparator<PatientData>() {
			public int compare(PatientData o1, PatientData o2) {
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

		// Add the columns to the table
		ct_Results.addColumn(tc_ID,"ID");
		ct_Results.addColumn(tc_Name, "Name");
		ct_Results.addColumn(tc_Address, "Address");
		ct_Results.addColumn(tc_Email, "Email");
		ct_Results.addColumn(tc_PhoneNumber, "Phone");
		ct_Results.addColumn(tc_DOB, "D.O.B");
		ct_Results.setRowCount(2,true);
		ct_Results.setRowData(l_DummyData);

		// Add table to the horizontal panel
		// Call the main panel generator again
		// after populating to place table in main panel
		ct_Results.setPageSize(2);
		ct_Results.setWidth("642px");
		pager.setDisplay(ct_Results);

		b_Select.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				PopUps pop = new PopUps();
				PrescribeMeds prescribe = new PrescribeMeds();
				PrintMeds print = new PrintMeds();
				String tempID = ct_Results
						.getRowElement(ct_Results.getKeyboardSelectedRow())
						.getFirstChild().toString();
				
				prescribe.setPInd(7);
				print.setPInd(7);
				moveToPrescribe(userType, tempID);
			}
		});

		hpCRUD.add(b_Select);

		vpTable.add(ct_Results);
		vpTable.add(pager);
		vpTable.add(hpCRUD);
		getFindPatientPanel();
	}

	protected void moveToPrescribe(String userID, String tempID) {
		if (userID == "doctor") {
			super.refreshUI("doctor", 3, tempID);
		} else if (userID == "pharmacist") {
			super.refreshUI("pharmacist", 4, tempID);
		}

	}

	public void getPatientsSuper() {
		patients = super.getPatients();
	}

	public PatientData[] filterPatients(String field) {
		return null;
	}

	public String getUserType() {
		return super.getUserType();
	}
}