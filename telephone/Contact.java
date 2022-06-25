package telephone;

public class Contact {
  long phoneNumber;
  String name;

  public Contact(String name, long phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String toString() {
    return "Name of the customer is :- " + name + ", And his Phone Number is :- " + phoneNumber;
  }
}