package com.example.farmwebapp.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * interchangeable bottom left panel
 * will require RetrievedData class
 * connected to database
 *  
 * @author Daryl
 *
 */
public class Meds 
{
	private VerticalPanel pMainPanel = new VerticalPanel();
	private HorizontalPanel pPanel1 = new HorizontalPanel();
	private HorizontalPanel pPanel2 = new HorizontalPanel();
	private HorizontalPanel pPanel3 = new HorizontalPanel();
	private VerticalPanel pSubPanel = new VerticalPanel();
	
	private Label lSearch = new Label("SEARCH");
	MultiWordSuggestOracle medsSuggest = new MultiWordSuggestOracle();
	//ass data created above
    private SuggestBox sMedsSearch= new SuggestBox(medsSuggest);
    
	private Label drugAllergies = new Label("DRUG ALLERGIES");
	//private RetrievedData rdMeds = new RetrievedData();
	private TextArea tMeds = new TextArea();
	private Image iTopMeds = new Image();
	private Image iBottomMeds = new Image();
	
	public VerticalPanel getPanel()
	{
		pMainPanel.add(pPanel1);
		pMainPanel.add(pPanel2);
		pMainPanel.add(pPanel3);
		
		pPanel1.add(lSearch);
		pPanel1.add(sMedsSearch);
		
		pPanel2.add(iTopMeds);
		//pPanel2.add(rdMeds);
		
		pPanel3.add(iBottomMeds);
		pPanel3.add(pSubPanel);
		
		pSubPanel.add(drugAllergies);
		pSubPanel.add(tMeds);
		
		return pMainPanel;
		
	}
	
}
