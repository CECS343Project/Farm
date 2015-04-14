package com.example.farmwebapp.client.gui;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class PrintMeds {
	private FlexTable ft = new FlexTable();
	
	private HorizontalPanel hp_doctorInfo = new HorizontalPanel();
	private HorizontalPanel hp_patientInfo = new HorizontalPanel();
	private HorizontalPanel hp_pharmacyInfo = new HorizontalPanel();
	private HorizontalPanel hp_drugAllergies = new HorizontalPanel();
	private HorizontalPanel hp_prescriptionDetails = new HorizontalPanel();
	private HorizontalPanel hp_printPrescriptionContainer = new HorizontalPanel();
	private HorizontalPanel hp_prescriptionLabelContainer = new HorizontalPanel();
	private HorizontalPanel hp_warningLabels = new HorizontalPanel();
	
	private Image btn_submit = new Image("/images/submit.png");
	private Image img_warning = new Image("/images/warning.png");
	private Image img_patientInfo = new Image("/images/patient.png");
	private Image img_doctorInfo = new Image("/images/stethoscope.png");
	private Image img_pharmBottle = new Image("/images/pharmBottle.png");
	private Image btn_addMedications = new Image("/images/loginArrow.png");
	private Image img_warningLabel = new Image("/images/warningLabelNew.png");
	
	private Label lbl_doctorNotes = new Label("DOCTOR NOTES");
	private Label lbl_drugAllergies = new Label("DRUG ALLERGIES");
	private Label lbl_prescription = new Label("PRESCRIPTION");
	private Label lbl_authorize = new Label("AUTHORIZE");
	
	private TextArea ta_pharmInfo = new TextArea();
	private TextArea ta_doctorInfo = new TextArea();
	private TextArea ta_patientInfo = new TextArea();
	private TextArea ta_doctorNotes = new TextArea();
	private TextArea ta_drugAllergyWarning = new TextArea();
	private TextArea ta_prescriptionDetails = new TextArea();
	
	private VerticalPanel vp_printPrescription = new VerticalPanel();
	private VerticalPanel vp_doctorNotes = new VerticalPanel();
	private VerticalPanel vp_drugAllergies = new VerticalPanel();
	private VerticalPanel vp_submit = new VerticalPanel();
	
	public IsWidget getPrintMedsPanel() {
		/**
		 * PATIENT INFO FIELD
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
		 * DOCTOR INFO FIELD
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
		 * DOCTOR NOTES
		 */
		vp_doctorNotes.add(lbl_doctorNotes);
		
		//Design parameters
		ta_doctorNotes.setPixelSize(325, 245);
		//Add to panels
		vp_doctorNotes.add(ta_doctorNotes);
		
		/**
		 * ADD MEDICATION BUTTON
		 */
		//Design parameters
		btn_addMedications.setPixelSize(25, 25);
		btn_addMedications.setStyleName("moveMedArrow");
		btn_addMedications.getElement().setAttribute("align", "right");
		vp_doctorNotes.add(btn_addMedications);
		
		//Click event
		btn_addMedications.addClickHandler(new ClickHandler() {
	        public void onClick(ClickEvent event) {
	        	try {
		            //Add click event
	        	}
	        	catch(Exception e) {
	        		//Add click event exception
	        	}
	        }
	    });
		
		btn_addMedications.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				btn_addMedications.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});
		
		/**
		 * DRUG ALLERGIES FIELD
		 */
		//Design parameters
		img_warning.setPixelSize(100, 100);
		//Add to panels
		hp_drugAllergies.add(img_warning);
		hp_drugAllergies.setCellVerticalAlignment(img_warning, HasVerticalAlignment.ALIGN_BOTTOM);
		
		//Design parameters
		//Add to panels
		vp_drugAllergies.add(lbl_drugAllergies);
		
		//Design parameters
		ta_drugAllergyWarning.setVisibleLines(8);
		ta_drugAllergyWarning.setCharacterWidth(42);
		ta_drugAllergyWarning.setStyleName("gwt-TextArea");
		//Add to panels
		vp_drugAllergies.add(ta_drugAllergyWarning);
		hp_drugAllergies.add(vp_drugAllergies);
		vp_doctorNotes.add(hp_drugAllergies);
		ft.setWidget(1, 0, vp_doctorNotes);
		
		/**
		 * PRESCRIPTION INFORMATION
		 */
		//Design parameters
		//Add to panels
		vp_printPrescription.add(lbl_prescription);
		
		//Design parameters
		img_pharmBottle.setPixelSize(100, 100);
		//Add to panels
		hp_pharmacyInfo.add(img_pharmBottle);
		
		//Hard coded information for demo purposes
		ta_pharmInfo.setText("Pharmacy Name" + "\n" + "727 W 7th St. Unit 1113" + "\n" 
				+ "Los Angeles, Ca 90017" + "\n" + "(858) 216-5155" );
		//Design parameters
		ta_pharmInfo.setVisibleLines(7);
		ta_pharmInfo.setCharacterWidth(23);
		ta_pharmInfo.setStyleName("gwt-TextArea");
		ta_pharmInfo.getElement().setAttribute("disabled", "disabled");
		//Add to panels
		hp_pharmacyInfo.add(ta_pharmInfo);
		vp_printPrescription.add(hp_pharmacyInfo);
		
		ta_prescriptionDetails.setPixelSize(230, 272);
		ta_prescriptionDetails.setVisibleLines(15);
		ta_prescriptionDetails.setCharacterWidth(23);
		
		hp_prescriptionDetails.add(ta_prescriptionDetails);
		vp_printPrescription.add(hp_prescriptionDetails);
		
		img_warningLabel.setPixelSize(240, 32);
		vp_printPrescription.add(img_warningLabel);
		
		//ADD BARCODE
		
		hp_printPrescriptionContainer.add(vp_printPrescription);
		
		lbl_authorize.addStyleName("whiteFont");
		vp_submit.add(btn_submit);
		vp_submit.add(lbl_authorize);
		vp_submit.setCellVerticalAlignment(lbl_authorize, HasVerticalAlignment.ALIGN_MIDDLE);
		vp_submit.setCellHorizontalAlignment(lbl_authorize, HasHorizontalAlignment.ALIGN_CENTER);
		
		hp_printPrescriptionContainer.add(vp_submit);
		hp_printPrescriptionContainer.setCellVerticalAlignment(vp_submit, HasVerticalAlignment.ALIGN_BOTTOM);
		hp_printPrescriptionContainer.setCellHorizontalAlignment(vp_submit, HasHorizontalAlignment.ALIGN_CENTER);
		hp_prescriptionLabelContainer.add(hp_printPrescriptionContainer);
		
		//Click event
		btn_submit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				try {
					//Add click event
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
		
		ft.setWidget(1, 1, hp_prescriptionLabelContainer);
		ft.getCellFormatter().setHorizontalAlignment(1, 1, HasHorizontalAlignment.ALIGN_LEFT);
		ft.getCellFormatter().setVerticalAlignment(1, 1, HasVerticalAlignment.ALIGN_TOP);
		
		return ft;
	}
}