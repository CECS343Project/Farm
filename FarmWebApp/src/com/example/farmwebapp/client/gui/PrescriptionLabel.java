package com.example.farmwebapp.client.gui;

import com.google.gwt.user.client.ui.*;

/**
 * interchangeable right panel
 * @author Daryl
 *
 */
public class PrescriptionLabel 
{
	private VerticalPanel pMainPanel = new VerticalPanel();
	private HorizontalPanel pPanel1 = new HorizontalPanel();
	private HorizontalPanel pPanel2 = new HorizontalPanel();
	private HorizontalPanel pPanel3 = new HorizontalPanel();
	private VerticalPanel pSubPanel = new VerticalPanel();
	
	private Label lNotes = new Label("NOTES:");
	private Label lAllergies = new Label("DRUG ALLERGIES:");
	
	private TextArea tNotes = new TextArea();
	private TextArea tAllergies = new TextArea();
	
	private Image iCaution = new Image();
	
	public VerticalPanel getPanel()
	{
		pMainPanel.add(pPanel1);
		pMainPanel.add(pPanel2);
		pMainPanel.add(pPanel3);
		
		pPanel1.add(lNotes);
		
		pPanel2.add(tNotes);
		
		pPanel3.add(iCaution);
		pPanel3.add(pSubPanel);
		
		pSubPanel.add(lAllergies);
		pSubPanel.add(tAllergies);
		return pMainPanel;
		
	}
}
