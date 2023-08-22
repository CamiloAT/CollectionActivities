package co.edu.uptc.presenter;

import java.util.Scanner;
import co.edu.uptc.model.OrderSystem;
import co.edu.uptc.model.Patient;

public class Presenter {

	OrderSystem orderSystem;

	public Presenter() {
		orderSystem= new OrderSystem();
		init();
	}

	public int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("------Hospital------\n1) Agregar paciente\n2) Ver pacientes\n3) Atender paciente\n4) Salir");
		return sc.nextInt();
	}

	private void init() {
		Scanner sc = new Scanner(System.in);
		boolean flag=true;
		while (flag) {
			switch (this.menu()) {
			case 1:
				System.out.println("Ingrese el nombre del paciente:");
				String name = sc.next();
				System.out.println("Ingrese el nivel de prioridad del paciente (En numero entero)");
				orderSystem.addPatient(new Patient(name,sc.nextInt()));
				break;
			case 2:
				System.out.println(orderSystem.showPatients());
				break;
			case 3:
				System.out.println(orderSystem.attendPatient());
				break;
			case 4:
				System.out.println("Has salido del menu");
				flag = false;
				break;			
			default:
				System.out.println("q??");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new Presenter();
	}
}
