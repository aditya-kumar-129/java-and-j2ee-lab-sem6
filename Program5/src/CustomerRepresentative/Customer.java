package CustomerRepresentative;

import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

public class Customer implements ActionListener {
	JLabel CUSTOMER_NUMBER = new JLabel("Enter Customer Number :- ");
	JLabel CUSTOMER_NAME = new JLabel("Enter Customer Name :- ");
	JLabel CUSTOMER_STATE = new JLabel("Enter State :- ");
	JLabel CUSTOMER_CREDIT_LIMIT = new JLabel("Enter Credit Limit :- ");
	JLabel REPRESENTATIVE_NUMBER = new JLabel("Enter Representative Number :- ");
	
	JTextField customer_number = new JTextField(10);
	JTextField customer_name = new JTextField(10);
	JTextField customer_state = new JTextField(10);
	JTextField customer_credit_limit = new JTextField(10);
	JTextField representative_number = new JTextField(10);
	
	JButton add_customer = new JButton("Add Customer");
	
	JTextArea area = new JTextArea(20,20);
	
	JFrame f1 = new JFrame("Customer Details");
	public Customer(){
		f1.add(CUSTOMER_NUMBER);				f1.add(customer_number);
		f1.add(CUSTOMER_NAME);					f1.add(customer_name);
		f1.add(CUSTOMER_STATE);					f1.add(customer_state);
		f1.add(CUSTOMER_CREDIT_LIMIT);			f1.add(customer_credit_limit);
		f1.add(REPRESENTATIVE_NUMBER);			f1.add(representative_number);
		
		f1.add(add_customer);
		
		f1.add(area);
		
		f1.setVisible(true);
		f1.setLayout(new GridLayout(6,2));
		f1.setSize(500,500);
		add_customer.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == add_customer) {
			String entered_customer_number = customer_number.getText();
			String entered_customer_name = customer_name.getText();
		    String entered_customer_state = customer_state.getText();
		    String entered_customer_credit_limit = customer_credit_limit.getText();
		    String entered_representative_no = representative_number.getText();
		    
		    customer_number.setText("");
		    customer_name.setText("");
		    customer_state.setText("");
		    customer_credit_limit.setText("");
		    representative_number.setText("");
		    
		    try {
		    	String s1 = "insert into customer values(?,?,?,?,?)";
		    	PreparedStatement p1 = (PreparedStatement) connection.c.prepareStatement(s1);
		    	p1.setString(1, entered_customer_number);
		    	p1.setString(2, entered_customer_name);
		    	p1.setString(3, entered_customer_state);
		    	p1.setString(4, entered_customer_credit_limit);
		    	p1.setString(5, entered_representative_no);
		    	p1.executeUpdate();
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
		    
		    if(Integer.parseInt(entered_customer_credit_limit) > 15000) {
				String subQuery = "select* from representative where representative_no = " + entered_representative_no;
				
				try {
					PreparedStatement subst = (PreparedStatement) connection.c.prepareStatement(subQuery);
					ResultSet rs = subst.executeQuery();
					
					while(rs.next()) {
						String display = "Representative Information\n\n" + "Rep No : " + rs.getString("RepNo") + "\nRep Name : " 
					+ rs.getString("RepName") + "\nState : " + rs.getString("State") + "\nComission : " + rs.getString("Comission") 
					+ "\nRate : " + rs.getString("Rate");
						area.setText(display);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
