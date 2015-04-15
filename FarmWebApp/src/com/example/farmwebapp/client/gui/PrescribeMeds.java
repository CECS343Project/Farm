package com.example.farmwebapp.client.gui;

import java.util.Arrays;
import java.util.List;

import com.example.farmwebapp.client.dbobjects.PatientData;
import com.example.farmwebapp.client.services.PatientServiceAsync;
import com.example.farmwebapp.client.services.PatientServiceInit;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class PrescribeMeds {
	private FlexTable ft = new FlexTable();
	
	private HorizontalPanel hp_doctorInfo = new HorizontalPanel();
	private HorizontalPanel hp_patientInfo = new HorizontalPanel();
	private HorizontalPanel hp_searchField = new HorizontalPanel();
	private HorizontalPanel hp_lMainContainer = new HorizontalPanel();
	private HorizontalPanel hp_searchResults = new HorizontalPanel();
	
	private Image img_patientInfo = new Image("/images/patient.png");
	private Image img_doctorInfo = new Image("/images/stethoscope.png");
	private Image img_pillBottle = new Image("/images/pillBottleRevised.png");
	private Image btn_addMeds = new Image("/images/loginArrowWhite.png");
	private Image img_allergyWarning = new Image("/images/warning.png");
	
	private Label lbl_searchField = new Label("SEARCH");
	
	private TextArea ta_doctorInfo = new TextArea();
	private TextArea ta_patientInfo = new TextArea();
	private TextArea ta_drugAllergies = new TextArea();
	
	private TextBox tb_searchField = new TextBox();
	private Label lbl_drugAllergies = new Label("DRUG ALLERGIES");
	private VerticalPanel vp_leftContainer = new VerticalPanel();
	private VerticalPanel vp_drugAllergyInfo = new VerticalPanel();
	private HorizontalPanel hp_drugAllergyInfo = new HorizontalPanel();
	
	private CellTable<PatientData> ct_Results = new CellTable<PatientData>();
	private PatientServiceAsync rpc;
	private PatientData PatientsDB[];
	
	/**
	 * Default constructor instantiates the rpc async service 
	 * for querying the database
	 */
	public PrescribeMeds() 
	{
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
	
	public IsWidget getPrescribeMedsPanel() {
		/**
		 * PATIENT INFO
		 */
		//Hard coded information for demo purposes
		ta_patientInfo.setText("Napoleon Fulinara Jr" + "\n" + "727 W 7th St. Unit 1113" + "\n" 
				+ "Los Angeles, Ca 90017" + "\n" + "jrfulinara@gmail.com" + "\n" 
				+ "(858) 216-5155" + "\n" + "Policy No: 0000000000" + "\n" + "D.O.B: 06/22/1984");
		//Design parameters
		ta_patientInfo.setVisibleLines(7);
		ta_patientInfo.setCharacterWidth(42);
		img_patientInfo.setPixelSize(100, 100);
		ta_patientInfo.setStyleName("gwt-TextArea");
		ta_patientInfo.getElement().setAttribute("disabled", "disabled");
		//Add to panels
		hp_patientInfo.add(img_patientInfo);
		hp_patientInfo.add(ta_patientInfo);
		ft.setWidget(0, 0, hp_patientInfo);
		
		/**
		 * DOCTOR INFO
		 */
		//Hard coded information for demo purposes
		ta_doctorInfo.setText("Napoleon Fulinara Jr" + "\n" + "727 W 7th St. Unit 1113" + "\n" 
				+ "Los Angeles, Ca 90017" + "\n" + "jrfulinara@gmail.com" + "\n" 
				+ "(858) 216-5155" + "\n" + "Policy No: 0000000000" + "\n" + "D.O.B: 06/22/1984");
		//Design parameters
		ta_doctorInfo.setVisibleLines(7);
		ta_doctorInfo.setCharacterWidth(42);
		img_doctorInfo.setPixelSize(100, 100);
		ta_doctorInfo.setStyleName("gwt-TextArea");
		ta_doctorInfo.getElement().setAttribute("disabled", "disabled");
		//Add to panels
		hp_doctorInfo.add(img_doctorInfo);
		hp_doctorInfo.add(ta_doctorInfo);
		ft.setWidget(0, 1, hp_doctorInfo);
		
		/**
		 * SEARCH MEDICATIONS - MEDICATION RESULTS - ALLERGY INFORMATION
		 */
		//Left horizontal panel for red background [Design Properties]
		hp_lMainContainer.setSpacing(5);
		hp_lMainContainer.setPixelSize(325, 435);
		hp_lMainContainer.setStyleName("redBackground");
		
		//Left vertical panel containing sub-horizontal panels [Design Properties]
		vp_leftContainer.setSpacing(5);
		vp_leftContainer.setPixelSize(325, 435);
		
		//Search field design properties [Design Properties]
		hp_searchField.setSpacing(5);
		tb_searchField.setPixelSize(140, 15);
		lbl_searchField.addStyleName("whiteFont");
		
		//Pill bottle image [Design Properties]
		img_pillBottle.setPixelSize(100, 100);
		img_pillBottle.setStyleName("movePillBottle");
		hp_searchField.add(lbl_searchField);
		hp_searchField.add(tb_searchField);
		hp_searchField.setCellVerticalAlignment(lbl_searchField, HasVerticalAlignment.ALIGN_BOTTOM);
		
		vp_leftContainer.add(hp_searchField);
		vp_leftContainer.setCellHorizontalAlignment(hp_searchField, HasHorizontalAlignment.ALIGN_RIGHT);
		
		hp_searchResults.add(img_pillBottle);
		hp_searchResults.add(ct_Results);
		vp_leftContainer.add(hp_searchResults);
		hp_searchResults.setCellVerticalAlignment(img_pillBottle, HasVerticalAlignment.ALIGN_BOTTOM);
		
		/**
		 * ADD MEDICATION BUTTON
		 */
		//Design parameters
		btn_addMeds.setPixelSize(25, 25);
		//btn_addMeds.setStyleName("moveMedArrow");
		btn_addMeds.getElement().setAttribute("align", "right");
		vp_leftContainer.add(btn_addMeds);
		vp_leftContainer.setCellHorizontalAlignment(btn_addMeds, HasHorizontalAlignment.ALIGN_RIGHT);
		
		//Click event
		btn_addMeds.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	        	try {
		            //Add click event
	        	}
	        	catch(Exception e) {
	        		//Add click event exception
	        	}
	        }
	    });
		
		btn_addMeds.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				btn_addMeds.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});
		img_allergyWarning.setPixelSize(100, 100);
		img_allergyWarning.setStyleName("moveWarningSign");
		ta_drugAllergies.setPixelSize(200, 100);
		lbl_drugAllergies.setStyleName("whiteFont");
		hp_drugAllergyInfo.add(img_allergyWarning);
		hp_drugAllergyInfo.setCellHorizontalAlignment(img_allergyWarning, HasHorizontalAlignment.ALIGN_CENTER);
		vp_drugAllergyInfo.add(lbl_drugAllergies);
		vp_drugAllergyInfo.add(ta_drugAllergies);
		hp_drugAllergyInfo.add(vp_drugAllergyInfo);
		hp_drugAllergyInfo.setCellVerticalAlignment(img_allergyWarning, HasVerticalAlignment.ALIGN_BOTTOM);
		vp_leftContainer.add(hp_drugAllergyInfo);
		
		hp_lMainContainer.add(vp_leftContainer);
		ft.setWidget(1, 0, hp_lMainContainer);
		
		return ft;
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
		
		//Add the columns to the table
		ct_Results.addColumn(tc_Name, "");
		ct_Results.setRowCount(2,true);
		ct_Results.setRowData(l_DummyData);
		
		//Add table to the horizontal panel
		//Call the main panel generator again 
		//after populating to place table in main panel
		ct_Results.setPageSize(8);
		ct_Results.setWidth("210px");
		//hp_searchResults.add(ct_Results);
		getPrescribeMedsPanel();
	}
}