package CustomerRepresentative;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

public class Representative implements ActionListener{
	JLabel REPRESENTATIVE_NUMBER = new JLabel("Enter the Representative Number:- ");
	JLabel REPRESENTATIVE_NAME = new JLabel("Enter the Representative Name:- ");
	JLabel REPRESENTATIVE_STATE = new JLabel("Enter the Representative State:- ");
	JLabel REPRESENTATIVE_COMMISION = new JLabel("Enter the Representative Commision:- ");
	JLabel REPRESENTATIVE_RATE = new JLabel("Enter the Representative Rate:- ");
	
	JTextField representaive_number = new JTextField(10);
	JTextField representaive_name = new JTextField(10);
	JTextField representaive_state = new JTextField(10);
	JTextField representaive_commission = new JTextField(10);
	JTextField representaive_rate = new JTextField(10);
	
	JButton Add_representative = new JButton("Add Representative");
	
	JFrame f1 = new JFrame("Representative UI");
	
	Representative(){
		f1.add(REPRESENTATIVE_NUMBER);		f1.add(representaive_number);
		f1.add(REPRESENTATIVE_NAME);		f1.add(representaive_name);
		f1.add(REPRESENTATIVE_STATE);		f1.add(representaive_state);
		f1.add(REPRESENTATIVE_COMMISION);	f1.add(representaive_commission);
		f1.add(REPRESENTATIVE_RATE);		f1.add(representaive_rate);
		f1.add(Add_representative);	
		
		f1.setVisible(true);
		f1.setSize(500,500);
		f1.setLayout(new GridLayout(6,2));
		
		Add_representative.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == Add_representative) {
			String entered_representative_number = representaive_number.getText();
			String entered_representaive_name = representaive_name.getText();
			String entered_representaive_state = representaive_state.getText();
			String entered_representaive_commission = representaive_commission.getText();
			String entered_representaive_rate = representaive_rate.getText();
			
			representaive_number.setText("");
			representaive_name.setText("");
			representaive_state.setText("");
			representaive_commission.setText("");
			representaive_rate.setText("");
			
			try {
				String s = "insert into representative values(?,?,?,?,?)";
				PreparedStatement p = (PreparedStatement) connection.c.prepareStatement(s);
				
				p.setString(1, entered_representative_number);
				p.setString(2, entered_representaive_name);
				p.setString(3, entered_representaive_state);
				p.setString(4, entered_representaive_commission);
				p.setString(5, entered_representaive_rate);
				
				p.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}