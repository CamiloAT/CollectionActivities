package co.edu.uptc.model;

import java.time.LocalDate;

public class Task {
	
	private String description;
	private LocalDate dueDate;
	
	public Task(String description, LocalDate dueDate) {
		super();
		this.description = description;
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "-------Tarea-------\n Descripcion=" + description + "\n Fecha de vencimiento=" + dueDate;
	}
}
