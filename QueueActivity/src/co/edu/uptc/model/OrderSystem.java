package co.edu.uptc.model;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderSystem {
	private Comparator<Patient> comparator;
	private PriorityQueue<Patient> patients;

	public OrderSystem() {
		comparator = (p1, p2) -> Integer.compare(p2.getPriority(),p1.getPriority());
		patients = new PriorityQueue<Patient>(comparator);
	}

	public void addPatient(Patient pacient) {
		patients.add(pacient);
	}

	public String attendPatient() {
		String output = "No hay pacientes aun";
		if (!patients.isEmpty()) {
			output = "El/la paciente " + patients.poll().getName() + " ha sido atendido";
		}
		return output;
	}
	
	public String showPatients() {
		return "" + patients;
	}
}
