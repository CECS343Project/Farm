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

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.cell.client.ButtonCellBase.DefaultAppearance.Style;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.example.farmwebapp.client.dbobjects.PatientData;
import com.example.farmwebapp.client.services.PatientServiceAsync;
import com.example.farmwebapp.client.services.PatientServiceInit;

public class PharmacyUpdate // extends MainGUI
{
	private PatientServiceAsync rpc;
	private PatientData PatientsDB[];
	
	private FlexTable ft = new FlexTable();
	
	private SimplePager pager = new SimplePager();
	
	private Button b_Select = new Button("Select Patient");
	private Button b_Delete = new Button("Delete Patient");

	private VerticalPanel vp = new VerticalPanel();
	private VerticalPanel vpTable = new VerticalPanel();
	private HorizontalPanel hpCRUD = new HorizontalPanel();
	
	private Image img_update = new Image("/images/updatePharmacy.png");

	private CellTable<PatientData> ct_Results = new CellTable<PatientData>();

	/**
	 * Default constructor instantiates the rpc async service for querying the
	 * database
	 */
	public PharmacyUpdate() {
		rpc = PatientServiceInit.initRpc();
		getPatientsDB();
	}

	/**
	 * Sends an asynchronous call to the database and populates the celltable
	 * with the results when query succeeds
	 */
	public void getPatientsDB() {
		AsyncCallback<PatientData[]> callback = new AsyncCallback<PatientData[]>() {
			@Override
			public void onFailure(Throwable caught) {
				PopUps popUp = new PopUps();
				popUp.showDialog(caught.toString());
			}

			@Override
			public void onSuccess(PatientData[] result) {
				PatientsDB = result;

				// Populates the celltable
				drawTable();
			}
		};
		rpc.getPatientsUnfilled(callback);
	}

	/**
	 * @return Vertical panel with necessary text-boxes to search for a patient
	 */
	public IsWidget getPharmacyUpdatePanel() {
		// Add necessary panels
		vp.setSpacing(5);
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
	public void drawTable() {
		/**
		 * CELL TABLE FIELD
		 */
		final List<PatientData> l_DummyData = Arrays.asList(PatientsDB);
		ListDataProvider<PatientData> ldp_CellData = new ListDataProvider<PatientData>();

		TextColumn<PatientData> tc_Name = new TextColumn<PatientData>() {
			@Override
			public String getValue(PatientData object) {
				return object.lName + ", " + object.fName;
			}
		};
		TextColumn<PatientData> tc_Address = new TextColumn<PatientData>() {
			@Override
			public String getValue(PatientData object) {
				return object.address + ", " + object.city + " " + object.state
						+ " " + object.zip;
			}
		};
		TextColumn<PatientData> tc_Email = new TextColumn<PatientData>() {
			@Override
			public String getValue(PatientData object) {
				return object.email;
			}
		};
		TextColumn<PatientData> tc_PhoneNumber = new TextColumn<PatientData>() {
			@Override
			public String getValue(PatientData object) {
				return "" + object.phone;
			}
		};
		TextColumn<PatientData> tc_DOB = new TextColumn<PatientData>() {
			@Override
			public String getValue(PatientData object) {
				return object.dateOfBirth;
			}
		};

		ldp_CellData.setList(l_DummyData);
		ldp_CellData.addDataDisplay(ct_Results);
		ct_Results.getColumnSortList().push(tc_Name);

		// Add the columns to the table
		ct_Results.addColumn(tc_Name, "Name");
		ct_Results.addColumn(tc_Address, "Address");
		ct_Results.addColumn(tc_Email, "Email");
		ct_Results.addColumn(tc_PhoneNumber, "Phone");
		ct_Results.addColumn(tc_DOB, "D.O.B");
		ct_Results.setRowCount(7, true);
		ct_Results.setRowData(l_DummyData);

		// Add table to the horizontal panel
		// Call the main panel generator again
		// after populating to place table in main panel
		ct_Results.setWidth("675px");
		pager.setDisplay(ct_Results);

		b_Select.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PrintMeds print = new PrintMeds();

				PopUps pop = new PopUps();
				String tempID = ct_Results
						.getRowElement(ct_Results.getKeyboardSelectedRow())
						.getFirstChild().toString();
				int selectedID = ct_Results.getKeyboardSelectedRow();
				print.setName(tempID.split(", ")[0]);
				print.setInd(selectedID);
				// pop.showDialog(tempID.split(", ")[0]);
				moveToPrescribe("pharmacist", tempID, selectedID);
			}
		});

		/**
		 * UPDATE IMAGE BUTTON
		 */
		img_update.setPixelSize(100, 100);
		img_update.addStyleName("moveRefresh");
		img_update.setTitle("REFRESH PRESCRIPTIONS");
		/**
		 * PRESCRIPTION REFRESH
		 */
		img_update.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// DO SOMETHING
			}
		});

		/**
		 * Change mouse to pointer to indicate the arrow is a button
		 */
		img_update.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				img_update.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});
		
		hpCRUD.add(b_Select);
		hpCRUD.add(b_Delete);
		hpCRUD.addStyleName("moveRefreshBTN");
		vpTable.add(img_update);
		vpTable.add(ct_Results);
		pager.addStyleName("movePager");
		vpTable.add(pager);
		vpTable.add(hpCRUD);
		getPharmacyUpdatePanel();
	}

	protected void moveToPrescribe(String userID, String tempID, int selectedID) {
		MainGUI gui = new MainGUI();
		if (userID == "doctor") {
			gui.refreshUI("doctor", 3, tempID);
		} else if (userID == "pharmacist") {
			gui.refreshUI("pharmacist", 4, tempID, selectedID);
		}

	}
}