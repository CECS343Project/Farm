package com.example.farmwebapp.client.gui;

import java.util.List;
import java.util.Arrays;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.example.farmwebapp.client.dbobjects.PatientData;
import com.example.farmwebapp.client.dbobjects.UserData;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.example.farmwebapp.client.services.PatientServiceAsync;
import com.example.farmwebapp.client.services.PatientServiceInit;
import com.example.farmwebapp.client.services.UserServiceAsync;
import com.example.farmwebapp.client.services.UserServiceInit;

public class PrintMeds extends MainGUI
{
	private FlexTable ft = new FlexTable();
	
	private HorizontalPanel hp_pharmInfo = new HorizontalPanel();
	private HorizontalPanel hp_doctorInfo = new HorizontalPanel();
	private HorizontalPanel hp_patientInfo = new HorizontalPanel();
	private HorizontalPanel hp_lMainContainer = new HorizontalPanel();
	private HorizontalPanel hp_rMainContainer = new HorizontalPanel();
	private VerticalPanel vp_labelContainer = new VerticalPanel();
	private HorizontalPanel hp_drugAllergyInfo = new HorizontalPanel();
	private HorizontalPanel hp_dosageBarcode = new HorizontalPanel();
	private HorizontalPanel hp_labelSubmitContainer = new HorizontalPanel();
	
	private Image img_barcode = new Image("/images/barCode.png");
	private Image btn_submit = new Image ("/images/printer.png");
	private Image img_patientInfo = new Image("/images/patient.png");
	private Image img_doctorInfo = new Image("/images/stethoscope.png");
	private Image img_allergyWarning = new Image("/images/warning.png");
	private Image img_pharmBottle = new Image("/images/pharmBottle.png");
	private Image img_warningLabel = new Image("/images/warningLabelNew.png");
	
	private Label lbl_notesReview = new Label("REVIEW");
	private Label lbl_authorize = new Label("PRINT");
	private Label lbl_drugAllergies = new Label("DRUG ALLERGIES");
	private Label lbl_medicationLabel = new Label("MEDICATION LABEL");
	
	private TextArea ta_pharmInfo = new TextArea();
	private TextArea ta_doctorInfo = new TextArea();
	private TextArea ta_dosageInfo = new TextArea();
	private TextArea ta_notesReview = new TextArea();
	private TextArea ta_patientInfo = new TextArea();
	private TextArea ta_drugAllergies = new TextArea();
	
	private VerticalPanel vp_btnSubmit = new VerticalPanel();
	private VerticalPanel vp_leftContainer = new VerticalPanel();
	private VerticalPanel vp_rightContainer = new VerticalPanel();
	private VerticalPanel vp_drugAllergyInfo = new VerticalPanel();
	
	private CellTable<PatientData> ct_Results = new CellTable<PatientData>();
	
	private PatientServiceAsync rpc;
	private PatientServiceAsync printRpc;
	private UserServiceAsync uRpc;
	private static String name;
	private static int ind;
	private static int pInd;
	
	private PatientData patient[];
	private UserData user[];
	private int indx;
	
	public void setPInd(int in)
	{
		pInd = in;
	}
	public void setPInd(String in)
	{
		pInd = Integer.valueOf(in);
	}
	
	public void setInd(int in)
	{
		ind = in;
	}
	public void setName(String n)
	{
		PopUps pop = new PopUps();
		pop.showDialog(n);
		name = n;
	}
	/**	
	 * Default constructor instantiates the rpc async service 
	 * for querying the database
	 */
	public PrintMeds() 
	{		
		rpc = PatientServiceInit.initRpc();
		uRpc = UserServiceInit.initRpc();
		printRpc = PatientServiceInit.initRpc();
		getPatientsDB();
		getUsersDB();
	}
	
