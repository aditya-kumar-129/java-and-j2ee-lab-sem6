package telephoneQuestion;

public class Contact {
	String name;
	long phoneNumber;
	
	public Contact(String name, long phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
}