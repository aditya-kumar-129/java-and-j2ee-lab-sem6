package program5;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Customer implements ActionListener {

  JLabel CUSTOMER_NO = new JLabel("Enter Customer Number:- ");
  JLabel CUSTOMER_NAME = new JLabel("Enter Customer Name :- ");
  JLabel CUSTOMER_STATE = new JLabel("Enter Customer State at which he lives :- ");
  JLabel CUSTOMER_CREDIT_LIMIT = new JLabel("Enter Customer Credit Limit:- ");
  JLabel REPRESENTATIVE_NO = new JLabel("Enter Representative Number :- ");

  JTextField customer_no = new JTextField(10);
  JTextField customer_name = new JTextField(10);
  JTextField customer_state = new JTextField(10);
  JTextField customer_credit_limit = new JTextField(10);
  JTextField representative_no = new JTextField(10);

  JFrame f1 = new JFrame("Customer");

  JButton submit = new JButton("ADD");

  Customer() {
    f1.add(CUSTOMER_NO);                f1.add(customer_no);
    f1.add(CUSTOMER_NAME);              f1.add(customer_name);
    f1.add(CUSTOMER_STATE);             f1.add(customer_state);
    f1.add(CUSTOMER_CREDIT_LIMIT);      f1.add(customer_credit_limit);
    f1.add(REPRESENTATIVE_NO);          f1.add(representative_no);
    f1.add(submit);

    f1.setSize(800, 600);
    f1.setLayout(new GridLayout(9, 2));
    f1.setVisible(true);
    submit.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submit) {
      String entered_customer_name = customer_name.getText();
      String entered_customer_number = customer_no.getText();
      String entered_customer_state = customer_state.getText();
      String entered_customer_credit_limit = customer_credit_limit.getText();
      String entered_representative_no = representative_no.getText();

      try {
        if (Integer.parseInt(entered_customer_credit_limit) > 15000) {
          String sql1 = "select * from rep where REPRESENTATIVE_NO = ?";
          PreparedStatement st1 = connection.c.prepareStatement(sql1);
          st1.setString(1, entered_representative_no);
          ResultSet res = st1.executeQuery();
          while (res.next()) {
            JOptionPane.showMessageDialog(null, "CL>15000\nNAME:" + res.getString("repname"));
          }
        }
        String sql = "insert into customer(customerNumber,customerName,customerState,customerCreditLimit,RepresentativeNumber) values(?,?,?,?,?)";
        PreparedStatement st;
        st = connection.c.prepareStatement(sql);
        st.setString(1, entered_customer_number);
        st.setString(2, entered_customer_name);
        st.setString(3, entered_customer_state);
        st.setString(4, entered_customer_credit_limit);
        st.setString(5, entered_representative_no);
        st.executeUpdate();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }
}