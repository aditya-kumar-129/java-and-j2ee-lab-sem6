package telephone;
import java.util.*;

public class ContactList {
  Scanner sc = new Scanner(System.in);
  // static keywords are necessory otherwise we wont be able to access the
  // getCustomerList from the missedCall.java file
  static ArrayList<Contact> CustomerList = new ArrayList<Contact>();

  public ContactList() {
    while (true) {
      System.out.println("Enter 1 to enter the details OR 0 to exit :- ");
      if (sc.nextLine().equals("1")) {
        System.out.println("Enter name of the customer :- ");
        String name = sc.nextLine();
        System.out.println("Enter Phone Number of the customer :- ");
        long phoneNumber = Long.parseLong(sc.nextLine());
        Contact newCustomerDetails = new Contact(name, phoneNumber);
        CustomerList.add(newCustomerDetails);
      } 
      else
        break;
    }
  }

  // this method we be used in MissedCall.java file to check whether it is a new number for the missedcall purpose 
  public static ArrayList<Contact> getCustomerList() {
    return CustomerList;
  }

  public void viewList() {
    for (Contact itr : CustomerList) 
      System.out.println(itr);
  }
}