package com.example.farmwebapp.client.gui;

import java.util.List;
import java.util.Arrays;

import org.apache.xalan.xsltc.compiler.Pattern;
import org.apache.xerces.impl.xs.identity.Selector.Matcher;

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.example.farmwebapp.client.dbobjects.UserData;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.example.farmwebapp.client.dbobjects.PatientData;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.example.farmwebapp.client.dbobjects.MedicationData;
import com.example.farmwebapp.client.services.UserServiceInit;
import com.example.farmwebapp.client.services.UserServiceAsync;
import com.example.farmwebapp.client.services.PatientServiceInit;
import com.example.farmwebapp.client.services.PatientServiceAsync;
import com.example.farmwebapp.client.services.MedicationServiceInit;
import com.example.farmwebapp.client.services.MedicationServiceAsync;

public class PrescribeMeds extends MainGUI
{
	private FlexTable ft = new FlexTable();

	private HorizontalPanel hp_notes = new HorizontalPanel();
	private HorizontalPanel hp_doctorInfo = new HorizontalPanel();
	private HorizontalPanel hp_dosageInfo = new HorizontalPanel();
	private HorizontalPanel hp_medDuration = new HorizontalPanel();
	private HorizontalPanel hp_patientInfo = new HorizontalPanel();
	private HorizontalPanel hp_searchField = new HorizontalPanel();
	private HorizontalPanel hp_searchResults = new HorizontalPanel();
	private HorizontalPanel hp_lMainContainer = new HorizontalPanel();
	private HorizontalPanel hp_rMainContainer = new HorizontalPanel();
	private HorizontalPanel hp_drugAllergyInfo = new HorizontalPanel();

	private Image btn_submit = new Image("/images/submitWhite.png");
	private Image img_patientInfo = new Image("/images/patient.png");
	private Image img_doctorInfo = new Image("/images/stethoscope.png");
	private Image img_allergyWarning = new Image("/images/warning.png");
	private Image img_addMeds = new Image("/images/loginArrowWhite.png");
	private Image img_pillBottle = new Image("/images/pillBottleRevised.png");
	private final DateTimeFormat dateFormat = DateTimeFormat
			.getFormat("MM/dd/yyyy");

	private DateBox db_endDate = new DateBox();
	private DateBox db_startDate = new DateBox();

	private Label lbl_endDate = new Label("END");
	private Label lbl_notes = new Label("NOTES");
	private Label lbl_dosage = new Label("TAKE");
	private Label lbl_submit = new Label("SUBMIT");
	private Label lbl_startDate = new Label("START");
	private Label lbl_frequency = new Label("EVERY");
	private Label lbl_drugAllergies = new Label("DRUG ALLERGIES");
	private Label lbl_medicationList = new Label("MEDICATION LIST");

	private TextArea ta_notes = new TextArea();
	private TextBox tb_searchField = new TextBox();
	private TextBox tb_dosageField = new TextBox();

	private ListBox lb_time = new ListBox();
	private ListBox lb_units = new ListBox();

	private TextArea ta_doctorInfo = new TextArea();
	private TextArea ta_patientInfo = new TextArea();
	private TextArea ta_drugAllergies = new TextArea();
	private TextArea ta_addedMedication = new TextArea();

	private VerticalPanel vp_btnSubmit = new VerticalPanel();
	private VerticalPanel vp_leftContainer = new VerticalPanel();
	private VerticalPanel vp_rightContainer = new VerticalPanel();
	private VerticalPanel vp_drugAllergyInfo = new VerticalPanel();

	private CellTable<MedicationData> ct_Results = new CellTable<MedicationData>();

	private MedicationServiceAsync rpc;

	private MedicationData medications[];

	private static int ind;
	private static int pInd;
	private UserData[] user;
	private PatientData[] patient;
	private UserServiceAsync uRpc;
	private PatientServiceAsync pRpc;
	private PatientServiceAsync upRpc;

	/**
	 * Default constructor instantiates the rpc async service for querying the
	 * database
	 */
	public PrescribeMeds() {
		lb_units.addItem("--");
		lb_units.addItem("mg");
		lb_units.addItem("ml");
		lb_units.addItem("puff");
		lb_units.addItem("puffs");
		lb_units.addItem("capsule");
		lb_units.addItem("capsules");

		lb_time.addItem("--");
		lb_time.addItem("o.d.");
		lb_time.addItem("q.d.");
		lb_time.addItem("b.i.d");
		lb_time.addItem("b.i.d");
		lb_time.addItem("q.i.d");
		lb_time.addItem("q.o.d");
		lb_time.addItem("t.i.d");
		lb_time.addItem("n.p.o");
		lb_time.addItem("disp.");
		lb_time.addItem("ad.lib.");

		rpc = MedicationServiceInit.initRpc();
		uRpc = UserServiceInit.initRpc();
		pRpc = PatientServiceInit.initRpc();
		upRpc = PatientServiceInit.initRpc();
		getMedicationsDB();
		getUsersDB();
		getPatientsDB();
	}

