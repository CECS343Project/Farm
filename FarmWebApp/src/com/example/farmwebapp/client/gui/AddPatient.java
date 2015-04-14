/**
 * AddPatient
 * Gui component for adding a patient into the database
 * Once the button is clicked, an asynchronous call is 
 * made to the server which will insert the record into the database 
 * 
 * @author Napoleon Fulinara Jr.
 * @author Russell Tan
 */
package com.example.farmwebapp.client.gui;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.datepicker.client.DateBox;

public class AddPatient 
{
	private final int CELLWIDTH = 150;
	private final int CELLHEIGHT = 15;
	private final DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
	
	private PrescriptionInfo addPrescrip = new PrescriptionInfo();

	private FlexTable ft = new FlexTable();

	private TextBox tb_dob = new TextBox();
	private TextBox tb_email = new TextBox();
	private TextBox tb_phoneNo = new TextBox();
	private TextBox tb_nameLast = new TextBox();
	private TextBox tb_licenseNo = new TextBox();
	private TextBox tb_nameFirst = new TextBox();
	private TextBox tb_nameSuffix = new TextBox();
	private TextBox tb_addressStreet = new TextBox();
	private TextBox tb_addressCityStateZip = new TextBox();
	
	private ListBox lb_nameSuffix = new ListBox();
	
	private DateBox db_dob = new DateBox();
	private Image signUpArrow = new Image("/images/loginArrow.png");
	
	private VerticalPanel vp = new VerticalPanel();
	private HorizontalPanel hp = new HorizontalPanel();

	//Default Constructor
	public AddPatient(){}

	/**
	 * @return Vertical panel containing the patient information to add
	 * as well as the prescription info if applicable
	 */
	public IsWidget getAddPatientPanel() {
		/**
		 * NAME FIELD
		 */
		ft.setText(0, 0, "NAME");
		ft.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(0, 1, tb_nameFirst);
		tb_nameFirst.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(0, 2, tb_nameLast);
		tb_nameLast.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		lb_nameSuffix.addItem("   ");
		lb_nameSuffix.addItem("Jr.");
		lb_nameSuffix.addItem("Sr.");
		
		ft.setWidget(0, 3, lb_nameSuffix);
		tb_nameSuffix.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * ADDRESS FIELD
		 */
		ft.setText(1, 0, "ADDRESS");
		ft.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 1, tb_addressStreet);
		tb_addressStreet.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(2, 1, tb_addressCityStateZip);
		tb_addressCityStateZip.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_addressCityStateZip.setTitle("City, State, Zip");

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
		
		/**
		 * PHONE NUMBER FIELD
		 */
		ft.setText(2, 2, "PHONE NUMBER");
		ft.getCellFormatter().setVerticalAlignment(2, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(2, 3, tb_phoneNo);
		tb_phoneNo.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		/**
		 * Restricts box to only accept numbers
		 */
		tb_phoneNo.addKeyPressHandler(new KeyPressHandler() {

		      public void onKeyPress(KeyPressEvent event) {
		        if (!Character.isDigit(event.getCharCode())) {
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
		
		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.getElement().setAttribute("cellpadding", "10");
		
		/**
		 * On button click - send data to database
		 */
		addPrescrip.getSignUpArrow().addClickHandler(new ClickHandler() 
		{
	        public void onClick(ClickEvent event) 
	        {
	        	HTML s_DBData;
	        	try
	        	{
	        		s_DBData = new HTML("User Type: Patient"
	        				+"<br>Name: " + tb_nameFirst.getText() + "," + tb_nameLast.getText() + ", " + lb_nameSuffix.getSelectedItemText()
	        				+ "<br>Address: " + tb_addressStreet.getText() + " City, State, Zip: " + tb_addressCityStateZip.getText()
	        				+ "<br>Email: " + tb_email.getText()
	        				+ "<br>Date of Birth: " + db_dob.getValue()
	        				+ "<br>License Number: " + tb_licenseNo.getText()
	        				+ "<br>PRESCRIPTION INFORMATION"
	        				+ "<br>"+addPrescrip.getPrescriptionInstructions());
	        		
	        		//s_DBData += new HTML();
	        		
		            PopUps popups = new PopUps();
		            popups.showDialog("Patient to add to the DB:\r\n"  + s_DBData);
	        	}
	        	catch(Exception e)
	        	{	        		
	        	}
	        }
	    });
		
		/**
		 * LOGIN BUTTON
		 */
		ft.setWidget(4, 3, signUpArrow);
		signUpArrow.setPixelSize(25, 25);
		ft.getCellFormatter().setVerticalAlignment(4, 3, HasVerticalAlignment.ALIGN_BOTTOM);
		signUpArrow.getElement().setAttribute("align", "right");
		ft.getElement().setAttribute("cellpadding", "10");
		
		/**
		 * Send RPC call
		 */
		signUpArrow.addClickHandler(new ClickHandler() 
		{
	        public void onClick(ClickEvent event) 
	        {
	        	try
	        	{
		            PopUps popups = new PopUps();
		            popups.showDialog("Patient Added!");
	        	}
	        	catch(Exception e)
	        	{
	        		
	        	}
	        }

		
	    });
		/**
		 * Change mouse to pointer to indicate the arrow is a button
		 */
		signUpArrow.addMouseOverHandler(new MouseOverHandler()
		{

			@Override
			public void onMouseOver(MouseOverEvent event) 
			{
				signUpArrow.getElement().getStyle().setCursor(Cursor.POINTER);
				
			}
			
		});
		
		//Add all components to the vertical panel to be added to the root
		vp.add(ft);
		vp.add(hp);
		
		return vp;
	}
}