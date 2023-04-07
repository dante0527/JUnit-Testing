package main;

public class Task {
	
	// Fields
	private final String id;
	private String name;
	private String description;
	
	// Constructor
	public Task(String id, String name, String description) {
		
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid Input");
		}
		
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Input");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Input");
		}
		
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	// Accessors
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	// Mutators
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
