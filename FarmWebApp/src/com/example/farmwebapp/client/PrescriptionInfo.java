package com.example.farmwebapp.client;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

/**
 * interchangeable bottom right panel
 * 
 * @author Daryl
 *
 */
public class PrescriptionInfo 
{
	private final int CELLWIDTH = 150;
	private final int CELLHEIGHT = 15;
	private VerticalPanel pMainPanel = new VerticalPanel();
	
	private FlexTable ftContainer = new FlexTable();
	
	private HorizontalPanel pPanel1 = new HorizontalPanel();
	private HorizontalPanel pPanel2 = new HorizontalPanel();
	private HorizontalPanel pPanel3 = new HorizontalPanel();
	private HorizontalPanel pPanel4 = new HorizontalPanel();
	private HorizontalPanel pPanel5 = new HorizontalPanel();
	private HorizontalPanel pPanel6 = new HorizontalPanel();
	private HorizontalPanel pPanel7 = new HorizontalPanel();
	private VerticalPanel pSubPanel= new VerticalPanel();
	
	private Label lList = new Label("MEDICATION LIST:");
	private Label lDosage = new Label("DOSAGE: ");
	private Label lTimes = new Label("TIMES PER: ");
	private Label lDuration = new Label("DURATION: ");
	private Label lStart = new Label("START DATE: ");
	private Label lEnd = new Label("END  DATE: ");
	private Label lNotes = new Label("NOTES:");
	private Label lSubmit = new Label("SUBMIT");

	private TextBox tMedication = new TextBox();
	private TextBox tDosage = new TextBox();
	private TextBox tTimes = new TextBox();
	private TextBox tDuration = new TextBox();
	//dates
	// Create a DateBox
    private final DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
    
    private DateBox dbStart = new DateBox();
    private DateBox dbEnd = new DateBox();
    
    private Image signUpArrow = new Image("/images/loginArrow.png");
	//private DatePicker dpStart= new DatePicker();
	//private DatePicker dpEnd= new DatePicker();
	
	private TextArea tNotes = new TextArea();
	
	private Button bAddPrescrip = new Button("Add Presccription");
	private Image iSubmit = new Image();

	
	public VerticalPanel getPanel()
	{
		ftContainer.setText(0, 0, "MEDICATION");
		ftContainer.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ftContainer.setWidget(0, 1, tMedication);
		tMedication.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		ftContainer.setText(1, 0, "DOSAGE");
		ftContainer.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ftContainer.setWidget(1, 1, tDosage);
		tDosage.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		ftContainer.setText(1, 2, "TIMES PER");
		ftContainer.getCellFormatter().setVerticalAlignment(1, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ftContainer.getCellFormatter().setHorizontalAlignment(1, 2, HasHorizontalAlignment.ALIGN_RIGHT);
		ftContainer.setWidget(1, 4, tTimes);
		tTimes.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		ftContainer.setText(2, 0, "DURATION");
		ftContainer.getCellFormatter().setVerticalAlignment(2, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ftContainer.setWidget(2, 1, tDuration);
		tDuration.setPixelSize(CELLWIDTH, CELLHEIGHT);
	
		dbStart.setFormat(new DateBox.DefaultFormat(dateFormat));
		
		ftContainer.setText(3, 0, "START");
		ftContainer.getCellFormatter().setVerticalAlignment(3, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ftContainer.setWidget(3, 1, dbStart);
		dbStart.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		dbEnd.setFormat(new DateBox.DefaultFormat(dateFormat));
		
		ftContainer.setText(3, 2, "END");
		ftContainer.getCellFormatter().setVerticalAlignment(3, 2, HasVerticalAlignment.ALIGN_BOTTOM);
		ftContainer.getCellFormatter().setHorizontalAlignment(3, 2, HasHorizontalAlignment.ALIGN_RIGHT);
		ftContainer.setWidget(3, 4, dbEnd);
		dbEnd.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		ftContainer.setText(4, 0, "NOTES");
		ftContainer.getCellFormatter().setVerticalAlignment(4, 0, HasVerticalAlignment.ALIGN_BOTTOM);
		ftContainer.setWidget(4, 1, tNotes);
		tNotes.setPixelSize(CELLWIDTH, CELLHEIGHT);
		
		ftContainer.setWidget(4, 3, bAddPrescrip);
		signUpArrow.setPixelSize(25, 25);
		ftContainer.setWidget(4, 4, signUpArrow);
		signUpArrow.setTitle("Add Patient");
		signUpArrow.addMouseOverHandler(new MouseOverHandler()
		{

			@Override
			public void onMouseOver(MouseOverEvent event) 
			{
				signUpArrow.getElement().getStyle().setCursor(Cursor.POINTER);
				
			}
			
		});
		ftContainer.getCellFormatter().setHorizontalAlignment(4, 4, HasHorizontalAlignment.ALIGN_RIGHT);
		
		bAddPrescrip.addClickHandler(new ClickHandler() 
		{
	        public void onClick(ClickEvent event) 
	        {
	        	HTML s_DBData;
	        	
	        	try
	        	{
	        		s_DBData = new HTML("Medication: " + tMedication.getText()
	        				+"<br>" + tDosage.getText() + " to be taken " 
	        			    + tTimes.getText() +" for " + tDuration.getText()
	        				+ "<br>Starting from: " + dbStart.getValue()
	        				+ "Until: " + dbEnd.getValue()
	        				+ "<br>Additional Notes: " + tNotes.getText());
		            PopUps popups = new PopUps();
		            popups.showDialog("Prescription Instructions:\r\n"  + s_DBData);
	        	}
	        	catch(Exception e)
	        	{
	        		
	        	}
	        }

		
	    });

		ftContainer.setWidth("700");
		ftContainer.setHeight("200");
		ftContainer.getElement().setAttribute("cellpadding", "5");
		pMainPanel.add(ftContainer);
		return pMainPanel;
		
	}
	
	public HTML getPrescriptionInstructions()
	{
		HTML s_instructions;
		
		s_instructions = new HTML("Medication: " + tMedication.getText()
				+"<br>" + tDosage.getText() + " to be taken " 
			    + tTimes.getText() +" for " + tDuration.getText()
				+ "<br>Starting from: " + dbStart.getValue()
				+ "Until: " + dbEnd.getValue()
				+ "<br>Additional Notes: " + tNotes.getText());
		
		return s_instructions;
	}
	
	public Image getSignUpArrow()
	{
		return this.signUpArrow;
	}
	

}
