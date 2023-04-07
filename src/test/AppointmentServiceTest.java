package test;

import main.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
	
	// Exceptions
	
	@Test
	void testAppointmentServiceAddDuplicateId() {
		
		AppointmentService appointmentService = new AppointmentService();
		
		// 2 appointments with identical IDs
		Appointment app1 = new Appointment("123", LocalDate.of(2030, 1, 1), "test");
		Appointment app2 = new Appointment("123", LocalDate.of(2030, 1, 1), "test");
		
		// Add 2 appointments with the same ID
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.addAppointment(app1);
			appointmentService.addAppointment(app2);
		});
		
	}
	
	@Test
	void testAppointmentServiceDeleteIdNotFound() {
		
		AppointmentService appointmentService = new AppointmentService();
		
		// Add appointment
		appointmentService.addAppointment(new Appointment("123", LocalDate.of(2030, 1, 1), "test"));
		
		// Delete appointment with non-existent ID
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.deleteAppointment("12345");
		});
		
	}
	
	@Test
	void testAppointmentServiceUpdateIdNotFound() {
		AppointmentService appointmentService = new AppointmentService();
		appointmentService.addAppointment(new Appointment("123", LocalDate.of(2030, 1, 1), "test"));
		
		// Update appointment with non-existent ID
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.updateAppointment("1234", LocalDate.of(2030, 1, 1), "test");
		});	
	}
	
	@Test
	void testAppointmentServiceGetIdNotFound() {
		
		AppointmentService appointmentService = new AppointmentService();
		
		// Add appointment
		appointmentService.addAppointment(new Appointment("123", LocalDate.of(2030, 1, 1), "test"));
		
		// Delete appointment with non-existent ID
		assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.getAppointment("12345");
		});
		
	}
	
	// Functional
	
	@Test
	void testAppointmentServiceAddAndDeleteAppointments() {
		
		// Empty appointments list
		AppointmentService appointmentService = new AppointmentService();
		assertTrue(appointmentService.getNumAppointments() == 0);
		
		// Add appointment
		appointmentService.addAppointment(new Appointment("123", LocalDate.of(2030, 1, 1), "test"));
		assertTrue(appointmentService.getNumAppointments() == 1);
		
		// Delete appointment
		appointmentService.deleteAppointment("123");
		assertTrue(appointmentService.getNumAppointments() == 0);
		
	}
	
	@Test
	void testAppointmentServiceUpdate() {
		// Appointment service with one appointment
		AppointmentService appointmentService = new AppointmentService();
		appointmentService.addAppointment(new Appointment("123", LocalDate.of(2030, 1, 1), "test1"));
		
		// Verify fields set correctly
		Appointment appointment = appointmentService.getAppointment("123");
		assertTrue(appointment.getId().equals("123"));
		assertTrue(appointment.getDate().compareTo(LocalDate.of(2030, 1, 1)) == 0);
		assertTrue(appointment.getDescription().equals("test1"));
		
		// Update appointment
		appointmentService.updateAppointment("123", LocalDate.of(2040, 2, 2), "test2");
		
		// Verify fields updated
		assertTrue(appointment.getId().equals("123"));
		assertTrue(appointment.getDate().compareTo(LocalDate.of(2040, 2, 2)) == 0);
		assertTrue(appointment.getDescription().equals("test2"));
	}
	
}
