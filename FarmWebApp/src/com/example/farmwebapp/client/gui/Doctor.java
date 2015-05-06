/**
 * Doctor
 * Gui for the doctor after login
 * contains the necessary buttons for a user of type doctor 
 * 
 * @author Napoleon Fulinara Jr.
 * @author Russell Tan
 */
package com.example.farmwebapp.client.gui;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class Doctor extends MainGUI {

	private FlexTable ft = new FlexTable();
	private HorizontalPanel hp = new HorizontalPanel();

	private Image logout = new Image("/images/logout.png");
	private Image divider = new Image("/images/divider.png");
	private Image settings = new Image("/images/pad.png");
	private Image addPatient = new Image("/images/addPatient.png");
	private Image findPatient = new Image("/images/findPatient.png");
	private Image pillBugLogo = new Image("/images/pillBugLogo.png");

	// Default Constructor
	public Doctor() {
	}

	/**
	 * @return Vertical panel containing the buttons for a doctor to navigate
	 *         the application
	 */
	public IsWidget getDoctorPanel() {
		/**
		 * LOGO SIGN-IN ATTRIBUTES
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
		ft.getCellFormatter().setVerticalAlignment(0, 0,
				HasVerticalAlignment.ALIGN_BOTTOM);
		addPatient.setTitle("ADD PATIENT");
		addPatient.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				addPatient.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		}); // change mouse to pointer to indicate that it is a button
		addPatient.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				setSelectedIndex(1);
			}
		});

		/**
		 * FIND PATIENT
		 */
		ft.setWidget(0, 1, findPatient);
		findPatient.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 1,
				HasVerticalAlignment.ALIGN_BOTTOM);
		findPatient.setTitle("SEARCH PATIENT DATABASE");
		findPatient.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				findPatient.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		}); // change mouse to pointer to indicate that it is a button
		findPatient.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setSelectedIndex(2);
			}
		});
		
		/**
		 * SETTINGS
		 */
		ft.setWidget(0, 2, settings);
		settings.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 2,
				HasVerticalAlignment.ALIGN_BOTTOM);
		settings.setTitle("PRESCRIBE MEDICATION");
		settings.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				settings.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		}); // change mouse to pointer to indicate that it is a button
		settings.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				setSelectedIndex(3);
			}
		});

		/**
		 * LOGOUT
		 */
		ft.setWidget(0, 3, logout);
		logout.setPixelSize(50, 50);
		ft.getCellFormatter().setVerticalAlignment(0, 3,
				HasVerticalAlignment.ALIGN_BOTTOM);
		logout.setTitle("LOGOUT");
		logout.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				logout.getElement().getStyle().setCursor(Cursor.POINTER);
			}
		}); // change mouse to pointer to indicate that it is a button
		logout.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				logout();
			}
		});

		/**
		 * FORM PLACEMENT AND ATTRIBUTES
		 */
		ft.addStyleName("signInPasswordTextBoxes");
		ft.getElement().setAttribute("cellpadding", "13");

		// Add components to a flextable for organization
		hp.add(ft);
		return hp;
	}

	protected void setSelectedIndex(int i) {
		super.setDesiredIndex(i);
		super.refreshUI("doctor", i);
	}

	protected void logout() {
		super.refreshUI("null");
	}

	public TabLayoutPanel getHomeTab() {
		return super.getHomePage();
	}
}
