package telephone;

import java.util.Scanner;
import java.util.ArrayList;

public class MissedCallList {
  Scanner sc = new Scanner(System.in);
  ArrayList<MissedCall> missedCallList = new ArrayList<MissedCall>();

  public MissedCallList() {
    while (true) {
      System.out.println("Enter 1 to give the missed call or 0 to exit");
      int choice = Integer.parseInt(sc.nextLine());
      if (choice == 1) {
        System.out.println("Enter the phone number to which u wnat to give missed call:- ");
        long phoneNumber = Long.parseLong(sc.nextLine());
        if (missedCallList.size() > 3)
          missedCallList.remove(0);
        missedCallList.add(new MissedCall(phoneNumber));
        System.out.println("Missed call has been successfully given to the number :- " + phoneNumber);
      } else
        break;
    }
  }

  void display() {
    while (true) {
      System.out.println("Press the corresponding option to perform the corresponding action :- ");
      System.out.println("1) Delete any missed call");
      System.out.println("2) Display the Missed Call List ");
      System.out.println("3) Exit");
      int choice = Integer.parseInt(sc.nextLine());
      if (choice == 1) {
        System.out.println("Enter the phone number of the user whose record you want to delete:- ");
        long phone_Number = Long.parseLong(sc.nextLine());
        int index = 0;
        for (MissedCall itr : missedCallList) {
          if (itr.phone_number == phone_Number)
            break;
          index++;
        }
        missedCallList.remove(index);
        System.out.println("Data successfully deleted");
      } else if (choice == 2)
        for (MissedCall itr : missedCallList)
          System.out.println(itr);
      else
        break;
    }
  }
}
