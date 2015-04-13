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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class SignIn 
{
	private final int CELLWIDTH = 200;
	private final int CELLHEIGHT = 15;
	private FlexTable ft = new FlexTable();
	private TextBox tb_userName = new TextBox();
	private HorizontalPanel hp = new HorizontalPanel();
	private PasswordTextBox ptb_password = new PasswordTextBox();
	
	private Image divider = new Image("/images/divider.png");
	private Image loginArrow = new Image("/images/loginArrow.png");
	private Image pillBugLogo = new Image("/images/pillBugLogo.png");
	
	private CheckBox cb_showPassword = new CheckBox("Show Password");

	//Default Constructor
	public SignIn() {}

	public IsWidget getSignInPanel() {
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
		 * USERNAME FIELD
		 */
		ft.setText(0, 0, "USERNAME");
		ft.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(0, 1, tb_userName);
		tb_userName.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		/**
		 * PASSWORD FIELD
		 */
		ft.setText(1, 0, "PASSWORD");
		ft.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ft.setWidget(1, 1, ptb_password);
		ptb_password.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		/**
		 * SHOW PASSWORD
		 */
		ft.setWidget(2, 1, cb_showPassword);
		ft.getCellFormatter().setVerticalAlignment(2, 1, HasVerticalAlignment.ALIGN_BOTTOM);
		cb_showPassword.getElement().setAttribute("align", "left");
		cb_showPassword.addStyleName("showPassword");
		cb_showPassword.addClickHandler(new ClickHandler() 
		 {
		      public void onClick(ClickEvent event) 
		      {
		        boolean checked = ((CheckBox) event.getSource()).getValue();
		        if(checked)
		        {
		        	ptb_password.getElement().setAttribute("type", "text");
		        }
		        else
		        {
		        	ptb_password.getElement().setPropertyString("type", "password");
		        }
		        }
		      });
		/**
		 * LOGIN BUTTON
		 */
		ft.setWidget(3, 1, loginArrow);
		loginArrow.setPixelSize(25, 25);
		ft.getCellFormatter().setVerticalAlignment(3, 1, HasVerticalAlignment.ALIGN_BOTTOM);
		loginArrow.getElement().setAttribute("align", "right");
		ft.getElement().setAttribute("cellpadding", "10");
		loginArrow.addClickHandler(new ClickHandler() 
		{
	        public void onClick(ClickEvent event) 
	        {
	        	try
	        	{
		            PopUps popups = new PopUps();
		            popups.showDialog("Welcome "  + tb_userName.getText() + "!");
	        	}
	        	catch(Exception e)
	        	{
	        	}
	        }
	    });
		loginArrow.addMouseOverHandler(new MouseOverHandler()
		{
			@Override
			public void onMouseOver(MouseOverEvent event) 
			{
				loginArrow.getElement().getStyle().setCursor(Cursor.POINTER);
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
}
