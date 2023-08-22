package co.edu.uptc.model;

public class Patient {
	
	private String name;
	private int priority;
	
	public Patient(String name, int levelPriority) {
		this.name = name;
		this.priority = levelPriority;
	}
	
	public String getName() {
		return name;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return "Nombre: " + name + ", Prioridad: " + priority ;
	}
	
}
