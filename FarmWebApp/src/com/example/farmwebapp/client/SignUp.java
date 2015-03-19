package com.example.farmwebapp.client;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.datepicker.client.DateBox;

public class SignUp {
	private final int CELLWIDTH = 150;
	private final int CELLHEIGHT = 15;

	private FlexTable ft = new FlexTable();

	private TextBox tb_dob = new TextBox();
	private TextBox tb_email = new TextBox();
	private TextBox tb_phoneNo = new TextBox();
	private TextBox tb_username = new TextBox();
	private TextBox tb_nameLast = new TextBox();
	private TextBox tb_licenseNo = new TextBox();
	private TextBox tb_nameFirst = new TextBox();
	private TextBox tb_nameSuffix = new TextBox();
	private TextBox tb_emailConfirm = new TextBox();
	private TextBox tb_usernameConfirm = new TextBox();
	private PasswordTextBox ptb_password = new PasswordTextBox();
	private PasswordTextBox ptb_passwordConfirm = new PasswordTextBox();
	
	
	private ListBox lb_namePrefix = new ListBox();
	private ListBox lb_nameSuffix = new ListBox();
	
	private final DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
	private DateBox db_dob = new DateBox();
	
	private HorizontalPanel hp_prefixContainer = new HorizontalPanel();
	private VerticalPanel vp = new VerticalPanel();
	private HorizontalPanel hp = new HorizontalPanel();
	private HorizontalPanel hp_profession = new HorizontalPanel();

	private Image signUpArrow = new Image("/images/loginArrow.png");

	private RadioButton rb_doctor = new RadioButton("signUp", "DOCTOR");
	private RadioButton rb_pharmacist = new RadioButton("signUp", "PHARMACIST");

	@SuppressWarnings("deprecation")
	public IsWidget getSignUpPanel() {
		
		rb_doctor.setChecked(true);
		/**
		 * PROFESSION RADIO BUTTONS
		 */
		hp_profession.add(rb_doctor);
		hp_profession.add(rb_pharmacist);
		hp_profession.getElement().setAttribute("cellpadding", "5");
		vp.add(hp_profession);

		/**
		 * NAME FIELD
		 */
		
		lb_nameSuffix.addItem("   ");
		lb_nameSuffix.addItem("Jr.");
		lb_nameSuffix.addItem("Sr.");
		
		hp_prefixContainer.add(lb_namePrefix);
		hp_prefixContainer.add(tb_nameFirst);
		
		ft.setText(0, 0, "NAME");
		ft.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(0, 1, tb_nameFirst);
		tb_nameFirst.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_nameFirst.setTitle("First");
		
		ft.setWidget(0, 2, tb_nameLast);
		tb_nameLast.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_nameLast.setTitle("Last");
		
		ft.setWidget(0, 3, lb_nameSuffix);
		tb_nameSuffix.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * USERNAME FIELD
		 */
		ft.setText(1, 0, "USERNAME");
		ft.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 1, tb_username);
		tb_username.setPixelSize(CELLWIDTH, CELLHEIGHT);

