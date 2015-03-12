package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

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

	private VerticalPanel vp = new VerticalPanel();
	private HorizontalPanel hp = new HorizontalPanel();
	private HorizontalPanel hp_profession = new HorizontalPanel();

	private Image signUpArrow = new Image("/images/loginArrow.png");

	private RadioButton rb_doctor = new RadioButton("signUp", "DOCTOR");
	private RadioButton rb_pharmacist = new RadioButton("signUp", "PHARMACIST");

	public IsWidget getSignUpPanel() {
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
		ft.setText(0, 0, "NAME");
		ft.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(0, 1, tb_nameFirst);
		tb_nameFirst.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(0, 2, tb_nameLast);
		tb_nameLast.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(0, 3, tb_nameSuffix);
		tb_nameSuffix.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * USERNAME FIELD
		 */
		ft.setText(1, 0, "USERNAME");
		ft.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 1, tb_username);
		tb_username.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(2, 1, tb_usernameConfirm);
		tb_usernameConfirm.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * PASSWORD FIELD
		 */
		ft.setText(3, 0, "PASSWORD");
		ft.getCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 1, ptb_password);
		ptb_password.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(4, 1, ptb_passwordConfirm);
		ptb_passwordConfirm.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * DATE OF BIRTH FIELD
		 */
		ft.setText(5, 0, "DATE OF BIRTH");
		ft.getCellFormatter().setVerticalAlignment(5, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(5, 1, tb_dob);
		tb_dob.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * EMAIL FIELD
		 */
		ft.setText(1, 2, "EMAIL");
		ft.getCellFormatter().setVerticalAlignment(1, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 3, tb_email);
		tb_email.setPixelSize(CELLWIDTH, CELLHEIGHT);

		ft.setWidget(2, 3, tb_emailConfirm);
		tb_emailConfirm.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * PHONE NUMBER FIELD
		 */
		ft.setText(3, 2, "PHONE NUMBER");
		ft.getCellFormatter().setVerticalAlignment(4, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 3, tb_phoneNo);
		tb_phoneNo.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * LICENSE NUMBER
		 */
		ft.setText(4, 2, "LICENSE NUMBER");
		ft.getCellFormatter().setVerticalAlignment(3, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(4, 3, tb_licenseNo);
		tb_licenseNo.setPixelSize(CELLWIDTH, CELLHEIGHT);

		/**
		 * SIGN UP BUTTON
		 */
		ft.setWidget(5, 3, signUpArrow);
		signUpArrow.setPixelSize(25, 25);
		ft.getCellFormatter().setVerticalAlignment(5, 3, HasVerticalAlignment.ALIGN_BOTTOM);
		signUpArrow.getElement().setAttribute("align", "right");
		
		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.getElement().setAttribute("cellpadding", "10");

		vp.add(hp);
		vp.add(ft);
		return vp;
	}
}
