package StudentFrontend;

import java.util.*;

public class Student {
  String name, usn, address, category;
  int age;
  double cgpa;
  Scanner sc = new Scanner(System.in);

  public Student(String name, String usn, String address, String category, int age) {
    this.name = name;
    this.usn = usn;
    this.address = address;
    this.category = category;
    this.age = age;
  }

  public void setCgpa(double cgpa) {
    this.cgpa = cgpa;
  }

  public String toString() {
    return "Name: " + name + " USN: " + usn + " Age:" + age + " address: " + address + " category:" + category
        + " CGPA:" + cgpa;
  }
}
