package StudentSwingQuestion;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Main implements ActionListener {
	JLabel NAME = new JLabel("Enter Name of the Student");
	JLabel USN = new JLabel("Enter USN of the Student");
	JLabel AGE = new JLabel("Enter age of the Student");
	JLabel ADDRESS = new JLabel("Enter address of the Student");
	JLabel CATEGORY = new JLabel("Select the category of the Student");
	JLabel SGPA1 = new JLabel("Enter SGPA of semester :- 1");
	JLabel SGPA2 = new JLabel("Enter SGPA of semester :- 2");
	JLabel SGPA3 = new JLabel("Enter SGPA of semester :- 3");
	JLabel SGPA4 = new JLabel("Enter SGPA of semester :- 4");
	JLabel SGPA5 = new JLabel("Enter SGPA of semester :- 5");
	JLabel SGPA6 = new JLabel("Enter SGPA of semester :- 6");
	JLabel SGPA7 = new JLabel("Enter SGPA of semester :- 7");
	JLabel SGPA8 = new JLabel("Enter SGPA of semester :- 8");
	JLabel CGPA = new JLabel("Enter CGPA the Student");
	
	JTextField name = new JTextField(10);
	JTextField usn = new JTextField(10);
	JTextField age = new JTextField(10);
	JTextField address = new JTextField(10);
	
	// A little different
	JComboBox<String> category = new JComboBox<String>();
	
	JTextField sgpa1 = new JTextField(10);
	JTextField sgpa2 = new JTextField(10);
	JTextField sgpa3 = new JTextField(10);
	JTextField sgpa4 = new JTextField(10);
	JTextField sgpa5 = new JTextField(10);
	JTextField sgpa6 = new JTextField(10);
	JTextField sgpa7 = new JTextField(10);
	JTextField sgpa8 = new JTextField(10);
	JTextField cgpa = new JTextField(10);
	
	JButton add = new JButton("Add Student");
	JButton display = new JButton("Display");
	
	// This will be used for frame f2 for displaying the details of the student
	JTextArea  student_list_display = new JTextArea(20, 20);
	
	JFrame f1 = new JFrame("Student Information");
	JFrame f2 = new JFrame("Student Collection Display");
	
	ArrayList<Student> studentList = new ArrayList<>();
	
	public Main(){
		category.addItem("SC");
		category.addItem("ST");
		category.addItem("OBC");
		category.addItem("GENERAL");
		
		f1.add(NAME);		f1.add(name);
		f1.add(USN);		f1.add(usn);
		f1.add(AGE);		f1.add(age);
		f1.add(ADDRESS);	f1.add(address);
		f1.add(CATEGORY);	f1.add(category);
		f1.add(SGPA1);		f1.add(sgpa1);
		f1.add(SGPA2);		f1.add(sgpa2);
		f1.add(SGPA3);		f1.add(sgpa3);
		f1.add(SGPA4);		f1.add(sgpa4);
		f1.add(SGPA5);		f1.add(sgpa5);
		f1.add(SGPA6);		f1.add(sgpa6);
		f1.add(SGPA7);		f1.add(sgpa7);
		f1.add(SGPA8);		f1.add(sgpa8);
		f1.add(CGPA);		f1.add(cgpa);
		
		f1.add(add);		f1.add(display);
		
		f2.add(student_list_display);
		
		f1.setSize(800,800);
		f1.setLayout(new GridLayout(8,8));
		f1.setVisible(true);
		
		add.addActionListener(this);
		display.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == add) {
			try {
				int entered_user_age = Integer.parseInt(age.getText());
				if(entered_user_age<18 || entered_user_age>35)
					age.setText(JOptionPane.showInputDialog(null, "Enter valid age"));
			}
			// This catch block will get executed when we don't enter any value in the age textField.
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Invalid Entry");
			}
			validate_SGPA(1,sgpa1);
			validate_SGPA(2,sgpa2);
			validate_SGPA(3,sgpa3);
			validate_SGPA(4,sgpa4);
			validate_SGPA(5,sgpa5);
			validate_SGPA(6,sgpa6);
			validate_SGPA(7,sgpa7);
			validate_SGPA(8,sgpa8);

			cgpa.setText(Float.toString(calculateCGPA()));
			Student studentDetails = new Student(name.getText(),usn.getText(),address.getText(),
					String.valueOf(category.getSelectedItem()),
					Integer.parseInt(age.getText()),Float.parseFloat(cgpa.getText())
					);
			studentList.add(studentDetails);
		}
		else {
			f1.setVisible(true);	f2.setVisible(true);
			name.setText("");		age.setText("");	usn.setText("");	address.setText("");
			sgpa1.setText("");		sgpa2.setText("");	sgpa3.setText("");	sgpa4.setText("");
			sgpa5.setText("");		sgpa6.setText("");	sgpa7.setText("");	sgpa8.setText("");
			cgpa.setText("");

			f2.setSize(800,800);
			student_list_display.setText(" ");
			for(Student itr : studentList)
				student_list_display.append(itr.toString() + "\n");
		}
	}
	
	
	float calculateCGPA() {
		float sgpa1_value = Float.parseFloat(sgpa1.getText());
		float sgpa2_value = Float.parseFloat(sgpa2.getText());
		float sgpa3_value = Float.parseFloat(sgpa3.getText());
		float sgpa4_value = Float.parseFloat(sgpa4.getText());
		float sgpa5_value = Float.parseFloat(sgpa5.getText());
		float sgpa6_value = Float.parseFloat(sgpa6.getText());
		float sgpa7_value = Float.parseFloat(sgpa7.getText());
		float sgpa8_value = Float.parseFloat(sgpa8.getText());
		
		return (sgpa1_value + sgpa2_value + sgpa3_value + sgpa4_value + sgpa5_value + sgpa6_value + sgpa7_value + sgpa8_value)/8;
	}
	
	void validate_SGPA(int sem,JTextField sgpa) {
		float value_sgpa = Float.parseFloat(sgpa.getText());
		try {
			if(value_sgpa>10)
				sgpa.setText(JOptionPane.showInputDialog(null, "Enter an SGPA less than 10 for the semester" + sem));
		}
		catch(Exception e) {
			sgpa.setText(JOptionPane.showInputDialog(null, "Please enter SGPA for semester " + sem));
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
}