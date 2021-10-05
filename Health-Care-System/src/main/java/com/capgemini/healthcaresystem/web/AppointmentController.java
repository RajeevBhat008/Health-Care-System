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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcaresystem.dao.Appointment;
import com.capgemini.healthcaresystem.service.AppointmentService;
import com.capgemini.healthcaresystem.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	@PostMapping("")
	public ResponseEntity<?> createNewAppointment(@Valid @RequestBody Appointment appointment, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Appointment savedAppointment = appointmentService.saveAppointment(appointment);
		return new ResponseEntity<Appointment>(savedAppointment,HttpStatus.CREATED);
		
	}
	@PatchMapping("/byAppointmentId/{appointmentId}")
	public ResponseEntity<?> updateNewAppointment(@Valid @RequestBody Appointment appointment, @PathVariable int appointmentId,BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Appointment updatedAppointment = appointmentService.updateAppointment(appointment,appointmentId);
		return new ResponseEntity<Appointment>(updatedAppointment,HttpStatus.OK);
		
	}
	@GetMapping("/{appointmentId}")
	public ResponseEntity<?> getprojectById(@PathVariable int appointmentId){
		Appointment appointment = appointmentService.viewAppointmentById(appointmentId);
		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
		
	}
	@GetMapping("/list")
	public Iterable<Appointment> getAllAppintments(){
		return appointmentService.viewAllAppointments();
		
	}
	@DeleteMapping("/{appointmentId}")
	public ResponseEntity<?> deleteAppointment(@PathVariable int appointmentId){
		appointmentService.removeAppointmentById(appointmentId);
		return new ResponseEntity<String>("appointment with id"+appointmentId+"ia deleted", HttpStatus.OK);
	}
	
	
	

}