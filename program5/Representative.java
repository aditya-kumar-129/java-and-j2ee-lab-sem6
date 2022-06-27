package program5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.sql.PreparedStatement;

public class Representative implements ActionListener {
  
  JFrame f1 = new JFrame("Representative form");
  JLabel REPRESENTATIVE_NO = new JLabel("Enter Representative Number:- ");
  JLabel REPRESENTATIVE_NAME = new JLabel("Enter Representative Name :- ");
  JLabel REPRESENTATIVE_STATE = new JLabel("Enter Representative State at which he lives :- ");
  JLabel REPRESENTATIVE_COMISSION = new JLabel("Enter Representative Comission:- ");
  JLabel REPRESENTATIVE_RATE = new JLabel("Enter Representative Rate :- ");

  JTextField representative_no = new JTextField(10);
  JTextField representative_name = new JTextField(10);
  JTextField representative_state = new JTextField(10);
  JTextField representative_comission = new JTextField(10);
  JTextField representative_rate = new JTextField(10);

  JButton submit = new JButton("ADD");

  Representative() {
    f1.add(REPRESENTATIVE_NO);              f1.add(representative_no);
    f1.add(REPRESENTATIVE_NAME);            f1.add(representative_name);
    f1.add(REPRESENTATIVE_STATE);           f1.add(representative_state);
    f1.add(REPRESENTATIVE_COMISSION);       f1.add(representative_comission);
    f1.add(REPRESENTATIVE_RATE);            f1.add(representative_rate);
    f1.add(submit);
    f1.setSize(800, 600);
    f1.setLayout(new GridLayout(9, 2));
    f1.setVisible(true);
    submit.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submit) {
      String entered_representative_no = representative_no.getText();
      String entered_representative_name = representative_name.getText();
      String entered_representative_comission = representative_comission.getText();
      String entered_representative_rate = representative_rate.getText();
      String entered_representative_state = representative_state.getText();

      // If you are directly inserting the values in the same order as the schema of the table then it is not necessary to write the column names
      String sql = "insert into representative values(?,?,?,?,?)";
      try {
        PreparedStatement st = connection.c.prepareStatement(sql);
        st.setString(1, entered_representative_no);
        st.setString(2, entered_representative_name);
        st.setString(3, entered_representative_comission);
        st.setString(4, entered_representative_state);
        st.setString(5, entered_representative_rate);
        st.executeUpdate();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }
}