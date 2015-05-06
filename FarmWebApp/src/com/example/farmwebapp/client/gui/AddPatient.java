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

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.example.farmwebapp.client.dbobjects.PatientData;

public class AddPatient extends MainGUI {
	private final int CELLWIDTH = 195;
	private final int CELLHEIGHT = 15;

	private DateBox db_dob = new DateBox();

	private FlexTable ft = new FlexTable();

	private TextBox tb_email = new TextBox();
	private TextBox tb_phoneNo = new TextBox();
	private TextBox tb_nameLast = new TextBox();
	private TextBox tb_nameFirst = new TextBox();
	private TextBox tb_addressZip = new TextBox();
	private TextBox tb_addressCity = new TextBox();
	private TextBox tb_addressState = new TextBox();
	private TextBox tb_addressStreet = new TextBox();

	private VerticalPanel vp = new VerticalPanel();

	private HorizontalPanel hp = new HorizontalPanel();

	private Image signUpArrowRed = new Image("/images/loginArrowRed.png");

	private final DateTimeFormat dateFormat = DateTimeFormat
			.getFormat("MM/dd/yyyy");

	// Default Constructor
	public AddPatient() {
	}

	/**
	 * @return Vertical panel containing the patient information to add as well
	 *         as the prescription info if applicable
	 */
	public IsWidget getAddPatientPanel() {
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

		/**
		 * ADD BUTTON
		 */
		ft.setWidget(4, 3, signUpArrowRed);
		signUpArrowRed.setPixelSize(25, 25);
		ft.getCellFormatter().setVerticalAlignment(4, 3,
				HasVerticalAlignment.ALIGN_BOTTOM);
		signUpArrowRed.getElement().setAttribute("align", "right");
		signUpArrowRed.setTitle("ADD PATIENT");
		ft.getElement().setAttribute("cellpadding", "10");
		/**
		 * Send RPC call
		 */
		signUpArrowRed.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HTML s_DBData;
				try {
					s_DBData = new HTML("User Type: Patient" + "<br>Name: "
							+ tb_nameFirst.getText() + ","
							+ tb_nameLast.getText() + "<br>Address: "
							+ tb_addressStreet.getText() + "<br>City: "
							+ tb_addressCity.getText() + "<br>State: "
							+ tb_addressState.getText() + "<br>Zip: "
							+ tb_addressZip.getText() + "<br>Email: "
							+ tb_email.getText() + "<br>Date of Birth: "
							+ db_dob.getValue());
					PopUps popups = new PopUps();
					popups.showDialog("Patient added to the DB:\r\n" + s_DBData);
				} catch (Exception e) {
				}
			}
		});

		/**
		 * Change mouse to pointer to indicate the arrow is a button
		 */
		signUpArrowRed.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				signUpArrowRed.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		});

		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.getElement().setAttribute("cellpadding", "10");

		// Add all components to the vertical panel to be added to the root
		vp.add(ft);
		vp.add(hp);

		return vp;
	}

	protected void insertIntoDB(PatientData patient2) {
		super.insertIntoDB(patient2);

	}

	protected String generateNewPatient() {
		PatientData patients[] = super.getPatientsDB(1);
		// int temp =
		// Integer.parseInt(patients[patients.length-1].pID.substring(8, 10));
		// temp++;

		return "P0000000";// +temp;
	}
}