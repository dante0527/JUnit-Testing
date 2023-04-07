package main;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	// Memory data structure
	private Map<String, Contact> contacts;
	
	// Constructor
	public ContactService() {
		this.contacts = new HashMap<>();
	}
	
	// Add contact by ID
	public void addContact(Contact contact) throws IllegalArgumentException {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }
	
	// Delete contact by ID
    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }
    
    // Update contact fields by ID
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        Contact contact = contacts.get(contactId);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }
    
    public int getNumContacts() {
    	return contacts.size();
    }
    
    public Contact getContact(String contactId) {
    	return contacts.get(contactId);
    }
    
}