	public void printPatientDB(PatientData patient)
	{
		AsyncCallback callback = new AsyncCallback()
		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Object result) {
				// TODO Auto-generated method stub
				
			}
			
		};
		printRpc.updatePatient(patient, callback);
	}
	
	public void getUsersDB()
	{
		AsyncCallback<UserData[]> callback = new AsyncCallback<UserData[]>()
		{

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(UserData[] result) {
				user = result;
				ta_doctorInfo.setText(user[ind].fName+" "+user[ind].lName + 
						"\n" + 
						user[ind].address + 
						"\n"+ 
						user[ind].city+","+user[ind].state+" "+user[ind].zip + 
						"\n" + 
						user[ind].email+ 
						"\n" +
						user[ind].phone);
				
				ta_pharmInfo.setText(user[ind].pharmacy + 
						"\n" + 
						user[ind].pharmAddress+ 
						"\n"+ 
						user[ind].pharmCity+", " +user[ind].pharmState+" " +user[ind].pharmZip);
				
				
			}
	
		};
		uRpc.getUsers(callback);
	}
	
	/**
	 * Sends an asynchronous call to the database and 
	 * populates the cell table with the results when query succeeds
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
				patient = result;
				ta_patientInfo.setText(patient[7].fName+
						" " +
						patient[7].lName+
						"\n" + 
						patient[7].address+ 
						"\n" +
						patient[7].city + ", " + patient[7].state + " " + patient[7].zip + 
						"\n" + 
						patient[7].email + 
						"\n" +
						patient[7].phone +  
						"\n" + 
						"D.O.B: "+patient[7].dateOfBirth);
				
				ta_notesReview.setText("The Presciption is as follows:\n\n\n" + patient[7].prescription+"\n________________________________\n\nPlease click the print button in the lower right hand corner to fill this patient's prescription");
				
				ta_dosageInfo.setText(patient[7].fName+
						" " +
						patient[7].lName+
						"\n" + 
						patient[7].address+ 
						"\n" +
						patient[7].city + ", " + patient[pInd].state + " " + patient[pInd].zip + 
						"\n" + 
						patient[7].email + 
						"\n" +
						patient[7].phone +  
						"\n" + 
						"D.O.B: "+patient[7].dateOfBirth+
						"\n_____________\n\n"+
						patient[7].prescription+
						"\n\n_____________");
				
				//Populates the cell table
				drawTable();
				
			}
		};
		rpc.getPatients(callback);
	}
	
	public PatientData findSelected(PatientData[] patients) 
	{
		PopUps pop = new PopUps();
		int k;
		for(k = 0; k < patients.length; k++)
		{
			if(patients[k].lName == name)
			{
				pop.showDialog(name);
				return patients[k];
			}
		}
		return null;
		
	}
	public IsWidget getPrintMedsPanel() {
		
		PopUps pop = new PopUps();
		
		//pop.showDialog(patient[1].fName + "FIRST LAST " + patient[1].lName);
		/**
		 * PATIENT INFO
		 */
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
		 * NOTES REVIEW [LEFT VERTICAL PANEL]
		 */
		//Container for red background [Design Properties]
		hp_lMainContainer.setSpacing(5);
		hp_lMainContainer.setPixelSize(325, 435);
		hp_lMainContainer.setStyleName("redBackground");
		
		//Left vertical panel containing sub-horizontal panels [Design Properties]
		vp_leftContainer.setSpacing(5);
		ta_notesReview.setPixelSize(300, 250);
		vp_leftContainer.setPixelSize(325, 435);
		lbl_notesReview.setStyleName("whiteFont");
		ta_notesReview.getElement().setAttribute("disabled", "disabled");
		
		//Add to left vertical panel
		vp_leftContainer.add(lbl_notesReview);
		vp_leftContainer.add(ta_notesReview);
		vp_leftContainer.setCellVerticalAlignment(lbl_notesReview, HasVerticalAlignment.ALIGN_BOTTOM);
		vp_leftContainer.setCellHorizontalAlignment(lbl_notesReview, HasHorizontalAlignment.ALIGN_LEFT);
		
		//Drug allergy information [Design Properties]
		ta_drugAllergies.setPixelSize(200, 100);
		img_allergyWarning.setPixelSize(100, 100);
		lbl_drugAllergies.setStyleName("whiteFont");
		img_allergyWarning.setStyleName("moveWarningSign");
		ta_drugAllergies.getElement().setAttribute("disabled", "disabled");
		
		//Add drug allergy properties to left vertical panel
		hp_drugAllergyInfo.add(img_allergyWarning);
		vp_drugAllergyInfo.add(lbl_drugAllergies);
		vp_drugAllergyInfo.add(ta_drugAllergies);
		hp_drugAllergyInfo.add(vp_drugAllergyInfo);
		hp_drugAllergyInfo.setCellVerticalAlignment(img_allergyWarning, HasVerticalAlignment.ALIGN_BOTTOM);
		hp_drugAllergyInfo.setCellHorizontalAlignment(img_allergyWarning, HasHorizontalAlignment.ALIGN_CENTER);
		
		//Add to main
		vp_leftContainer.add(hp_drugAllergyInfo);
		
		/**
		 * MEDICATION LABEL [RIGHT VERTICAL PANEL]
		 */
		//Container for red background [Design Properties]
		hp_rMainContainer.setSpacing(5);
		hp_rMainContainer.setPixelSize(325, 435);
		hp_rMainContainer.setStyleName("redBackground");
		
		//Right vertical panel containing sub-horizontal panels [Design Properties]
		vp_rightContainer.setSpacing(5);
		vp_rightContainer.setPixelSize(325, 435);
		
		//Label container for white background [Design properties]
		vp_labelContainer.setSpacing(5);
		vp_labelContainer.setStyleName("whiteBackground");
		
		//Horizontal panels for label information [Design Properties]
		hp_pharmInfo.setSpacing(5);
		btn_submit.setTitle("PRINT PRESCRIPTION");
		btn_submit.setPixelSize(80, 80);
		img_barcode.setPixelSize(38, 210);
		ta_dosageInfo.setPixelSize(150, 200);
		img_warningLabel.setPixelSize(210, 30);
		lbl_authorize.setStyleName("whiteFont");
		lbl_medicationLabel.addStyleName("whiteFont");
		
		//Add to right vertical panel
		vp_rightContainer.add(lbl_medicationLabel);
		vp_rightContainer.setCellVerticalAlignment(lbl_medicationLabel, HasVerticalAlignment.ALIGN_BOTTOM);
		
		//Pharmacy info [Hard coded for demo purposes]
		
		//Design parameters
		ta_pharmInfo.setVisibleLines(7);
		ta_pharmInfo.setCharacterWidth(18);
		img_pharmBottle.setPixelSize(80, 80);
		ta_pharmInfo.setStyleName("gwt-TextArea");
		vp_btnSubmit.setStyleName("moveSubmitBtn");
		ta_pharmInfo.getElement().setAttribute("disabled", "disabled");
		ta_dosageInfo.getElement().setAttribute("disabled", "disabled");
		
		//Add to panels
		hp_pharmInfo.add(img_pharmBottle);
		hp_pharmInfo.add(ta_pharmInfo);
		hp_pharmInfo.setCellVerticalAlignment(img_pharmBottle, HasVerticalAlignment.ALIGN_MIDDLE);
		hp_pharmInfo.setCellHorizontalAlignment(img_pharmBottle, HasHorizontalAlignment.ALIGN_CENTER);
		vp_labelContainer.add(hp_pharmInfo);
		
		hp_dosageBarcode.setSpacing(5);
		hp_dosageBarcode.add(ta_dosageInfo);
		hp_dosageBarcode.add(img_barcode);
		vp_labelContainer.add(hp_dosageBarcode);
		
		vp_labelContainer.add(img_warningLabel);
		
		//Add authorize button
		vp_btnSubmit.add(btn_submit);
		vp_btnSubmit.add(lbl_authorize);
		vp_btnSubmit.setCellVerticalAlignment(lbl_authorize, HasVerticalAlignment.ALIGN_BOTTOM);
		vp_btnSubmit.setCellHorizontalAlignment(lbl_authorize, HasHorizontalAlignment.ALIGN_CENTER);
		
		hp_labelSubmitContainer.add(vp_labelContainer);
		hp_labelSubmitContainer.add(vp_btnSubmit);
		hp_labelSubmitContainer.setCellVerticalAlignment(vp_btnSubmit, HasVerticalAlignment.ALIGN_BOTTOM);
		
		//Add to main
		vp_rightContainer.add(hp_labelSubmitContainer);
		
		//Click event
		btn_submit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				try {
					PopUps pop = new PopUps();
					
					//pop.showDialog("Prescription has been filled for "+patient[7].fName + " " + patient[7].lName);
					PatientData temp = patient[7];
					temp.prescription = " ";
					temp.status = "Filled";
					printPatientDB(temp);
					}
				catch(Exception e) {
					//Add click event exception
					}
				}
			});
		
		btn_submit.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				btn_submit.getElement().getStyle().setCursor(Cursor.POINTER);
				}
			});
		
		//Add to main
		hp_lMainContainer.add(vp_leftContainer);
		ft.setWidget(1, 0, hp_lMainContainer);
		
		//Add to main
		hp_rMainContainer.add(vp_rightContainer);
		ft.setWidget(1, 1, hp_rMainContainer);
		return ft;
	}
	
	/**
	 * Populates the cell table using the PatientData class 
	 * and the result of the query(PatientData[]) 
	 */
	public void drawTable()
	{
		
		/**
		 * CELL TABLE FIELD
		 */
		final List<PatientData> l_DummyData = Arrays.asList(patient);
		
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
		getPrintMedsPanel();
	}
}