package com.capgemini.healthcaresystem.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.dao.TestResult;
import com.capgemini.healthcaresystem.service.MapValidationErrorService;
import com.capgemini.healthcaresystem.service.TestResultService;

@RestController
@RequestMapping("/test")
public class TestResultController {
	@Autowired
	private TestResultService testservice;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("{id}")
	public ResponseEntity<?> createTestResult(@Valid @RequestBody TestResult tr,@PathVariable int id, BindingResult result){
	
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		TestResult testweb=testservice.addTestResult(tr,id);
		return new ResponseEntity<TestResult>(testweb, HttpStatus.CREATED);
	}
	
	@PatchMapping("/updating/{id}")
	public ResponseEntity<?> updateTestResult(@Valid @RequestBody TestResult tr, @PathVariable int id,BindingResult result){
	
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		TestResult testweb=testservice.updateTestResult(tr,id);
		return new ResponseEntity<TestResult>(testweb, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable int id){
		testservice.removeTestResult(id);
		return new ResponseEntity<String>("TestResult with id : '"+id+"' is deleted.",HttpStatus.OK);
	}
	
	@GetMapping("/{testresultid}")
	public ResponseEntity<?> getprojectById(@PathVariable int testresultid){
		TestResult testweb=testservice.getById(testresultid);
		return new ResponseEntity<TestResult>(testweb, HttpStatus.OK);
		
	}
	
	/*@GetMapping("/{alltestresults}")
	public Iterable<Patient> getAllResult(){
		return testservice.viewTestResultsByPatient();
		}
		*/
}
