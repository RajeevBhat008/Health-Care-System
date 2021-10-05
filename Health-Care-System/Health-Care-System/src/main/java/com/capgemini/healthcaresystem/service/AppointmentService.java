package com.capgemini.healthcaresystem.service;

import com.capgemini.healthcaresystem.dao.Appointment;

public interface AppointmentService {
	//public Appointment addAppointment(Appointment appointment);
		//public Set<Appointment> viewAppointments(String patientName);
		//public List<Appointment> getAppointmentList(int centreId, String test, int  status);
		public Appointment viewAppointmentById(int appointmentId);
		public Appointment updateAppointment(Appointment appointment,int appointmentId);
		public Appointment removeAppointmentById(int appointmentId);
		public Iterable<Appointment> viewAllAppointments();
		public Appointment saveAppointment(Appointment appointment);
}
