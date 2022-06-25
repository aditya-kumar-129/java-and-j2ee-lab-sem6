package telephone;
import java.util.*;

public class MissedCallList {
  Scanner sc = new Scanner(System.in);
  ArrayList<MissedCall> missedCallList = new ArrayList<MissedCall>();

  public MissedCallList() {
    while (true) {
      System.out.println("Enter yes to give missedcall :- ");
      if (sc.nextLine().equals("yes")) {
        System.out.println("Enter number : ");
        long num = Long.parseLong(sc.nextLine());
        // if the length of the missedCallList length becomes greater than 4 then in that case add the first element and then add the current element
        if (missedCallList.size() > 4)
          missedCallList.remove(0);
        missedCallList.add(new MissedCall(num));
      }
      else
        break;
    }
  }

  public void viewLog() {
    Iterator<MissedCall> itr = missedCallList.iterator();
    while (true) {
      System.out.println("Enter option\n1.) delete any missedcall\n2.) display missedcall\n3.) Exit");
      int choice = sc.nextInt();
      sc.nextLine();
      if (choice == 1) {
        System.out.println("Enter the number whose call you wish to delete: ");
        long phoneNumberToBeDeleted = Long.parseLong(sc.nextLine());
        while (itr.hasNext())
          if (itr.next().phone_Number == phoneNumberToBeDeleted)
            itr.remove();
        System.out.println("Successfully deleted");
      } 
      else if (choice == 2)
        for (MissedCall it : missedCallList)
          System.out.println(it);
      else
        break;
    }
  }
}