	public void setPInd(int val) {
		pInd = val;
	}
	public void setPInd(String val) {
		pInd = Integer.valueOf(val);
	}


	public void setInd(int val) {
		ind = val;
	}

	/**
	 * Sends an asynchronous call to the database and populates the celltable
	 * with the results when query succeeds
	 */
	public void getMedicationsDB() {
		AsyncCallback<MedicationData[]> callback = new AsyncCallback<MedicationData[]>() {
			@Override
			public void onFailure(Throwable caught) {
				PopUps popUp = new PopUps();
				popUp.showDialog(caught.toString());
			}

			@Override
			public void onSuccess(MedicationData[] result) {
				medications = result;

				// Populates the celltable
				drawTable();
			}
		};
		rpc.getMedications(callback);
	}

	public void getUsersDB() {
		AsyncCallback<UserData[]> callback = new AsyncCallback<UserData[]>() {
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(UserData[] result) {
				user = result;

				ta_doctorInfo.setText(user[ind].fName + " " + user[ind].lName
						+ "\n" + user[ind].address + "\n" + user[ind].city
						+ "," + user[ind].state + " " + user[ind].zip + "\n"
						+ user[ind].email + "\n" + user[ind].phone);

			}

		};
		uRpc.getUsers(callback);
	}

	public void getPatientsDB() {
		AsyncCallback<PatientData[]> callback = new AsyncCallback<PatientData[]>() {
			@Override
			public void onFailure(Throwable caught) {
				PopUps popUp = new PopUps();
				popUp.showDialog(caught.toString());
			}

			@Override
			public void onSuccess(PatientData[] result) {
				patient = result;
				ta_patientInfo.setText(patient[7].fName + " "
						+ patient[7].lName + "\n" + patient[7].address
						+ "\n" + patient[7].city + ", " + patient[7].state
						+ " " + patient[7].zip + "\n" + patient[7].email
						+ "\n" + patient[7].phone + "\n" + "D.O.B: "
						+ patient[7].dateOfBirth);

				// Populates the cell table

			}
		};
		pRpc.getPatients(callback);
	}

