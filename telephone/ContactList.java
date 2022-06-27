package telephone;

import java.util.Scanner;
import java.util.ArrayList;

public class ContactList {
  Scanner sc = new Scanner(System.in);
  static ArrayList<Contact> customerList = new ArrayList<Contact>();

  public ContactList() {
    while (true) {
      System.out.println("Press 1 to enter the details of the customer and 0 to exit");
      int choice = Integer.parseInt(sc.nextLine());
      if (choice == 1) {
        System.out.println("Enter the name of the customer :- ");
        String name = sc.nextLine();
        System.out.println("Enter the Phone Number of the customer :- ");
        long phoneNumber = Long.parseLong(sc.nextLine());
        Contact newCustomerContactDetails = new Contact(name, phoneNumber);
        customerList.add(newCustomerContactDetails);
      } else
        break;
    }
  }

  public static ArrayList<Contact> getCoustomerList() {
    return customerList;
  }

  public void displayCustomer() {
    for (Contact itr : customerList)
      System.out.println(itr);
  }
}