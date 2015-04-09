package com.example.farmwebapp.client.gui;

import com.google.gwt.user.client.ui.*;

/**
 * interchangeable bottom left panel
 * 2 textareas and an image
 * @author Daryl
 *
 */
public class PrescriptionNotes
{
	private VerticalPanel pMainPanel = new VerticalPanel();
	private HorizontalPanel pSubPanel = new HorizontalPanel();
	private VerticalPanel pSubPanel2 = new VerticalPanel();
	
	private Label lMedsList = new Label();
	private Label lAuthorize = new Label();
	
	private Image iPresc = new Image();
	private Image iAuthorize = new Image();
	
	public VerticalPanel getPanel()
	{
		pMainPanel.add(lMedsList);
		pMainPanel.add(pSubPanel);
		
		pSubPanel.add(iPresc);
		pSubPanel.add(pSubPanel2);
		
		pSubPanel2.add(iAuthorize);
		pSubPanel2.add(lAuthorize);
		return pMainPanel;
		
	}
}