	public void updatePatientsDB(final PatientData uPatient) {
		AsyncCallback<PatientData> callback = new AsyncCallback<PatientData>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(PatientData result) {
				moveToHome();
			}

		};
		upRpc.updatePatient(uPatient, callback);
	}

	public IsWidget getPrescribeMedsPanel() {
		/**
		 * PATIENT INFO
		 */
		// Design parameters
		ta_patientInfo.setVisibleLines(7);
		ta_patientInfo.setCharacterWidth(42);
		img_patientInfo.setPixelSize(100, 100);
		ta_patientInfo.setStyleName("gwt-TextArea");
		ta_patientInfo.getElement().setAttribute("disabled", "disabled");
		// Add to panels
		hp_patientInfo.add(img_patientInfo);
		hp_patientInfo.add(ta_patientInfo);
		ft.setWidget(0, 0, hp_patientInfo);

		/**
		 * DOCTOR INFO
		 */
		// Design parameters
		ta_doctorInfo.setVisibleLines(7);
		ta_doctorInfo.setCharacterWidth(42);
		img_doctorInfo.setPixelSize(100, 100);
		ta_doctorInfo.setStyleName("gwt-TextArea");
		ta_doctorInfo.getElement().setAttribute("disabled", "disabled");
		// Add to panels
		hp_doctorInfo.add(img_doctorInfo);
		hp_doctorInfo.add(ta_doctorInfo);
		ft.setWidget(0, 1, hp_doctorInfo);

		/**
		 * SEARCH MEDICATIONS - MEDICATION RESULTS - ALLERGY INFORMATION
		 */
		// Left horizontal panel for red background [Design Properties]
		hp_lMainContainer.setSpacing(5);
		hp_lMainContainer.setPixelSize(325, 435);
		hp_lMainContainer.setStyleName("redBackground");

		// Left vertical panel containing sub-horizontal panels [Design
		// Properties]
		vp_leftContainer.setSpacing(5);
		vp_leftContainer.setPixelSize(325, 435);

		// Pill bottle image [Design Properties]
		img_pillBottle.setPixelSize(100, 100);
		img_pillBottle.setStyleName("movePillBottle");

		// Medication button [Design Properties]
		img_addMeds.setPixelSize(25, 25);
		img_addMeds.getElement().setAttribute("align", "right");
		img_addMeds.setStyleName("moveAddMedArrow");

		// Drug allergy information [Design Properties]
		ta_drugAllergies.setPixelSize(200, 145);
		img_allergyWarning.setPixelSize(100, 100);
		lbl_drugAllergies.setStyleName("whiteFont");
		img_allergyWarning.setStyleName("moveWarningSign");

		

		// Add search results properties
		hp_searchResults.add(img_pillBottle);
		hp_searchResults.add(ct_Results);
		
		hp_searchResults.setStyleName("moveMedResults");
		
		// Add to main
		img_addMeds.setTitle("ADD MEDICAITON TO LIST");
		vp_leftContainer.add(hp_searchResults);
		vp_leftContainer.add(img_addMeds);
		hp_searchResults.setCellVerticalAlignment(img_pillBottle,
				HasVerticalAlignment.ALIGN_BOTTOM);
		vp_leftContainer.setCellHorizontalAlignment(img_addMeds,
				HasHorizontalAlignment.ALIGN_RIGHT);
		hp_drugAllergyInfo.setStyleName("moveAddMedArrow");
		// Click event
		img_addMeds.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				try {
					RegExp myPattern = RegExp.compile("[0-9][0-9]\">(.*?)</div>");
					String selectedMeds = ct_Results.getRowElement(ct_Results.getKeyboardSelectedRow()).getFirstChild().toString();
					MatchResult m = myPattern.exec(selectedMeds);
					boolean matchFound = m != null;
					if(matchFound )
					{
						for( int k = 0; k < m.getGroupCount(); k++)
						{
							String temp = m.getGroup(k);
							ta_addedMedication.setText(temp.substring(0, temp.length()));
						}
					}
					
					// Add click event
				} catch (Exception e) {
					
				}
			}
		});

		img_addMeds.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				img_addMeds.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});

		// Add drug allergy properties
		hp_drugAllergyInfo.add(img_allergyWarning);
		vp_drugAllergyInfo.add(lbl_drugAllergies);
		vp_drugAllergyInfo.add(ta_drugAllergies);
		hp_drugAllergyInfo.add(vp_drugAllergyInfo);
		hp_drugAllergyInfo.setCellVerticalAlignment(img_allergyWarning,
				HasVerticalAlignment.ALIGN_BOTTOM);
		hp_drugAllergyInfo.setCellHorizontalAlignment(img_allergyWarning,
				HasHorizontalAlignment.ALIGN_CENTER);
		lbl_drugAllergies.setStyleName("moveDrugAllergyLabel");
		hp_drugAllergyInfo.setStyleName("moveListResults");
		
		// Add to main
		vp_leftContainer.add(hp_drugAllergyInfo);

		/**
		 * MEDICATION LIST - DOSAGE INFO - NOTES - SUBMIT
		 */
		// Right horizontal panel for red background [Design Properties]
		hp_rMainContainer.setSpacing(5);
		hp_rMainContainer.setPixelSize(325, 435);
		hp_rMainContainer.setStyleName("redBackground");

		// Right vertical panel containing sub-horizontal panels [Design
		// Properties]
		vp_rightContainer.setSpacing(5);
		vp_rightContainer.setPixelSize(325, 435);

		// Search field [Design Properties]
		hp_searchField.setSpacing(5);
		tb_searchField.setPixelSize(140, 15);
		lbl_medicationList.addStyleName("whiteFont");

		// Added medication [Design Properties]
		ta_addedMedication.setPixelSize(300, 100);

		// Added medication properties
		vp_rightContainer.add(lbl_medicationList);
		vp_rightContainer.add(ta_addedMedication);
		vp_rightContainer.setCellVerticalAlignment(lbl_medicationList,
				HasVerticalAlignment.ALIGN_BOTTOM);

		// Dosage information [Design Properties]
		hp_dosageInfo.setSpacing(5);
		hp_medDuration.setSpacing(5);
		lb_time.setPixelSize(73, 23);
		lb_units.setPixelSize(73, 23);
		ta_notes.setPixelSize(220, 145);
		btn_submit.setPixelSize(80, 80);
		db_endDate.setPixelSize(100, 15);
		db_startDate.setPixelSize(100, 15);
		tb_dosageField.setPixelSize(50, 10);
		lbl_notes.setStyleName("whiteFont");
		lbl_submit.setStyleName("whiteFont");
		lbl_dosage.setStyleName("whiteFont");
		lbl_endDate.setStyleName("whiteFont");
		lbl_frequency.setStyleName("whiteFont");
		lbl_startDate.setStyleName("whiteFont");
		db_endDate.setFormat(new DateBox.DefaultFormat(dateFormat));
		db_endDate.setFormat(new DateBox.DefaultFormat(dateFormat));
		db_startDate.setFormat(new DateBox.DefaultFormat(dateFormat));
		db_startDate.setFormat(new DateBox.DefaultFormat(dateFormat));

		// Add dosage info
		hp_dosageInfo.add(lbl_dosage);
		hp_dosageInfo.add(tb_dosageField);
		hp_dosageInfo.add(lb_units);
		hp_dosageInfo.add(lbl_frequency);
		hp_dosageInfo.add(lb_time);
		hp_dosageInfo.setCellVerticalAlignment(lb_time,
				HasVerticalAlignment.ALIGN_BOTTOM);
		hp_dosageInfo.setCellVerticalAlignment(lb_units,
				HasVerticalAlignment.ALIGN_BOTTOM);
		hp_dosageInfo.setCellVerticalAlignment(lbl_dosage,
				HasVerticalAlignment.ALIGN_BOTTOM);
		hp_dosageInfo.setCellVerticalAlignment(lbl_frequency,
				HasVerticalAlignment.ALIGN_BOTTOM);
		hp_dosageInfo.setCellVerticalAlignment(lbl_frequency,
				HasVerticalAlignment.ALIGN_BOTTOM);

		// Add to main
		vp_rightContainer.add(hp_dosageInfo);

		// Add duration info
		hp_medDuration.add(lbl_startDate);
		hp_medDuration.add(db_startDate);
		hp_medDuration.add(lbl_endDate);
		hp_medDuration.add(db_endDate);
		hp_medDuration.setCellVerticalAlignment(lbl_startDate,
				HasVerticalAlignment.ALIGN_BOTTOM);
		hp_medDuration.setCellVerticalAlignment(db_startDate,
				HasVerticalAlignment.ALIGN_BOTTOM);
		hp_medDuration.setCellVerticalAlignment(lbl_endDate,
				HasVerticalAlignment.ALIGN_BOTTOM);
		hp_medDuration.setCellVerticalAlignment(db_endDate,
				HasVerticalAlignment.ALIGN_BOTTOM);

		// Add to main
		vp_rightContainer.add(hp_medDuration);

		// Add notes info
		vp_rightContainer.add(lbl_notes);
		vp_rightContainer.setCellVerticalAlignment(lbl_notes,
				HasVerticalAlignment.ALIGN_BOTTOM);

		hp_notes.add(ta_notes);
		vp_btnSubmit.add(btn_submit);
		vp_btnSubmit.add(lbl_submit);
		vp_btnSubmit.setCellVerticalAlignment(lbl_submit,
				HasVerticalAlignment.ALIGN_BOTTOM);
		vp_btnSubmit.setCellHorizontalAlignment(lbl_submit,
				HasHorizontalAlignment.ALIGN_CENTER);

		hp_notes.add(vp_btnSubmit);
		vp_btnSubmit.setStyleName("moveSubmitBtn");
		hp_notes.setCellVerticalAlignment(vp_btnSubmit,
				HasVerticalAlignment.ALIGN_BOTTOM);

		// Add to main
		vp_rightContainer.add(hp_notes);
		btn_submit.setTitle("SUBMIT PRESCRIPTION");
		// Click event
		btn_submit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				PatientData upPatient = new PatientData();

				upPatient.patientID = patient[7].patientID;
				upPatient.prescription = "Take " + tb_dosageField.getText()
						+ " " + lb_units.getSelectedItemText() + " of "
						+ ta_addedMedication.getText() + " every "
						+ lb_time.getSelectedItemText() + " from "
						+ dateFormat.format(db_startDate.getValue()).toString() + " until "
						+ dateFormat.format(db_endDate.getValue()).toString();
				upPatient.status = "Unfilled";
				updatePatientsDB(upPatient);
			}

		});

		btn_submit.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				btn_submit.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});

		// Add to main
		hp_lMainContainer.add(vp_leftContainer);
		ft.setWidget(1, 0, hp_lMainContainer);

		// Add to main
		hp_rMainContainer.add(vp_rightContainer);
		ft.setWidget(1, 1, hp_rMainContainer);
		return ft;
	}

	/**
	 * Populates the celltable using the PatientData class and the result of the
	 * query(PatientData[])
	 */
	public void drawTable() {
		/**
		 * CELL TABLE FIELD
		 */
		final List<MedicationData> l_DummyData = Arrays.asList(medications);

		TextColumn<MedicationData> tc_MedName = new TextColumn<MedicationData>() {
			@Override
			public String getValue(MedicationData object) {
				return object.medicationName;
			}
		};

		// Add the columns to the table
		ct_Results.addColumn(tc_MedName, "");
		ct_Results.setRowCount(2, true);
		ct_Results.setRowData(l_DummyData);

		// Add table to the horizontal panel
		// Call the main panel generator again
		// after populating to place table in main panel
		ct_Results.setPageSize(8);
		ct_Results.setWidth("210px");
		// hp_searchResults.add(ct_Results);
		getPrescribeMedsPanel();
	}
	
	public void moveToHome()
	{
		//super.refreshUI("Doctor");
	}
}