package com.capgemini.healthcaresystem.service;

import java.util.List;

import com.capgemini.healthcaresystem.dao.DiagnosticCenter;

public interface DiagnosticCenterService {
	
	public List<DiagnosticCenter> getAllDiagnosticCenters();
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter,String centerName);
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId);
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter,String centerName);
	//public DiagnosticTest viewTestDetails(int diagnosticCenterid, String testName);
	//public DiagnosticTest addTestDetails(int diagnosticCenterid, int testId);
	public DiagnosticCenter getDiagnosticCenter(String centerName);
	public DiagnosticCenter removeDiagnosticCenter(int id);
	//public List<Appointment> getListOfAppointments(String centerName);

}
