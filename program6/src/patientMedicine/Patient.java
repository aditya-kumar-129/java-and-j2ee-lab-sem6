package patientMedicine;

import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

public class Patient implements ActionListener{
	JLabel PATIENT_ID = new JLabel("Patient ID:- ");
	JLabel PATIENT_NAME = new JLabel("Patient Name:- ");
	JLabel PATIENT_DISEASE = new JLabel("Patient Disease:- ");
	JLabel MEDICINE_ID = new JLabel("Medicine ID:- ");
	
	JTextField patient_id = new JTextField(10);
	JTextField patient_name = new JTextField(10);
	JTextField patient_disease = new JTextField(10);
	JTextField medicine_id = new JTextField(10);
	
	JButton Add_Patient = new JButton("Add Patient");
	
	JTextArea area = new JTextArea(10,10);
	
	JFrame f1 = new JFrame("Patient UI");
	
	Patient(){
		f1.add(PATIENT_ID);				f1.add(patient_id);
		f1.add(PATIENT_NAME);			f1.add(patient_name);
		f1.add(PATIENT_DISEASE);		f1.add(patient_disease);
		f1.add(MEDICINE_ID);			f1.add(medicine_id);
		
		f1.add(Add_Patient);
		
		f1.add(area);
		
		f1.setVisible(true);
		f1.setSize(500,500);
		f1.setLayout(new GridLayout(5,2));
		
		Add_Patient.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == Add_Patient) {
			String entered_patient_id = patient_id.getText();
			String entered_patient_name = patient_name.getText();
			String entered_patient_disease = patient_disease.getText();
			String entered_medicine_id = medicine_id.getText();	
			
			patient_id.setText("");
			patient_name.setText("");
			patient_disease.setText("");
			medicine_id.setText("");
			
			try {
				String sql = "insert into patient values(?,?,?,?)";
				PreparedStatement p = (PreparedStatement) connection.c.prepareStatement(sql);
				
				p.setString(1, entered_patient_id);
				p.setString(2, entered_patient_name);
				p.setString(3, entered_patient_disease);
				p.setString(4, entered_medicine_id);
				p.executeUpdate();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void getDetails(String diseaseName) {
		try {
			String getPatientDetails = "select * from patient where patient_disease = ?";
			PreparedStatement p1 = (PreparedStatement) connection.c.prepareStatement(getPatientDetails);
			p1.setString(1, diseaseName);
			ResultSet list = p1.executeQuery();
			while(list.next()) {
				area.append("Patient Name who have the disease '" + diseaseName + "' are :- \n" + list.getString(2) + "\n");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
