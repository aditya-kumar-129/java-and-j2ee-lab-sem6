package program6;
import java.sql.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Medicine implements ActionListener {
  JLabel MEDICINE_ID = new JLabel("Enter Medicine Id:- ");
  JLabel MEDICINE_NAME = new JLabel("Enter Medicine Name:- ");
  JTextField medicine_id = new JTextField(10);
  JTextField medicine_name = new JTextField(10);
  JButton submit = new JButton("ADD");

  JFrame f1 = new JFrame("Medicine");
  Medicine() {
    f1.add(MEDICINE_ID);        f1.add(medicine_id);
    f1.add(MEDICINE_NAME);      f1.add(medicine_name);
    f1.add(submit);
    
    f1.setSize(800, 600);
    f1.setLayout(new GridLayout(9, 2));
    f1.setVisible(true);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    submit.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    try {
      if (e.getSource() == submit) {
        String entered_medicine_id = medicine_id.getText();
        String entered_medicine_name = medicine_name.getText();
        String sql = "insert into medicineRecord values(?,?)";
        PreparedStatement st = connection.c.prepareStatement(sql);
        st.setString(1, entered_medicine_id);
        st.setString(2, entered_medicine_name);
        st.executeUpdate();
      }
    } catch (Exception ev) {
      ev.printStackTrace();
    }
  }

  public void getDetails(String s) {
    try {
      String sql = "select patient_name from patientRecord where medicine_id = (select medicine_id from medicineRecord where medicine_name = ?)";
      PreparedStatement st = connection.c.prepareStatement(sql);
      st.setString(1, s);
      ResultSet res = st.executeQuery();
      while (res.next())
        JOptionPane.showMessageDialog(null, "Patients taking medicine" + s + "\nNAME:" + res.getString("patient_name"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
