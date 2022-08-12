package CustomerItemQuestion;
public class Item {
	String name;
	String item_id;
	int quantity;
	double price, total = 0;	
	
	public Item(String name, String item_id, int quantity, double price) {
		this.name = name;
		this.item_id = item_id;
		this.quantity = quantity;
		this.price = price;
		this.total = price * quantity;
	}

	public String toString() {
		return "Item [name=" + name + ", item_id=" + item_id + ", quantity=" + quantity + ", price=" + price
				+ ", total=" + total + "]";
	}
}
