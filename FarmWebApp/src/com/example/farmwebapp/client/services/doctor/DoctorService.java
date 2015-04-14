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
import com.example.farmwebapp.client.dbobjects.PatientData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("doctorService")
public interface DoctorService extends RemoteService
{
	public DoctorData[] getDoctors();

}
