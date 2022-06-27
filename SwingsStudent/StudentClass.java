package SwingsStudent;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.ArrayList;

public class StudentClass implements ActionListener {
  JLabel NAME = new JLabel("Enter Name of the student :- ");
  JLabel USN = new JLabel("Enter usn of the student :- ");
  JLabel AGE = new JLabel("Enter age of the student :- ");
  JLabel ADDRESS = new JLabel("Enter address of the student :- ");
  JLabel CATEGORY = new JLabel("Select Category of the student :- ");
  JLabel SGPA1 = new JLabel("Enter SGPA1 of the student :- ");
  JLabel SGPA2 = new JLabel("Enter SGPA2 of the student :- ");
  JLabel SGPA3 = new JLabel("Enter SGPA3 of the student :- ");
  JLabel SGPA4 = new JLabel("Enter SGPA4 of the student :- ");
  JLabel SGPA5 = new JLabel("Enter SGPA5 of the student :- ");
  JLabel SGPA6 = new JLabel("Enter SGPA6 of the student :- ");
  JLabel SGPA7 = new JLabel("Enter SGPA7 of the student :- ");
  JLabel SGPA8 = new JLabel("Enter SGPA8 of the student :- ");
  JLabel CGPA = new JLabel("CGPA of the student ");

  JTextField name = new JTextField(10);
  JTextField usn = new JTextField(10);
  JTextField age = new JTextField(10);
  JTextField address = new JTextField(10);
  // A littile different
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

  JButton Add = new JButton("Add");
  JButton display = new JButton("display");

  // This will be used for frame f2 for dispalying the details of the student
  JTextArea stud_list_display = new JTextArea(20, 20);

  JFrame f1 = new JFrame("Student Information");
  JFrame f2 = new JFrame("Student Collection Display");

  ArrayList<Student> studentList = new ArrayList<>();

  public StudentClass() {
    category.addItem("SC");
    category.addItem("ST");
    category.addItem("OBC");
    category.addItem("GENERAL");
    f1.add(NAME);        f1.add(name);
    f1.add(USN);         f1.add(usn);
    f1.add(AGE);         f1.add(age);
    f1.add(ADDRESS);     f1.add(address);
    f1.add(CATEGORY);    f1.add(category);
    f1.add(SGPA1);       f1.add(sgpa1);
    f1.add(SGPA2);       f1.add(sgpa2);
    f1.add(SGPA3);       f1.add(sgpa3);
    f1.add(SGPA4);       f1.add(sgpa4);
    f1.add(SGPA5);       f1.add(sgpa5);
    f1.add(SGPA6);       f1.add(sgpa6);
    f1.add(SGPA7);       f1.add(sgpa7);
    f1.add(SGPA8);       f1.add(sgpa8);
    f1.add(CGPA);        f1.add(cgpa);
    f1.add(Add);     f1.add(display);

    f2.add(stud_list_display);

    f1.setSize(500, 500);
    f1.setLayout(new GridLayout(8, 8));
    f1.setVisible(true);

    Add.addActionListener(this);
    display.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == Add) {
      try {
        int entered_user_age = Integer.parseInt(age.getText());
        if (entered_user_age < 18 || entered_user_age > 35) {
          String age1 = JOptionPane.showInputDialog(null, "Enter valid Age");
          age.setText(age1);
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(f1, "Invalid entry");
        age.requestFocus();
      }
      validate_SGPA(1, sgpa1);
      validate_SGPA(2, sgpa2);
      validate_SGPA(3, sgpa3);
      validate_SGPA(4, sgpa4);
      validate_SGPA(5, sgpa5);
      validate_SGPA(6, sgpa6);
      validate_SGPA(7, sgpa7);
      validate_SGPA(8, sgpa8);
      float calculated_cgpa = calculateCGPA();
      cgpa.setText(Float.toString(calculated_cgpa));
      Student newStudentObject = new Student(name.getText(), usn.getText(), address.getText(),
          String.valueOf(category.getSelectedItem()),
          Integer.parseInt(age.getText()), Float.parseFloat(cgpa.getText()));
      studentList.add(newStudentObject);
    } 
    else {
      f1.setVisible(false);
      f2.setVisible(true);
      f2.setSize(500, 500);
      stud_list_display.setText(" ");
      for (Student itr : studentList)
        stud_list_display.append(itr.toString() + "\n");
    }
  }

  float calculateCGPA() {
    float value_sgpa1 = Float.parseFloat(sgpa1.getText());
    float value_sgpa2 = Float.parseFloat(sgpa2.getText());
    float value_sgpa3 = Float.parseFloat(sgpa3.getText());
    float value_sgpa4 = Float.parseFloat(sgpa4.getText());
    float value_sgpa5 = Float.parseFloat(sgpa5.getText());
    float value_sgpa6 = Float.parseFloat(sgpa6.getText());
    float value_sgpa7 = Float.parseFloat(sgpa7.getText());
    float value_sgpa8 = Float.parseFloat(sgpa8.getText());
    return (value_sgpa1 + value_sgpa2 + value_sgpa3 + value_sgpa4 + value_sgpa5 + value_sgpa6 + value_sgpa7 + value_sgpa8) / 8;
  }

  void validate_SGPA(int sem, JTextField sgpa) {
    float value_sgpa = Float.parseFloat(sgpa.getText());
    try {
      if (value_sgpa > 10) {
        String correct_sgpa = JOptionPane.showInputDialog(null, "Enter an SGPA less than or equal to 10 for sem " + sem);
        sgpa.setText(correct_sgpa);
      }
    } catch (Exception e) {
      String v2 = JOptionPane.showInputDialog(null, "Please enter SGPA for semester " + sem);
      sgpa.setText(v2);
      sgpa.requestFocus();
    }
  }

  public static void main(String[] args) {
    new StudentClass();
  }
}