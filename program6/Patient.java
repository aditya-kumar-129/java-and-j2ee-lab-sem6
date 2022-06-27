package program6;

import java.sql.*;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Patient implements ActionListener {
  JLabel PATIENT_ID = new JLabel("Enter Patient Id:- ");
  JLabel PATIENT_NAME = new JLabel("Enter Patient Name:- ");
  JLabel PATIENT_DESEASE = new JLabel("Enter Patient Disease:- ");
  JLabel MEDICINE_ID = new JLabel("Enter Medicine ID:- ");

  JTextField patient_id = new JTextField(10);
  JTextField patient_name = new JTextField(10);
  JTextField patient_disease = new JTextField(10);
  JTextField medicine_id = new JTextField(10);

  JButton submit = new JButton("ADD");
  JFrame f1 = new JFrame("Patient");

  Patient() {
    f1.add(PATIENT_ID);           f1.add(patient_id);
    f1.add(PATIENT_NAME);         f1.add(patient_name);
    f1.add(PATIENT_DESEASE);      f1.add(patient_disease);
    f1.add(MEDICINE_ID);          f1.add(medicine_id);
    f1.add(submit);
    
    f1.setSize(800, 600);
    f1.setLayout(new GridLayout(9, 2));
    f1.setVisible(true);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    submit.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
    try {
      if (event.getSource() == submit) {
        String entered_patient_id = patient_id.getText();
        String entered_patient_name = patient_name.getText();
        String entered_patient_disease = patient_disease.getText();
        String entered_medicine_id = medicine_id.getText();

        String sql = "insert into patientRecord values(?,?,?,?)";
        PreparedStatement st = connection.c.prepareStatement(sql);
        st.setString(1, entered_patient_id);
        st.setString(2, entered_patient_name);
        st.setString(3, entered_patient_disease);
        st.setString(4, entered_medicine_id);
        st.executeUpdate();
      }
    } catch (Exception ev) {
      ev.printStackTrace();
    }
  }

  public void getDetails(String s) {
    try {
      String sql = "select * from patientRecord where patient_disease = ?";
      PreparedStatement st = connection.c.prepareStatement(sql);
      st.setString(1, s);
      ResultSet res = st.executeQuery();
      while (res.next())
        JOptionPane.showMessageDialog(null, "Patients with Disease" + s + "\nNAME:" + res.getString("patient_name"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}