package com.capgemini.healthcaresystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.Appointment;
import com.capgemini.healthcaresystem.dao.DiagnosticCenter;
import com.capgemini.healthcaresystem.dao.DiagnosticTest;
import com.capgemini.healthcaresystem.dao.TestResult;
import com.capgemini.healthcaresystem.repository.AppointmentRepository;
import com.capgemini.healthcaresystem.repository.TestResultRepository;
import com.capgemini.healthcaresystem.service.TestResultService;



@Service
public class TestResultServiceImpl implements TestResultService {

	@Autowired
	private TestResultRepository testRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Override
	public TestResult addTestResult(TestResult tr ,int appointmentid){	
		
			
			Appointment appointment=appointmentRepository.findAppointmentById(appointmentid);
			tr.setAppointment(appointment);
		   
		return testRepository.save(tr);
		
		
	}

	@Override
	public TestResult updateTestResult(TestResult tr,int id) {
		
		TestResult current=testRepository.findById(id);
		current.setTestReading(tr.getTestReading());
		current.setCondition(tr.getCondition());
		TestResult Update=testRepository.save(current);
		return Update;
		
		
	}

	@Override
	public void removeTestResult(int id) {
		//finding of an existing project task
		TestResult testResult=  testRepository.findById(id);
		//Retrieving the backlog info from the found task
		Appointment appointment = testResult.getAppointment();
		// Getting the specific project task and keeping it in the list
		List<TestResult> tts =  appointment.getTestresults();
		//removing the task from the list
		tts.remove(testResult);
		//saving the other information of the backlog
		appointmentRepository.save(appointment);
		//deleting the project task from the repository permanently
		testRepository.delete(testResult);
		
		
	}

	@Override
	public TestResult getById(int id) {
		TestResult tr=testRepository.findById(id);
		return tr;
	}

	/*@Override
	public Iterable<Patient> viewTestResultsByPatient() {
	
		return testrepository.findAll();
	}
*/
}
