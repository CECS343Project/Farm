package com.example.farmwebapp.client;

import javafx.stage.PopupBuilder;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PopUps extends DialogBox
{
	PopUps(){}
	
	private VerticalPanel popupPanel = new VerticalPanel();
	private HorizontalPanel pButtonPanel = new HorizontalPanel();
	
	/**
	 *  Shows a given dialog message in a popup box
	 * @author Russell  
	 * @param message
	 */
	public void showDialog(String message)
	{
		Label lMessage = new Label(message);
		Button bOk = new Button("OK");
		
		ClickHandler chOkButton = new ClickHandler()
		{

			@Override
			public void onClick(ClickEvent event) 
			{
				hide();				
			}
		};
		bOk.addClickHandler(chOkButton);
		
		popupPanel.add(lMessage);
		pButtonPanel.add(bOk);
		popupPanel.add(pButtonPanel);
		setWidget(popupPanel);
		this.center();
		this.show();
	}
   
}
