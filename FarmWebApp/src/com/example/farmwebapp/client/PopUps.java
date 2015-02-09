package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

public class PopUps 
{
	static class Confirmation extends PopupPanel 
	  {

	    public Confirmation() 
	    {
	      // PopupPanel's constructor takes 'auto-hide' as its boolean parameter.
	      // If this is set, the panel closes itself automatically when the user
	      // clicks outside of it.
	      super(true);

	      // PopupPanel is a SimplePanel, so you have to set it's widget property to
	      // whatever you want its contents to be.
	      setWidget(new Label("Confirmation"));
	    }
	    public Confirmation(boolean yes, boolean no)
	    {
	    	
	    }
	    
	    public void show()
	    {
	    	this.show();
	    }

	  }
}
