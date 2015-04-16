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

package com.example.farmwebapp.client.services.doctor;

import com.example.farmwebapp.client.dbobjects.DoctorData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DoctorServiceAsync 
{
	public void getDoctors(AsyncCallback<DoctorData[]> callback);
}
