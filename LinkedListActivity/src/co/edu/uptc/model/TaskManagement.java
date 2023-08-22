package co.edu.uptc.model;

import java.util.Iterator;
import java.util.LinkedList;

public class TaskManagement {

	private LinkedList<User> users;

	public TaskManagement() {
		users = new LinkedList<>();
	}
	
	public void seeUserTasks(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if (user.getId()==id) {
				System.out.println(user.seeTasks());
			}
		}
	}
	
	public void addUserTasks(Task task, int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if (user.getId()==id) {
				user.addTak(task);
			}
		}
	}

	public LinkedList<User> getUsers() {
		return users;
	}
}
