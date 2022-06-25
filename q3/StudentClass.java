package q3;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;

public class StudentClass implements ActionListener {
  LinkedList<Student> studentList = new LinkedList<Student>();

  // Defining all the levels that are required
  JLabel Name = new JLabel("Enter Name of the Student :- ");
  JLabel USN = new JLabel("Enter USN of the Student :- ");
  JLabel Age = new JLabel("Enter Age of the Student :- ");
  JLabel Address = new JLabel("Enter Address at which Student Lives :- ");
  JLabel Category = new JLabel("Select category of the Student :- ");
  JLabel SGPA1 = new JLabel("Enter SGPA of I sem");
  JLabel SGPA2 = new JLabel("Enter SGPA of II sem");
  JLabel SGPA3 = new JLabel("Enter SGPA of III sem");
  JLabel SGPA4 = new JLabel("Enter SGPA of IV sem");
  JLabel SGPA5 = new JLabel("Enter SGPA of V sem");
  JLabel SGPA6 = new JLabel("Enter SGPA of VI sem");
  JLabel SGPA7 = new JLabel("Enter SGPA of VII sem");
  JLabel SGPA8 = new JLabel("Enter SGPA of VIII sem");
  JLabel CGPA = new JLabel("CGPA obtained");

  // Adding the textFeild
  JTextField name = new JTextField(20);
  JTextField usn = new JTextField(20);
  JTextField age = new JTextField(3);
  JTextArea address = new JTextArea(3, 4);
  JComboBox<String> category = new JComboBox<String>();
  JTextField cgpa = new JTextField(10);
  JTextField sgpa1 = new JTextField(5);
  JTextField sgpa2 = new JTextField(5);
  JTextField sgpa3 = new JTextField(5);
  JTextField sgpa4 = new JTextField(5);
  JTextField sgpa5 = new JTextField(5);
  JTextField sgpa6 = new JTextField(5);
  JTextField sgpa7 = new JTextField(5);
  JTextField sgpa8 = new JTextField(5);

  JButton submit = new JButton("COMPUTE");
  JButton done = new JButton("done");
  JButton display = new JButton("display");
  // JTextArea(int row, int column) Creates a text area with the specified number
  // of rows and columns that displays no text initially.
  JTextArea stud_list_display = new JTextArea(20, 20);
  // JTextArea(int row, int column) Creates a text area with the specified number
  // of rows and columns that displays no text initially.
  JFrame f1 = new JFrame("Student Information");
  JFrame f2 = new JFrame("Student Collection Display");

  StudentClass() {
    Name.setBounds(10, 10, 10, 10);
    category.addItem("GM");
    category.addItem("SC/ST");
    category.addItem("Cat1");
    category.addItem("Cat2");
    f1.add(Name);       f1.add(name);
    f1.add(USN);        f1.add(usn);
    f1.add(Age);        f1.add(age);
    f1.add(Address);    f1.add(address);
    f1.add(Category);   f1.add(category);
    f1.add(SGPA1);      f1.add(sgpa1);
    f1.add(SGPA2);      f1.add(sgpa2);
    f1.add(SGPA3);      f1.add(sgpa3);
    f1.add(SGPA4);      f1.add(sgpa4);
    f1.add(SGPA5);      f1.add(sgpa5);
    f1.add(SGPA6);      f1.add(sgpa6);
    f1.add(SGPA7);      f1.add(sgpa7);
    f1.add(SGPA8);      f1.add(sgpa8);
    f1.add(CGPA);       f1.add(cgpa);
    f1.add(submit);     f1.add(done);      f1.add(display);
    f2.add(stud_list_display);
    // Sets the size of the frame
    f1.setSize(900, 800);
    // GridLayout(int rows, int columns): creates a grid layout with the given rows
    // and columns but no gaps between the components.
    f1.setLayout(new GridLayout(8, 8));
    // Sets the frame to be visible
    f1.setVisible(true);
    submit.addActionListener(this);
    done.addActionListener(this);
    display.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
    // https://www.oreilly.com/library/view/java-for-dummies/9781118239742/a2_08_9781118239742-ch05.html
    if (event.getSource() == submit) {
      try {
        int v1 = Integer.parseInt(age.getText());
        if (v1 < 18 || v1 > 35) {
          // It basically displays a dialoguebox in which we ask the user to re enter the age which should is valid.
          // The re-entered age should be set to the form.
          String age1 = JOptionPane.showInputDialog(null, "Enter valid Age");
          age.setText(age1);
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(f1, "Invalid entry");
        age.requestFocus();
      }
      checkSGPA_valid(1, sgpa1);
      checkSGPA_valid(2, sgpa2);
      checkSGPA_valid(3, sgpa3);
      checkSGPA_valid(4, sgpa4);
      checkSGPA_valid(5, sgpa5);
      checkSGPA_valid(6, sgpa6);
      checkSGPA_valid(7, sgpa7);
      checkSGPA_valid(8, sgpa8);
      float calculate_CGPA = calculate_cgpa();
      cgpa.setText(Float.toString(calculate_CGPA));
    } else if (event.getSource() == done)// to submit into collection
    {
      Student newStudentObject = new Student(name.getText(), usn.getText(), address.getText(),
          String.valueOf(category.getSelectedItem()), 
          Integer.parseInt(age.getText()), Float.parseFloat(cgpa.getText()));
      studentList.add(newStudentObject);
    } else {
      f1.setVisible(false);
      f2.setVisible(true);
      f2.setSize(500, 500);
      stud_list_display.setText(" ");
      for (Student itr : studentList)
        stud_list_display.append(itr.toString() + "\n");
    }
  }

  float calculate_cgpa() {
    float v1 = Float.parseFloat(sgpa1.getText());
    float v2 = Float.parseFloat(sgpa2.getText());
    float v3 = Float.parseFloat(sgpa3.getText());
    float v4 = Float.parseFloat(sgpa4.getText());
    float v5 = Float.parseFloat(sgpa5.getText());
    float v6 = Float.parseFloat(sgpa6.getText());
    float v7 = Float.parseFloat(sgpa7.getText());
    float v8 = Float.parseFloat(sgpa8.getText());
    return (v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8) / 8;
  }

  void checkSGPA_valid(int sem, JTextField sgpa) {
    try {
      if (Float.parseFloat(sgpa.getText()) > 10) {
        String v1 = JOptionPane.showInputDialog(null, "Enter an SGPA less than or equal to 10 for sem " + sem);
        sgpa.setText(v1);
      }
    } catch (NumberFormatException e) {
      String v2 = JOptionPane.showInputDialog(null, "Please enter SGPA for semester " + sem);
      sgpa.setText(v2);
      // sgpa.requestFocus();
    }
  }

  public static void main(String args[]) {
    StudentClass sc = new StudentClass();
  }
}