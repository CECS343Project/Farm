/**
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Russell
 *
 */

package com.example.farmwebapp.client.services.pharm;

import com.example.farmwebapp.client.dbobjects.PharmData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PharmServiceAsync
{
	public void getPharms(AsyncCallback<PharmData[]> callback);
}
