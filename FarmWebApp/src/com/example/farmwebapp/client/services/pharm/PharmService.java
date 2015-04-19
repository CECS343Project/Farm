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
import com.example.farmwebapp.client.dbobjects.PatientData;
import com.example.farmwebapp.client.dbobjects.PharmData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("pharmService")
public interface PharmService extends RemoteService
{
	public PharmData[] getPharms();
}
