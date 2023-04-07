package test;

import main.Task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {
	
	// Constructor
	
	@Test
	void testTask() {
		Task task = new Task("12345", "Test", "Perform constructor test");
		assertTrue(task.getId().equals("12345"));
		assertTrue(task.getName().equals("Test"));
		assertTrue(task.getDescription().equals("Perform constructor test"));
	}
	
	// Field length violations
	
	@Test
	void testIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Test", "run test");
		});
	}
	
	@Test
	void testNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "123456789012345678901", "run test");
		});
	}
	
	@Test
	void testDescriptionTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "Test", "123456789012345678901234567890123456789012345678901");
		});
	}
	
	// Null violations
	
	@Test
	void testIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Test", "run test");
		});
	}
	
	@Test
	void testNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", null, "run test");
		});
	}
	
	@Test
	void testDescriptionNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Test", null);
		});
	}
	
	// Setters
	
	@Test
	void testTaskSetName() {
		Task task = new Task("123", "test", "test");
		task.setName("test1");
		assertTrue(task.getName().equals("test1"));
	}
	
	@Test
	void testTaskSetDescription() {
		Task task = new Task("123", "test", "test");
		task.setDescription("test1");
		assertTrue(task.getDescription().equals("test1"));
	}
	
}
