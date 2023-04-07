package test;

import main.Contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	// Constructor
	
	@Test
	void testContact() {
		Contact contact = new Contact("1234567890", "Dante", "Lee", "1112223333", "123 Test Road");
		assertTrue(contact.getContactId().equals("1234567890"));
		assertTrue(contact.getFirstName().equals("Dante"));
		assertTrue(contact.getLastName().equals("Lee"));
		assertTrue(contact.getPhone().equals("1112223333"));
		assertTrue(contact.getAddress().equals("123 Test Road"));
	}
	
	
	// Field length violations
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Dante", "Lee", "1112223333", "123 Test Road");
		});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Danteeeeeee", "Lee", "1112223333", "123 Test Road");
		});
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Dante", "Leeeeeeeeee", "1112223333", "123 Test Road");
		});
	}
	
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Dante", "Lee", "11122233334", "123 Test Road");
		});
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Dante", "Lee", "1112223333", "123 Test Road 12345678901234567");
		});
	}
	
	// Field null violations
	
	@Test
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Dante", "Lee", "1112223333", "123 Test Road");
		});
	}
	
	@Test
	void testContactFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "Lee", "1112223333", "123 Test Road");
		});
	}
	
	@Test
	void testContactLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Dante", null, "1112223333", "123 Test Road");
		});
	}
	
	@Test
	void testContactPhoneIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Dante", "Lee", null, "123 Test Road");
		});
	}
	
	@Test
	void testContactAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Dante", "Lee", "1112223333", null);
		});
	}

	// Setters
	
	@Test
	void testContactSetFirstName() {
		Contact contact = new Contact("test", "test", "test", "1234567890", "test");
		contact.setFirstName("test1");
		assertTrue(contact.getFirstName().equals("test1"));
	}
	
	@Test
	void testContactSetLastName() {
		Contact contact = new Contact("test", "test", "test", "1234567890", "test");
		contact.setLastName("test1");
		assertTrue(contact.getLastName().equals("test1"));
	}
	
	@Test
	void testContactSetPhone() {
		Contact contact = new Contact("test", "test", "test", "1234567890", "test");
		contact.setPhone("0987654321");
		assertTrue(contact.getPhone().equals("0987654321"));
	}
	
	@Test
	void testContactSetAddress() {
		Contact contact = new Contact("test", "test", "test", "1234567890", "test");
		contact.setAddress("test1");
		assertTrue(contact.getAddress().equals("test1"));
	}
	
}
