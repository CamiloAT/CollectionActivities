package co.edu.uptc.model;

import java.util.Iterator;
import java.util.Vector;

public class ShoppingCart {

	private Vector<Item> cart;
	
	public ShoppingCart() {
		cart = new Vector<>();
	}
	
	public void addItem(Item item) {
		cart.add(item);
	}
	
	public String showProducts() {
		return ""+cart;
	}
	
	public int showTotalPrice() {
		Iterator<Item> iterator = cart.iterator();
		int total = 0;
		while (iterator.hasNext()) {
			total+=iterator.next().getPrice();
		}
		return total;
	}
}
