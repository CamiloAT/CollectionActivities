package co.edu.uptc.model;

import java.util.LinkedList;

public class User {

	private LinkedList<Task> tasks;
	private int id;
	private String name;
	
	public User(int id, String name) {
		tasks = new LinkedList<>();
		this.id = id;
		this.name = name;
	}

	public void addTak(Task task) {
		tasks.add(task);
	}
	
	public String seeTasks() {
		return tasks+"";
	}

	public LinkedList<Task> getTasks() {
		return tasks;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