		//ft.setWidget(2, 1, tb_usernameConfirm);
		//tb_usernameConfirm.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * PASSWORD FIELD
		 */
		ft.setText(3, 0, "PASSWORD");
		ft.getCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 1, ptb_password);
		ptb_password.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(4, 1, ptb_passwordConfirm);
		ptb_passwordConfirm.setPixelSize(CELLWIDTH, CELLHEIGHT);
		ptb_passwordConfirm.setTitle("Confirm Password");
				
		ptb_passwordConfirm.addKeyDownHandler(new KeyDownHandler(){

			@Override
			public void onKeyDown(KeyDownEvent event) {
				String originalPassword = ptb_password.getText();
				
				if(originalPassword != ptb_passwordConfirm.getText())
				{
					ptb_passwordConfirm.setStyleName("incorrectvalidator");
				}
				else if(originalPassword == ptb_passwordConfirm.getText())
				{
					ptb_passwordConfirm.setStyleName("correctvalidator");
				}
						
			}
		});

		/**
		 * DATE OF BIRTH FIELD
		 */
		db_dob.setFormat(new DateBox.DefaultFormat(dateFormat));
		ft.setText(5, 0, "DATE OF BIRTH");
		ft.getCellFormatter().setVerticalAlignment(5, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(5, 1, db_dob);
		tb_dob.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * EMAIL FIELD
		 */
		ft.setText(1, 2, "EMAIL");
		ft.getCellFormatter().setVerticalAlignment(1, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.getCellFormatter().setHorizontalAlignment(1, 2, HasHorizontalAlignment.ALIGN_RIGHT);
		ft.setWidget(1, 3, tb_email);
		tb_email.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(2, 3, tb_emailConfirm);
		tb_emailConfirm.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_emailConfirm.setTitle("Confirm Email");
			
		tb_emailConfirm.addKeyDownHandler(new KeyDownHandler(){

			@Override
			public void onKeyDown(KeyDownEvent event) {
				String originalEmail = tb_email.getText();
				
				if(originalEmail != tb_emailConfirm.getText())
				{
					tb_emailConfirm.setStyleName("incorrectvalidator");
				}
				else if(originalEmail == tb_emailConfirm.getText())
				{
					tb_emailConfirm.setStyleName("correctValidator");
				}
						
			}
		});
		/**
		 * PHONE NUMBER FIELD
		 */
		ft.setText(3, 2, "PHONE NUMBER");
		ft.getCellFormatter().setVerticalAlignment(4, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.getCellFormatter().setHorizontalAlignment(4, 2, HasHorizontalAlignment.ALIGN_RIGHT);		
		ft.setWidget(3, 3, tb_phoneNo);
		tb_phoneNo.setPixelSize(CELLWIDTH, CELLHEIGHT);
		tb_phoneNo.setTitle("xxx-xxx-xxxx");
		
		

		/**
		 * LICENSE NUMBER
		 */
		ft.setText(4, 2, "LICENSE NUMBER");
		ft.getCellFormatter().setVerticalAlignment(3, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.getCellFormatter().setHorizontalAlignment(3, 2, HasHorizontalAlignment.ALIGN_RIGHT);		
		ft.setWidget(4, 3, tb_licenseNo);
		tb_licenseNo.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * SIGN UP BUTTON
		 */
		ft.setWidget(5, 3, signUpArrow);
		signUpArrow.setPixelSize(25, 25);
		ft.getCellFormatter().setVerticalAlignment(5, 3, HasVerticalAlignment.ALIGN_BOTTOM);
		signUpArrow.getElement().setAttribute("align", "right");
		signUpArrow.addClickHandler(new ClickHandler() 
		{
	        public void onClick(ClickEvent event) 
	        {
	        	HTML s_DBData;
	        	String s_SelectedProfession = "not sected";
	        	
	        	if(rb_doctor.getValue()) s_SelectedProfession = "Doctor";
	        	if(rb_pharmacist.getValue()) s_SelectedProfession = "Pharmacist";
	        	try
	        	{
	        		s_DBData = new HTML("User Type: " + s_SelectedProfession
	        				+"<br>Name: " + tb_nameFirst.getText() + "," + tb_nameLast.getText() + ", " + lb_nameSuffix.getSelectedItemText()
	        				+ "<br>User name: " + tb_username.getText() + " Password: " + ptb_password.getText()
	        				+ "<br>Email: " + tb_email.getText()
	        				+ "<br>Date of Birth: " + db_dob.getValue()
	        				+ "<br>Phone Number: " + tb_phoneNo.getText()
	        				+ "<br>License Number: " + tb_licenseNo.getText());
		            PopUps popups = new PopUps();
		            popups.showDialog("Data sent to DB:\r\n"  + s_DBData);
	        	}
	        	catch(Exception e)
	        	{
	        		
	        	}
	        }

		
	    });
		signUpArrow.addMouseOverHandler(new MouseOverHandler()
		{

			@Override
			public void onMouseOver(MouseOverEvent event) 
			{
				signUpArrow.getElement().getStyle().setCursor(Cursor.POINTER);
				
			}
			
		});
		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.getElement().setAttribute("cellpadding", "10");

		vp.add(hp);
		vp.add(ft);
		return vp;
	}
}
