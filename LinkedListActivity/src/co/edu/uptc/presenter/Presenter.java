package co.edu.uptc.presenter;

import java.time.LocalDate;
import java.util.Scanner;
import co.edu.uptc.model.Task;
import co.edu.uptc.model.TaskManagement;
import co.edu.uptc.model.User;

public class Presenter {
	
	private TaskManagement tm;
	
	public Presenter() {
		tm = new TaskManagement();
		this.initActivity();
	}
	
	public void initActivity() {
		tm.getUsers().add(new User(1, "Camilo"));
		tm.getUsers().add(new User(2, "Andres"));
		tm.getUsers().add(new User(3, "Julian"));
		tm.getUsers().add(new User(4, "Santiago"));
	}
	
	public int activity() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-------Tareas-------\n1) Agregar tarea a usuario\n2) Ver tareas de usuario\n3) Salir");
		return sc.nextInt();
	}
	
	public void addTask() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la descripcion de la tarea:");
		String description = sc.nextLine();
		System.out.println("Ingrese la fecha de vencimiento");
		Task task = new Task(description, LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		System.out.println("Ingrese el id del usuario");
		tm.addUserTasks(task, sc.nextInt());
	}
	
	public void seeTask() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el id del usuario");
		tm.seeUserTasks(sc.nextInt());
	}
	
	public static void main(String[] args) {
		Presenter a = new Presenter();
		boolean flag = true;
		while (flag) {
			switch (a.activity()) {
			case 1:
				a.addTask();
				break;
			case 2:
				a.seeTask();
				break;
			case 3:
				System.out.println("Has salido del menu");
				flag=false;
				break;
			default:
				System.out.println("q??");
				break;
			}
		}
	}
}
