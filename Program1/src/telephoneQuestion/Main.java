package telephoneQuestion;

public class Main {
	
	public static void main(String[] args) {
		ContactList contactListObject = new ContactList();
		contactListObject.displayContact();
		
		MissedCallList missedCallListObject = new MissedCallList();
		missedCallListObject.diaplay();
	}
}