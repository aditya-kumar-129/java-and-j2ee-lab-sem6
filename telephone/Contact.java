package telephone;

class Contact {
  String name;
  long phoneNumber;

  Contact(String name, long phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String toString() {
    return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + "]";
  }
}