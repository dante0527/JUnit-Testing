package main;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	
	// Memory data structure
	private Map<String, Task> tasks;
	
	// Constructor
	public TaskService() {
		this.tasks = new HashMap<>();
	}
	
	// Methods
	public void addTask(Task task) throws IllegalArgumentException {
		if (tasks.containsKey(task.getId())) {
			throw new IllegalArgumentException("Task ID already axists");
		}
		tasks.put(task.getId(), task);
	}
	
	
	public void deleteTask(String id) throws IllegalArgumentException {
		if (!tasks.containsKey(id)) {
			throw new IllegalArgumentException("Task ID not found");
		}
		tasks.remove(id);
	}
	
	
	public void updateTask(String id, String name, String description) throws IllegalArgumentException {
		if (!tasks.containsKey(id)) {
			throw new IllegalArgumentException("Task ID not found");
		}
		Task task = tasks.get(id);
		task.setName(name);
		task.setDescription(description);
	}
	
	public int getNumTasks() {
		return tasks.size();
	}
	
	public Task getTask(String id) {
		return tasks.get(id);
	}
	
}
