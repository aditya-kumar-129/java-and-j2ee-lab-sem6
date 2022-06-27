package program4;

public class Item {
	String name;
	int quantity;
	double price, total = 0;

	public Item(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.total = price * quantity;
	}

	public String toString() {
		return "Item [name=" + name + ", quantity=" + quantity + ", price=" + price + ", total=" + total + "]";
	}
}