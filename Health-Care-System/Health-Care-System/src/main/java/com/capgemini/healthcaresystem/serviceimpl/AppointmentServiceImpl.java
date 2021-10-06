package com.capgemini.healthcaresystem.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcaresystem.dao.Appointment;
import com.capgemini.healthcaresystem.dao.DiagnosticCenter;
import com.capgemini.healthcaresystem.repository.AppointmentRepository;
import com.capgemini.healthcaresystem.service.AppointmentService;


@Service 
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired 
	AppointmentRepository appointmentRepository;

	@Override
	public Appointment viewAppointmentById(int id) {
		// TODO Auto-generated method stub
		Appointment appointment = appointmentRepository.findAppointmentById(id);
		//if(appointment==null) {
			//throw new AppointmentIdException("Appointment Id" +appointment.getId()+" does not exists.");
		//
		return appointment;
	}

	@Override
	public Appointment updateAppointment(Appointment appointment,int appointmentId ) {
		// TODO Auto-generated method stub
		Appointment newAppointment= appointmentRepository.findAppointmentById(appointmentId);
		newAppointment.setApprovalStatus(appointment.getApprovalStatus());
		newAppointment.setAppointmentDate(appointment.getAppointmentDate());
		return appointmentRepository.save(newAppointment);
		
	
	}

	@Override
	public Appointment removeAppointmentById(int id) {
		// TODO Auto-generated method stub
		Appointment appointment = appointmentRepository.findAppointmentById(id);
		appointmentRepository.delete(appointment);
		return appointment;
	}

	@Override
	public Iterable<Appointment> viewAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		//try {
			appointment.setApprovalStatus(appointment.getApprovalStatus());
			DiagnosticCenter diagnosticCenter=new DiagnosticCenter();
			appointment.setDiagnosticCenter(diagnosticCenter);
			diagnosticCenter.setAppointment(appointment);
			diagnosticCenter.setId(appointment.getId());
			return appointmentRepository.save(appointment);
		//} 
		//catch(Exception e) {
			//throw new AppointmentIdException("Appointment Id"+appointment.getId()+" already exists");
		//}
		
	}
	
}
