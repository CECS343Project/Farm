package com.example.farmwebapp.client.gui;

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
	
	private Label lbl_searchField = new Label("SEARCH");
	
	private TextArea ta_doctorInfo = new TextArea();
	private TextArea ta_patientInfo = new TextArea();
	
	private TextBox tb_searchField = new TextBox();
	private VerticalPanel vp_leftContainer = new VerticalPanel();
	
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
		 * SEARCH MEDICATIONS
		 */
		img_pillBottle.setPixelSize(100, 100);
		hp_searchField.setSpacing(5);
		hp_lMainContainer.setSpacing(5);
		tb_searchField.setPixelSize(160, 15);
		vp_leftContainer.setPixelSize(335, 435);
		hp_lMainContainer.setPixelSize(335, 435);
		lbl_searchField.addStyleName("whiteFont");
		hp_lMainContainer.setStyleName("redBackground");
		
		hp_searchField.add(lbl_searchField);
		hp_searchField.add(tb_searchField);
		hp_searchField.setCellVerticalAlignment(lbl_searchField, HasVerticalAlignment.ALIGN_BOTTOM);
		
		vp_leftContainer.add(hp_searchField);
		vp_leftContainer.setCellHorizontalAlignment(hp_searchField, HasHorizontalAlignment.ALIGN_RIGHT);
		
		hp_searchResults.add(img_pillBottle);
		hp_searchResults.setCellVerticalAlignment(hp_searchResults, HasVerticalAlignment.ALIGN_TOP);
		vp_leftContainer.add(hp_searchResults);
		
		hp_lMainContainer.add(vp_leftContainer);
		ft.setWidget(1, 0, hp_lMainContainer);
		
		return ft;
	}
}