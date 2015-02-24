package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.*;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;

public class FarmWebApp implements EntryPoint

{
	public void onModuleLoad() {
		
		TextBox tb = new TextBox();
		tb.setPixelSize(245, 20);
		
		PasswordTextBox ptb = new PasswordTextBox();
		ptb.setPixelSize(245, 20);
		
		tb.addKeyPressHandler(new KeyPressHandler() {

			public void onKeyPress(KeyPressEvent event) {
				// Add Event
			}
		});
		
		// Add them to the root panel.
		VerticalPanel panel = new VerticalPanel();
		panel.add(tb);
		panel.add(ptb);
		RootPanel.get().add(panel);
	}

}
