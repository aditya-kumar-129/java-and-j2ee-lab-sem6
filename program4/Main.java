package program4;

import java.util.ArrayList;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main implements ActionListener {
	JFrame f1 = new JFrame("Login Page");
	JLabel USER_NAME = new JLabel("Enter User Name :- ");
	JLabel USER_PASSWORD = new JLabel("Enter User Password:- ");
	JTextField user_name = new JTextField(10);
	JTextField user_password = new JTextField(10);
	JButton submit = new JButton("Login");
	
	JFrame f2 = new JFrame("Customer Details Page");
	JLabel CUSTOMER_ID = new JLabel("Enter Customer Id:- ");
	JLabel PHONE_NUMBER = new JLabel("Enter Phone Number :- ");
	JLabel ITEM = new JLabel("Enter Item:- ");
	JLabel PRICE = new JLabel("Enter Price of the item :- ");
	JLabel QUANTITY = new JLabel("Enter Quantity:- ");
	JTextField customer_id = new JTextField(10);
	JTextField phone_number = new JTextField(10);
	JTextField item = new JTextField(10);
	JTextField price = new JTextField(10);
	JTextField quantity = new JTextField(10);
	JButton bill = new JButton("Checkout");
	JButton add = new JButton("Add");
	
	ArrayList<Staff> staffList = new ArrayList<Staff>();
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	ArrayList<Item> itemList = new ArrayList<Item>();

	boolean newCustomer = false, first = true;
	double total = 0;
	JTextArea area = new JTextArea();
	JTextArea itemSelectedArea = new JTextArea();

	public Main() {
		f1.add(USER_NAME);				f1.add(user_name);
		f1.add(USER_PASSWORD);		f1.add(user_password);
		f1.add(submit);						f1.add(area);

		f2.add(CUSTOMER_ID);			f2.add(customer_id);	
		f2.add(PHONE_NUMBER);			f2.add(phone_number);
		f2.add(ITEM);							f2.add(item);
		f2.add(PRICE);						f2.add(price);
		f2.add(QUANTITY);					f2.add(quantity);
		f2.add(add);							f2.add(bill);									f2.add(itemSelectedArea);						
		
		staffList.add(new Staff("a", "a"));

		submit.addActionListener(this);
		add.addActionListener(this);
		bill.addActionListener(this);
		
		f1.setSize(1000, 800);
		f1.setLayout(new GridLayout(3, 2));
		f1.setVisible(true);
		f2.setVisible(false);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == submit) {
			String entered_user_name = user_name.getText();
			String entered_user_password = user_password.getText();
			boolean newCustomer = false;
			for (Staff itr : staffList) {
				if (itr.username.equals(entered_user_name) && itr.password.equals(entered_user_password)) {
					JOptionPane.showMessageDialog(null, "LOGGED IN");
					newCustomer = true;
				}
			}
			if (newCustomer) {
				JOptionPane.showMessageDialog(null, "ADD A NEW CUSTOMER");
				f1.setVisible(false);
				f2.setVisible(true);
				f2.setSize(1000, 800);
				f2.setLayout(new GridLayout(8, 2));
				newCustomer = false;
			} else
				JOptionPane.showMessageDialog(null, "NO USER FOUND");
		}
		else if (event.getSource() == add) {
			Item newItemData = new Item(item.getText(), Integer.parseInt(quantity.getText()), Double.parseDouble(price.getText()));
			itemList.add(newItemData);
			itemSelectedArea.setText(itemSelectedArea.getText() + "\n" + newItemData.toString());
			item.setText("");
			price.setText("");
			quantity.setText("");
			first = false;
		}
		else if (event.getSource() == bill) {
			Customer newCustomerObject = new Customer(user_name.getText(), user_password.getText(), customer_id.getText(),Integer.parseInt(phone_number.getText()));
			customerList.add(newCustomerObject);
			f1.setVisible(true);
			f2.setVisible(false);

			user_name.setText("");
			user_password.setText("");
			area.setText("");
			for (Item itr : itemList)
				total += itr.total;
			area.setText(area.getText() + "\nTotal BILL:- " + total);
			total = 0;
			first = true;
		}
	}
	public static void main(String[] args) {
		new Main();
	}
}