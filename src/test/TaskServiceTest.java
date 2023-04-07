package test;

import main.Task;
import main.TaskService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	
	// Exceptions
	
	@Test
	void testTaskServiceAddDuplicateId() {
		TaskService taskService = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask(new Task("12345", "Test", "test"));
			taskService.addTask(new Task("12345", "Test", "test"));
		});
	}
	
	@Test
	void testTaskServiceDeleteNonexistentId() {
		TaskService taskService = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("12345");
		});
	}
	
	@Test
	void testTaskServiceUpdateNonexistentId() {
		TaskService taskService = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTask("12345", "Test", "test");
		});
	}
	
	// Functional
	
	@Test
	void testTaskServiceAddAndDeleteTasks() {
		TaskService taskService = new TaskService();
		assertTrue(taskService.getNumTasks() == 0);
		
		taskService.addTask(new Task("12345", "Test", "test"));
		assertTrue(taskService.getNumTasks() == 1);
		
		taskService.deleteTask("12345");
		assertTrue(taskService.getNumTasks() == 0);
	}
	
	@Test
	void testTaskServiceUpdateTask() {
		TaskService taskService = new TaskService();
		
		taskService.addTask(new Task("12345", "1", "1"));
		assertTrue(taskService.getTask("12345").getName().equals("1"));
		assertTrue(taskService.getTask("12345").getDescription().equals("1"));
		
		taskService.updateTask("12345", "2", "2");
		assertTrue(taskService.getTask("12345").getName().equals("2"));
		assertTrue(taskService.getTask("12345").getDescription().equals("2"));
	}

}
