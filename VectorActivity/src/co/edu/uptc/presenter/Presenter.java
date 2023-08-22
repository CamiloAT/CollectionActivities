package co.edu.uptc.presenter;

import java.util.Scanner;

import co.edu.uptc.model.Item;
import co.edu.uptc.model.ShoppingCart;

public class Presenter {

	private ShoppingCart shoppingCart;
	
	public Presenter() {
		shoppingCart = new ShoppingCart();
		this.initCart();
	}
	
	private void initCart() {
		shoppingCart.addItem(new Item(1000, "Papa"));
		shoppingCart.addItem(new Item(1500, "Platano"));
		shoppingCart.addItem(new Item(2000, "Carne"));
		shoppingCart.addItem(new Item(100, "Dulce"));
		shoppingCart.addItem(new Item(500, "Cilantro"));
		shoppingCart.addItem(new Item(5000, "Huevo"));
	}
	
	public int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("------Carro------\n1) Agregar producto\n2) Ver productos\n3) Ver total\n4) Salir");
		return sc.nextInt();
	}
	
	public void addItem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el nombre del producto");
		String name = sc.nextLine();
		System.out.println("Ingrese el precio del producto");
		shoppingCart.addItem(new Item(sc.nextInt(), name));
	}
	
	public void seeItem() {
		System.out.println(shoppingCart.showProducts());
	}
	
	public void showTotalPrice() {
		System.out.println("El total de los productos es de " + shoppingCart.showTotalPrice() + " pesos");
	}
	
	public static void main(String[] args) {
		Presenter presenter = new Presenter();
		boolean flag=true;
		while (flag) {
			switch (presenter.menu()) {
			case 1:
				presenter.addItem();
				break;
			case 2:
				presenter.seeItem();
				break;
			case 3:
				presenter.showTotalPrice();
				break;
			case 4:
				System.out.println("Has salido del programa");
				flag=false;
				break;
			default:
				System.out.println("q??");
				break;
			}
		}
	}
}
