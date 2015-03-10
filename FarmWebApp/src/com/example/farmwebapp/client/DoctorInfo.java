package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextArea;

/**
 * top right panel
 * left image and right info
 * @author Daryl
 *
 */
public class DoctorInfo
{
	private HorizontalPanel pMainPanel = new HorizontalPanel();
	private Image iDoctor = new Image();
	private TextArea tDoctor = new TextArea();
	
	public HorizontalPanel addPanel()
	{
		pMainPanel.addStyleName("mainPanel");
		pMainPanel.add(iDoctor);
		pMainPanel.setSpacing(5);
		pMainPanel.add(tDoctor);
		
		return pMainPanel;
		
	}

}
