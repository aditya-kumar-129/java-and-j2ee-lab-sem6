package telephoneQuestion;

import java.util.*;

public class MissedCallList {
	Scanner sc = new Scanner(System.in);
	ArrayList<MissedCall> missedCallList = new ArrayList<MissedCall>();
	public MissedCallList() {
		while(true) {
			System.out.println("Enter 1 to add a missed Call or 0 to exit");
			int choice = Integer.parseInt(sc.nextLine());
			if(choice==1) {
				System.out.println("Enter the Phone Number");
				long phoneNumber = Long.parseLong(sc.nextLine());
				if(missedCallList.size()>3)
					missedCallList.remove(0);
				missedCallList.add(new MissedCall(phoneNumber));
				System.out.println("Missed Call has been successfully given to phone Number:- " + phoneNumber);	
			}
			else
				break;
		}
	}
	
	void diaplay() {
		while(true) {
			System.out.println("Enter the corresponding number to perform the corresponding operation :- ");
			System.out.println("Enter 1 to delete a Number from MissedCallList");
			System.out.println("Enter 2 to display MissedCallList");
			System.out.println("Enter 3 to exit");
			int choice = Integer.parseInt(sc.nextLine());
			if(choice==1) {
				System.out.println("Enter the phone Number that you want to delete");
				long phoneNumnerToBedeleted = Long.parseLong(sc.nextLine());
				int index=0;
				for(MissedCall it :missedCallList) {
					if(it.phone_number == phoneNumnerToBedeleted)
						break;
					index++;
				}
				missedCallList.remove(index);
			}
			else if(choice ==2) {
				for(MissedCall it : missedCallList)
					System.out.println(it);
			}
			else
				break;
		}
	}
}