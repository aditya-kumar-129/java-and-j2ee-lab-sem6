package CustomerItemQuestion;

import java.util.ArrayList;

import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class Main implements ActionListener {
	JFrame f1 = new JFrame("Login Page");
	JLabel USER_NAME = new JLabel("Enter User Name :- ");
	JLabel USER_PASSWORD = new JLabel("Enter User Password:- ");
	JTextField user_name = new JTextField(10);
	JTextField user_password = new JTextField(10);
	JButton submit = new JButton("Login");
	
	JFrame f2 = new JFrame("Customer Details Page");
	JLabel CUSTOMER_ID = new JLabel("Enter Customer Id:- ");
	JLabel CUSTOMER_NAME = new JLabel("Enter Customer Name:- ");
	JLabel PHONE_NUMBER = new JLabel("Enter Phone Number :- ");
	JLabel ITEM_ID = new JLabel("Enter Item Id:- ");
	JLabel ITEM = new JLabel("Enter Item:- ");
	JLabel PRICE = new JLabel("Enter Price of the item :- ");
	JLabel QUANTITY = new JLabel("Enter Quantity:- ");
	JTextField customer_id = new JTextField(10);
	JTextField customer_name = new JTextField(10);
	JTextField item_id = new JTextField(10);
	JTextField phone_number = new JTextField(10);
	JTextField item = new JTextField(10);
	JTextField price = new JTextField(10);
	JTextField quantity = new JTextField(10);
	JButton checkout = new JButton("Checkout");
	JButton add = new JButton("Add");
	
	ArrayList<Staff> staffList = new ArrayList<Staff>();
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Item> itemList = new ArrayList<Item>();

	boolean newCustomer = false;
	double total = 0;
	boolean staffInformationDetails = false;
	// In the below area we will display the total value after the customer wants to checkout	
	JTextArea area = new JTextArea(20,20);
	// In the below area we will display the item selected by the customer until he/she decides to checkout
	JTextArea itemSelectedArea = new JTextArea(20,20);

	public Main() {
		f1.add(USER_NAME);				f1.add(user_name);
		f1.add(USER_PASSWORD);			f1.add(user_password);
		f1.add(submit);					f1.add(area);

		f2.add(CUSTOMER_ID);		f2.add(customer_id);	
		f2.add(CUSTOMER_NAME);		f2.add(customer_name);	
		f2.add(PHONE_NUMBER);		f2.add(phone_number);
		f2.add(ITEM_ID);			f2.add(item_id);
		f2.add(ITEM);				f2.add(item);
		f2.add(PRICE);				f2.add(price);
		f2.add(QUANTITY);			f2.add(quantity);
		f2.add(add);				f2.add(checkout);				f2.add(itemSelectedArea);						
		
		// Here we are adding the hardcoded staff information
		staffList.add(new Staff("a", "a"));
		// Here we are adding the hardcoded customer information in case the customer is already visited our shop
		customerList.add(new Customer("123","Aditya","test@123",Long.parseLong("123456789")));

		submit.addActionListener(this);
		add.addActionListener(this);
		checkout.addActionListener(this);
		
		f1.setSize(500, 500);
		f1.setLayout(new GridLayout(3, 2));
		f1.setVisible(true);
		f2.setVisible(false);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == submit) {
			String entered_user_name = user_name.getText();
			String entered_user_password = user_password.getText();
			for (Staff itr : staffList) {
				if (itr.username.equals(entered_user_name) && itr.password.equals(entered_user_password)) {
					f1.setVisible(false);
					staffInformationDetails = true;
					JOptionPane.showMessageDialog(null, "LOGGED IN");
				}
			}
			
			if(staffInformationDetails == true)
			{
				String choice = JOptionPane.showInputDialog(null, "If you are a New Customer Type YES else type NO");
				boolean customerFound = false;
				if(choice.equalsIgnoreCase("NO")) {
					String phoneNumber = JOptionPane.showInputDialog(null, "Enter Your Mobile Number:- ");
					for(Customer itr : customerList) {
						if(itr.phone_Number == Long.parseLong(phoneNumber)){
							customer_id.setText(itr.customer_id);
							customer_name.setText(itr.cutomer_name);
							phone_number.setText(Long.toString(itr.phone_Number));
							customerFound=true;
						}
					}
					if(!customerFound)
						JOptionPane.showMessageDialog(null, "NO USER FOUND with the phone Number :- " + phoneNumber);
				}
				else if(choice.equalsIgnoreCase("YES"))
					newCustomer = true;
				if(customerFound || newCustomer) {
					f2.setVisible(true);
					f2.setSize(600, 600);
					f2.setLayout(new GridLayout(9, 2));				
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid staff details");
				user_name.setText("");
				user_password.setText("");
			}
		}
		else if (event.getSource() == add) {
			Item newItemData = new Item(item.getText(),item_id.getText(), Integer.parseInt(quantity.getText()), 
					Double.parseDouble(price.getText()));
			itemList.add(newItemData);
			itemSelectedArea.setText(itemSelectedArea.getText() + "\n" + newItemData.toString());
			item_id.setText("");
			item.setText("");
			price.setText("");
			quantity.setText("");
		}
		else if (event.getSource() == checkout) {
			Customer newCustomerObject = new Customer(user_name.getText(), user_password.getText(), 
					customer_id.getText(),Integer.parseInt(phone_number.getText()));
			customerList.add(newCustomerObject);
			f1.setVisible(true);
			f2.setVisible(false);

			user_name.setText("");
			user_password.setText("");
			area.setText("");
			for (Item itr : itemList)
				total += itr.total;
			if(newCustomer) {
				total-=100;
				area.setText("Since you are the first time visited our shop we are giving you a discount of Rs 100 on your total purchase" + "\nTotal BILL:- " + total);				
			}
			else
				area.setText("\nTotal BILL:- " + total);				
			total = 0;
		}
	}
	public static void main(String[] args) {
		new Main();
	}
}