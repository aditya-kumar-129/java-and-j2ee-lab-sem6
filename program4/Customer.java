package program4;

public class Customer {
	String customer_id, user_name, user_password;
	int phone_number;

	public Customer(String user_name, String user_password, String customer_id, int phone_number) {
		this.customer_id = customer_id;
		this.phone_number = phone_number;
		this.user_password = user_password;
		this.user_name = user_name;
	}

	public String toString() {
		return "Customer [customer_id=" + customer_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", phone_number=" + phone_number + "]";
	}
}