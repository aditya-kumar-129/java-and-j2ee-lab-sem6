package SwingsStudent;

public class Student {
  String name, usn, address, category;
  int age;
  float cgpa;

  public Student(String name, String usn, String address, String category, int age, float cgpa) {
    this.name = name;
    this.usn = usn;
    this.address = address;
    this.category = category;
    this.age = age;
    this.cgpa = cgpa;
  }

  public String toString() {
    return ("Name of the student is :- " + name + " with USN :- " + usn + " residing in " + address
        + " belonging to category :- " + category + " of age :- " + age + " and has cgpa :- " + cgpa);
  }
}