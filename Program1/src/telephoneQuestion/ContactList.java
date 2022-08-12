package telephoneQuestion;
import java.util.*;

public class ContactList {
	Scanner sc = new Scanner(System.in);
	static ArrayList<Contact> contactList = new ArrayList<Contact> ();
	ContactList(){
		while(true) {
			System.out.println("Enter 1 to add more customer and 0 to exit");
			int choice = Integer.parseInt(sc.nextLine());
			if(choice==1) {
				System.out.println("Enter the name:- ");
				String name = sc.nextLine();
				System.out.println("Enter the phone Number:- ");
				long phoneNumber = Long.parseLong(sc.nextLine());
				Contact newContactDetails = new Contact(name,phoneNumber);
				contactList.add(newContactDetails);
			}
			else
				break;
		}
	}
	
	//	You have to make this method static as you call this method without creating the object in MissedCall.java file
	public static ArrayList<Contact> getContactList() {
		return contactList;
	}
	
	public void displayContact() {
		for(Contact itr : contactList)
			System.out.println(itr);
	}
}
