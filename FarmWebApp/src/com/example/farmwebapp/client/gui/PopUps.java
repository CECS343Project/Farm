package com.example.farmwebapp.client.gui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.*;

public class PopUps extends DialogBox
{
	PopUps()
	{
		super(true);
	}
	
	private VerticalPanel popupPanel = new VerticalPanel();
	private HorizontalPanel pButtonPanel = new HorizontalPanel();
	
	
	public void showDialog(SafeHtml message)
	{
		HTML lMessage = new HTML(message);
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
		
		popupPanel.addStyleName("popupPanel");
		pButtonPanel.addStyleName("pButtonPanel");
		this.center();
		this.show();
	}
	
	public void showDialog(String message)
	{
		HTML lMessage = new HTML(message);
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
		
		popupPanel.addStyleName("popupPanel");
		pButtonPanel.addStyleName("pButtonPanel");
		this.center();
		this.show();
	}	
   
}
