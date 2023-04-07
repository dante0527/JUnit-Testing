package main;

import java.time.LocalDate;

public class Appointment {

	private final String id;
	private LocalDate date;
	private String description;
	
	public Appointment(String id, LocalDate date, String description) {
		
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if (date == null || date.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		this.id = id;
		this.date = date;
		this.description = description ;
		
	}
	
	public String getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
