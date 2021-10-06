package com.capgemini.healthcaresystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.DiagnosticCenter;
import com.capgemini.healthcaresystem.dao.DiagnosticTest;
import com.capgemini.healthcaresystem.repository.DiagnosticCenterRepository;
import com.capgemini.healthcaresystem.repository.DiagnosticTestRepository;
import com.capgemini.healthcaresystem.service.DiagnosticTestService;

@Service
public class DiagnosticTestServiceImpl implements DiagnosticTestService {
	@Autowired
	DiagnosticCenterRepository diagnosticCenterRepository;

	@Autowired
	 DiagnosticTestRepository diagnosticTestRepository;
	
	
	
	@Override
	public List<DiagnosticTest> getAllTest() {
		return diagnosticTestRepository.findAll();		
	}

	@Override
	public DiagnosticTest addNewTest(DiagnosticTest test,int centerId) {
		DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findById(centerId);
		test.setDiagnosticCenter(diagnosticCenter);
		
		return (DiagnosticTest) diagnosticTestRepository.save(test);

	}

	@Override
	public Set<DiagnosticTest> getTestsOfDiagnosticCenter(int centerId) {
		DiagnosticCenter diagnosticCenter=diagnosticCenterRepository.findById(centerId);
		Set<DiagnosticTest> dts=diagnosticCenter.getTests();
		return dts;
	
	}

	@Override
	public DiagnosticTest updateTestDetail(DiagnosticTest test,String testName) {
		DiagnosticTest diagnosticTest = diagnosticTestRepository.findByTestName(test.getTestName());
		
		diagnosticTest.setTestName(test.getTestName());
		diagnosticTest.setNormalValue(test.getNormalValue());
		diagnosticTest.setTestPrice(test.getTestPrice());
		diagnosticTest.setUnits(test.getUnits());
		diagnosticTest.setDiagnosticCenter(test.getDiagnosticCenter());
		return diagnosticTestRepository.save(diagnosticTest);
	}
	
	@Override
	public DiagnosticTest removeTestFromDiagnosticCenter(String testName) {
		//finding of an existing project task
				DiagnosticTest diagnosticTest =  diagnosticTestRepository.findByTestName(testName);
				//Retrieving the backlog info from the found task
				DiagnosticCenter diagnosticCenter = diagnosticTest.getDiagnosticCenter();
				// Getting the specific project task and keeping it in the list
				Set<DiagnosticTest> dts =  diagnosticCenter.getTests();
				//removing the task from the list
				dts.remove(diagnosticTest);
				//saving the other information of the backlog
				diagnosticCenterRepository.save(diagnosticCenter);
				//deleting the project task from the repository permanently
				diagnosticTestRepository.delete(diagnosticTest);
				return diagnosticTest;
	}

}
