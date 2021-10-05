package com.capgemini.healthcaresystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.Appointment;
import com.capgemini.healthcaresystem.dao.DiagnosticCenter;
import com.capgemini.healthcaresystem.exceptions.DiagnosticCenterIDException;
import com.capgemini.healthcaresystem.repository.AppointmentRepository;
import com.capgemini.healthcaresystem.repository.DiagnosticCenterRepository;
import com.capgemini.healthcaresystem.service.DiagnosticCenterService;
@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService {
	
	@Autowired
	DiagnosticCenterRepository diagnosticCenterRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		return diagnosticCenterRepository.findAll();
	}

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter,String centername) {
		try {
		diagnosticCenter.setName(diagnosticCenter.getName());
		return (DiagnosticCenter)diagnosticCenterRepository.save(diagnosticCenter);
		}catch(Exception ex) {
			throw new DiagnosticCenterIDException("Center name "+diagnosticCenter.getName()+" already exists");
		}
		
	}

	@Override
	public DiagnosticCenter getDiagnosticCenterById(int diagnosticCenterId) {
		DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findById(diagnosticCenterId);
		return diagnosticCenter;
	}

	@Override
	public DiagnosticCenter updateDiagnosticCenter(DiagnosticCenter diagnosticCenter,String centerName) {
		DiagnosticCenter existDiagnosticCenter=diagnosticCenterRepository.findByName(centerName);
		
		existDiagnosticCenter.setName(diagnosticCenter.getName());
		existDiagnosticCenter.setAddress(diagnosticCenter.getAddress());
		existDiagnosticCenter.setContactNo(diagnosticCenter.getContactNo());
		existDiagnosticCenter.setContactEmail((diagnosticCenter.getContactEmail()));
		existDiagnosticCenter.setServicesOffered(diagnosticCenter.getServicesOffered());
		DiagnosticCenter updateDiagnosticCenter=diagnosticCenterRepository.save(existDiagnosticCenter);
		return updateDiagnosticCenter;
	}

	@Override
	public DiagnosticCenter getDiagnosticCenter(String centerName) {
		DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findByName(centerName.toUpperCase());
		return diagnosticCenter;
	}

	@Override
	public DiagnosticCenter removeDiagnosticCenter(int id) {
		DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findById(id);
		diagnosticCenterRepository.delete(diagnosticCenter);
		return diagnosticCenter;
	}

}
