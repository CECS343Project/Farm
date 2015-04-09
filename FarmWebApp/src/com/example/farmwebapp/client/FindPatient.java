package com.example.farmwebapp.client;

import java.util.List;
import java.util.Arrays;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.cellview.client.*;

public class FindPatient {
	private final int CELLWIDTH = 150;
	private final int CELLHEIGHT = 15;

	private FlexTable ft = new FlexTable();
	private TextBox tb_dob = new TextBox();
	private TextBox tb_email = new TextBox();
	private TextBox tb_phoneNo = new TextBox();
	private TextBox tb_nameLast = new TextBox();
	private TextBox tb_licenseNo = new TextBox();
	private TextBox tb_nameFirst = new TextBox();
	private ListBox lb_nameSuffix = new ListBox();
	private TextBox tb_nameSuffix = new TextBox();
	private TextBox tb_addressStreet = new TextBox();
	private TextBox tb_addressCityStateZip = new TextBox();
	private CellTable<String> ct_Results = new CellTable<String>();
	
	private VerticalPanel vp = new VerticalPanel();
	private HorizontalPanel hp = new HorizontalPanel();

	public IsWidget getFindPatientPanel() {
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

		/**
		 * DATE OF BIRTH FIELD
		 */
		ft.setText(3, 0, "DATE OF BIRTH");
		ft.getCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 1, tb_dob);
		tb_dob.setPixelSize(CELLWIDTH, CELLHEIGHT);

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
		 * LICENSE NUMBER
		 */
		ft.setText(3, 2, "LICENSE NUMBER");
		ft.getCellFormatter().setVerticalAlignment(3, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(3, 3, tb_licenseNo);
		tb_licenseNo.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.getElement().setAttribute("cellpadding", "10");
		
		/**
		 * CELL TABLE FIELD
		 */
		final List<String> l_DummyData = Arrays.asList
				(
						"1",
						"2"
				);
		
		TextColumn<String> tc_Name = new TextColumn<String>()
		{

			@Override
			public String getValue(String object) {
				// TODO Auto-generated method stub
				return "Russell Tyler Tan";
			}				
		};
		TextColumn<String> tc_Address = new TextColumn<String>()
		{

			@Override
			public String getValue(String object) {
				// TODO Auto-generated method stub
				return "3131 ShadyPark Drive, Long Beach CA 90808";
			}				
		};
		TextColumn<String> tc_Email = new TextColumn<String>()
		{

			@Override
			public String getValue(String object) {
				// TODO Auto-generated method stub
				return "test@thejoejack.com";
			}				
		};
		TextColumn<String> tc_PhoneNumber = new TextColumn<String>()
		{

			@Override
			public String getValue(String object) {
				// TODO Auto-generated method stub
				return "562-867-5309";
			}				
		};
		TextColumn<String> tc_DOB = new TextColumn<String>()
		{

			@Override
			public String getValue(String object) {
				// TODO Auto-generated method stub
				return "01/01/1995";
			}				
		};
		TextColumn<String> tc_LicenseNo = new TextColumn<String>()
		{

			@Override
			public String getValue(String object) {
				// TODO Auto-generated method stub
				return "6541681351681";
			}				
		};		
		ct_Results.addColumn(tc_Name, "Name");
		ct_Results.addColumn(tc_Address, "Address");
		ct_Results.addColumn(tc_Email, "Email");
		ct_Results.addColumn(tc_PhoneNumber, "PhoneNumber");
		ct_Results.addColumn(tc_DOB, "Date of Birth");
		ct_Results.addColumn(tc_LicenseNo, "License Number");		
		ct_Results.setRowCount(2,true);
		ct_Results.setRowData(l_DummyData);
		
		hp.add(ct_Results);
		
		vp.add(ft);
		vp.add(hp);
		
		return vp;
	}
}