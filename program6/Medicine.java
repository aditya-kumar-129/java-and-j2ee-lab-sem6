package program6;

import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

public class Medicine implements ActionListener {
  JLabel MEDICINE_ID = new JLabel("Medicine Id:- ");
  JLabel MEDICINE_NAME = new JLabel("Medicine Name:- ");

  JTextField medicine_id = new JTextField(10);
  JTextField medicine_name = new JTextField(10);

  JButton Add_Medicine = new JButton("Add Medicine");

  JTextArea area = new JTextArea(10, 10);

  JFrame f1 = new JFrame("Medine Table");

  Medicine() {
    f1.add(MEDICINE_ID);
    f1.add(medicine_id);
    f1.add(MEDICINE_NAME);
    f1.add(medicine_name);
    f1.add(Add_Medicine);
    f1.add(area);

    f1.setVisible(true);
    f1.setSize(400, 400);
    f1.setLayout(new GridLayout(4, 2));

    Add_Medicine.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == Add_Medicine) {
      String entered_medicine_id = medicine_id.getText();
      String entered_medicine_name = medicine_name.getText();

      medicine_id.setText("");
      medicine_name.setText("");

      try {
        String sql = "insert into medicine values(?,?)";
        PreparedStatement p = (PreparedStatement) connection.c.prepareStatement(sql);
        p.setString(1, entered_medicine_id);
        p.setString(2, entered_medicine_name);
        p.executeUpdate();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void getPatientDetailsGivenMedicineName(String medicineName) {
    try {
      String s = "select patient_name from patient where medicine_id = (select medicine_id from medicine where medicine_name = ?)";
      PreparedStatement p = (PreparedStatement) connection.c.prepareStatement(s);
      p.setString(1, medicineName);
      ResultSet patientName = p.executeQuery();
      while (patientName.next()) {
        area.append("Patient Name taking the medicine '" + medicineName + "' are :- \n"
            + patientName.getString("patient_name"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}