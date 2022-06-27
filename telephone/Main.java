package telephone;

public class Main {
  public static void main(String args[]) {
    ContactList contactListObject = new ContactList();
    contactListObject.displayCustomer();
    MissedCallList missedCallListObject = new MissedCallList();
    missedCallListObject.display();
  }
}