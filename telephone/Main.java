package telephone;

public class Main {
  public static void main(String args[]) {
    ContactList CustomerListObject = new ContactList();
    CustomerListObject.viewList();
    MissedCallList missedCallListObject = new MissedCallList();
    missedCallListObject.viewLog();
  }
}