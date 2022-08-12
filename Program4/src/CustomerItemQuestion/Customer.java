package CustomerItemQuestion;

public class Customer {
	String customer_id, cutomer_name,customer_password;
	long phone_Number;
	
	public Customer(String customer_id, String cutomer_name, String customer_password, long phone_Number) {
		this.customer_id = customer_id;
		this.cutomer_name = cutomer_name;
		this.customer_password = customer_password;
		this.phone_Number = phone_Number;
	}

	public String toString() {
		return "Customer [customer_id=" + customer_id + ", cutomer_name=" + cutomer_name + ", customer_password="
				+ customer_password + ", phone_Number=" + phone_Number + "]";
	}
}