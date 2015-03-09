package com.example.farmwebapp.client;

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
	private VerticalPanel pMainPanel = new VerticalPanel();
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

	private TextBox tDosage = new TextBox();
	private TextBox tTimes = new TextBox();
	private TextBox tDuration = new TextBox();
	
	//private DatePicker dpStart= new DatePicker();
	//private DatePicker dpEnd= new DatePicker();
	
	private TextArea tNotes = new TextArea();
	
	private Button bSubmit = new Button();
	private Image iSubmit = new Image();

	
	public VerticalPanel getPanel()
	{
		pMainPanel.add(pPanel1);
		pMainPanel.add(pPanel2);
		pMainPanel.add(pPanel3);
		pMainPanel.add(pPanel4);
		pMainPanel.add(pPanel5);
		pMainPanel.add(pPanel6);
		pMainPanel.add(pPanel7);
		
		pPanel1.add(lList);
		
		//pPanel2.add();
		
		pPanel3.add(lDosage);
		pPanel3.add(tDosage);
		pPanel3.add(lTimes);
		pPanel3.add(tTimes);
		
		pPanel4.add(lDuration);
		pPanel4.add(tDuration);
		
		//dates
		// Create a DateBox
	    DateTimeFormat dateFormat = DateTimeFormat.getFormat("MM/dd/yyyy");
	    DateBox dbStart = new DateBox();
	    dbStart.setFormat(new DateBox.DefaultFormat(dateFormat));
	    DateBox dbEnd = new DateBox();
	    dbEnd.setFormat(new DateBox.DefaultFormat(dateFormat));
		
	    pPanel5.add(lStart);
	    pPanel5.add(dbStart);
	    pPanel5.add(lEnd);
	    pPanel5.add(dbEnd);
	    
	    pPanel6.add(lNotes);
	    
	    pPanel7.add(tNotes);
	    pPanel7.add(pSubPanel);
	    
	    pSubPanel.add(iSubmit);
	    pSubPanel.add(lSubmit);
	     
		return pMainPanel;
		
	}
	
	

}
