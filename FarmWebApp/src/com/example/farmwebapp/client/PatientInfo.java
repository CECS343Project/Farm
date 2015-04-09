package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.*;

/**
 * top left panel
 * left image and right info
 * @author Daryl
 *
 */
public class PatientInfo 
{
	private HorizontalPanel pMainPanel = new HorizontalPanel();
	private Image iPatient = new Image();
	private TextArea tPatient = new TextArea();
	
	//set width
	//tPatient.setCharacterWidth(20);
    //set height as 5 lines
    //tPatient.setVisibleLines(5);
	
	public HorizontalPanel addPanel()
	{
		pMainPanel.add(iPatient);
		pMainPanel.setSpacing(5);
		pMainPanel.add(tPatient);
		
		return pMainPanel;
		
	}
}
