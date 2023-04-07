package test;

import main.Appointment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AppointmentTest {
	
	// Constructor
	
	@Test
	void testAppointment() {
		Appointment appointment = new Appointment("12345", LocalDate.of(2030, 1, 1), "test");
		assertTrue(appointment.getId().equals("12345"));
		assertTrue(appointment.getDate().compareTo(LocalDate.of(2030, 1, 1)) == 0);
		assertTrue(appointment.getDescription().equals("test"));
	}
	
	// Date before now
	
	@Test
	void testAppointmentDateBeforeToday() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", LocalDate.of(2000, 1, 1), "test");
		});
	}
	
	// Field length violations
	
	@Test
	void testAppointmentIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678901", LocalDate.of(2030, 1, 1), "test");
		});
	}
	
	@Test
	void testAppointmentDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", LocalDate.of(2030, 1, 1), "123456789012345678901234567890123456789012345678901");
		});
	}
	
	// Field null violations
	
	@Test
	void testAppointmentNullId() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, LocalDate.of(2030, 1, 1), "test");
		});
	}
	
	@Test
	void testAppointmentNullDate() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", null, "test");
		});
	}
	
	@Test
	void testAppointmentNullDescription() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345", LocalDate.of(2030, 1, 1), null);
		});
	}
	
	// Setters
	
	@Test
	void testAppointmentSetDate() {
		Appointment appointment = new Appointment("12345", LocalDate.of(2025, 5, 27), "Test");
		appointment.setDate(LocalDate.of(2025, 1, 1));
		assertTrue(appointment.getDate().equals(LocalDate.of(2025, 1, 1)));
	}
	
	@Test
	void testAppointmentSetDescription() {
		Appointment appointment = new Appointment("12345", LocalDate.of(2025, 5, 27), "Test1");
		appointment.setDescription("Test2");
		assertTrue(appointment.getDescription().equals("Test2"));
	}
	
}
