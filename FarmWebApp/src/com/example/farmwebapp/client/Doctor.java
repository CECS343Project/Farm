package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class Doctor {
	
	private FlexTable ft = new FlexTable();
	private HorizontalPanel hp = new HorizontalPanel();
	
	private Image logout = new Image("/images/logout.png");
	private Image divider = new Image("/images/divider.png");
	private Image settings = new Image("/images/settings.png");
	private Image addPatient = new Image("/images/addPatient.png");
	private Image findPatient = new Image("/images/findPatient.png");
	private Image pillBugLogo = new Image("/images/pillBugLogo.png");
	
	public IsWidget getDoctorPanel() {
		/**
		 * LOGO
		 * SIGN-IN ATTRIBUTES
		 */
		pillBugLogo.addStyleName("pillBugLogo");
		hp.addStyleName("signInPlacement");
		hp.setPixelSize(700, 440);
		hp.add(pillBugLogo);
		
		/**
		 * DIVIDER
		 */
		divider.addStyleName("divider");
		hp.add(divider);
		
		/**
		 * ADD PATIENT
		 */
		ft.setWidget(0, 0, addPatient);
		addPatient.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		
		/**
		 * FIND PATIENT
		 */
		ft.setWidget(0, 1, findPatient);
		findPatient.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_BOTTOM);
		
		/**
		 * SETTINGS
		 */
		ft.setWidget(0, 2, settings);
		settings.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		
		/**
		 * LOGOUT
		 */
		ft.setWidget(0, 3, logout);
		logout.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 3, HasVerticalAlignment.ALIGN_BOTTOM);
		
		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.addStyleName("signInPasswordTextBoxes");
		ft.getElement().setAttribute("cellpadding", "13");
		
		hp.add(ft);
		return hp;
	}
}
