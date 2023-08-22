package co.edu.uptc.presenter;

import java.util.Scanner;

import co.edu.uptc.model.Calculator;

public class Presenter {

	private Calculator calculator;
	
	public Presenter() {
		calculator = new Calculator();
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------CALCULADORA--------------------------------------------------------------------------------\n\nRecomendaciones:\n1) Ingrese la operacion separando cada numero y su signo con un espacio\n2) En el caso de operaciones trigonometricas ingrese la operacion seguida de un parantesis, seguido el numero y por ultimo el parentesis de cierre\n3) En el caso de usar parentesis, ponga el parantesis de apertura seguido de la operacion con la primera recomendacion, al terminar de escribir \nla operacion seguidamente coloque el parentesis de cierre");
		System.out.println(calculator.finalOperation(sc.nextLine()));
	}
	
	public static void main(String[] args) {
		new Presenter();
	}
	
}
