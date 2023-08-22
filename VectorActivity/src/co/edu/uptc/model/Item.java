package co.edu.uptc.model;

public class Item {

	private int price;
	private String name;
	
	public Item(int price, String name) {
		super();
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "-Nombre= " + name+ "\nPrecio= " + price + "\n";
	}
}
