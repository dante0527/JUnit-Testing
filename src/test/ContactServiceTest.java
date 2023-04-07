package test;

import main.Contact;
import main.ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	// Exceptions
	
	@Test
	void testContactServiceAddDuplicateId() {
		ContactService contactService = new ContactService();
		
		// 2 contacts with identical IDs
		Contact contact1 = new Contact("1234567890", "Dante", "Lee", "1112223333", "123 Test Road");
		Contact contact2 = new Contact("1234567890", "Dante", "Lee", "1112223333", "123 Test Road");
		
		// Add two contacts with the same ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact(contact1);
			contactService.addContact(contact2);
		});
	}
	
	@Test
	void testContactServiceUpdateIdNotExist() {
		ContactService contactService = new ContactService();
		
		// Add contact
		contactService.addContact(new Contact("1234567890", "Dante", "Lee", "1112223333", "123 Test Road"));
		
		// Update contact by non-existent ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateContact("0987654321", "Dante", "Lee", "1112223333", "123 Test Road");
		});
	}
	
	// Functional
	
	@Test
	void testContactServiceAddAndDeleteContacts() {
		// Empty contact list
		ContactService contactService = new ContactService();
		assertTrue(contactService.getNumContacts() == 0);
		
		// Add contact
		contactService.addContact(new Contact("1234567890", "Dante", "Lee", "1112223333", "123 Test Road"));
		assertTrue(contactService.getNumContacts() == 1);
		
		// Delete contact
		contactService.deleteContact("1234567890");
		assertTrue(contactService.getNumContacts() == 0);
	}
	
	@Test
	void testContactServiceUpdateContact() {
		ContactService contactService = new ContactService();
		
		contactService.addContact(new Contact("1234567890", "Dante", "Lee", "1112223333", "123 Test Road"));
		contactService.updateContact("1234567890", "Joe", "Mach", "1112223333", "123 Test Road");
		
		assertTrue(contactService.getContact("1234567890").getFirstName() == "Joe");
		
	}
	
}
