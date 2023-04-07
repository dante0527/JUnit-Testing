package main;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

public class AppointmentService {

	// Memory data structure
	private Map<String, Appointment> appointments;
	
	// Constructor
	public AppointmentService() {
		this.appointments = new HashMap<>();
	}
	
	// Add appointment with unique ID
	public void addAppointment(Appointment appointment) throws IllegalArgumentException {
		if (appointments.containsKey(appointment.getId())) {
			throw new IllegalArgumentException("Appointment ID already exists");
		}
		appointments.put(appointment.getId(), appointment);
	}
	
	// Delete appointment by ID
	public void deleteAppointment(String id) throws IllegalArgumentException {
		if (!appointments.containsKey(id)) {
			throw new IllegalArgumentException("Appointment ID does not exist");
		}
		appointments.remove(id);
	}
	
	// Update appointment by ID
	public void updateAppointment(String id, LocalDate date, String description) throws IllegalArgumentException {
		if (!appointments.containsKey(id)) {
			throw new IllegalArgumentException("Appointment ID does not exist");
		}
		Appointment appointment = appointments.get(id);
		appointment.setDate(date);
		appointment.setDescription(description);
	}
	
	// Get appointment by ID
	public Appointment getAppointment(String id) throws IllegalArgumentException {
		if (!appointments.containsKey(id)) {
			throw new IllegalArgumentException("Appointment ID does not exist");
		}
		return appointments.get(id);
	}
	
	// Get number of appointments
	public int getNumAppointments() {
		return appointments.size();
	}

}
