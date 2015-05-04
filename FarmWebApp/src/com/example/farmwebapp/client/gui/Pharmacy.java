/**
 * 
 * 
 * 
 * 
 * 
 * 
 */
package com.example.farmwebapp.client.gui;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class Pharmacy extends MainGUI
{	
	private FlexTable ft = new FlexTable();
	private HorizontalPanel hp = new HorizontalPanel();
	
	private Image logout = new Image("/images/logout.png");
	private Image divider = new Image("/images/divider.png");
	private Image settings = new Image("/images/settings.png");
	private Image addPatient = new Image("/images/addPatient.png");
	private Image findPatient = new Image("/images/findPatient.png");
	private Image pillBugLogo = new Image("/images/pillBugLogo.png");
	private Image updatePharmacy = new Image("/images/updatePharmacy.png");

	//Default Constructor
	public Pharmacy(){}

	public IsWidget getPharmacyPanel() 
	{
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
		addPatient.setTitle("Add a patient");
		addPatient.addMouseOverHandler(new MouseOverHandler()
		{
			public void onMouseOver(MouseOverEvent event) 
			{
				addPatient.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});
		addPatient.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) 
			{
				setSelectedIndex(1);
			}
			
		});
		/**
		 * FIND PATIENT
		 */
		ft.setWidget(0, 1, findPatient);
		findPatient.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_BOTTOM);
		findPatient.setTitle("Search patient database");
		findPatient.addMouseOverHandler(new MouseOverHandler()
		{
			public void onMouseOver(MouseOverEvent event) 
			{
				findPatient.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});
		findPatient.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) 
			{
				setSelectedIndex(2);
			}
			
		});
		/**
		 * UPDATE
		 */
		ft.setWidget(0, 2, updatePharmacy);
		updatePharmacy.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_BOTTOM);
		updatePharmacy.setTitle("Check for updated prescriptions");
		updatePharmacy.addMouseOverHandler(new MouseOverHandler()
		{
			public void onMouseOver(MouseOverEvent event) 
			{
				updatePharmacy.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});
		updatePharmacy.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) 
			{
				setSelectedIndex(3);
			}
			
		});
		/**
		 * SETTINGS
		 */
		ft.setWidget(0, 3, settings);
		settings.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		settings.setTitle("Change application settings");
		settings.addMouseOverHandler(new MouseOverHandler()
		{
			public void onMouseOver(MouseOverEvent event) 
			{
				settings.getElement().getStyle().setCursor(Cursor.POINTER);	
			}
		});
		settings.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) 
			{
				setSelectedIndex(4);
			}
			
		});
		/**
		 * LOGOUT
		 */
		ft.setWidget(0, 4, logout);
		logout.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 3, HasVerticalAlignment.ALIGN_BOTTOM);
		logout.setTitle("Logout");
		logout.addMouseOverHandler(new MouseOverHandler()
		{
			public void onMouseOver(MouseOverEvent event) 
			{
				logout.getElement().getStyle().setCursor(Cursor.POINTER);
			}
			
		});
		logout.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) 
			{
				logout();
			}
			
		});
		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.addStyleName("signInPasswordTextBoxes");
		ft.getElement().setAttribute("cellpadding", "5");
		
		hp.add(ft);
		return hp;
	}

	protected void setSelectedIndex(int i) 
	{
		super.refreshUI("pharmacist", i);
		
	}
	protected void logout()
	{
		super.refreshUI("null");
	}
}
