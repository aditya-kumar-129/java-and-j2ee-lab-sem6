package telephoneQuestion;
import java.time.LocalDateTime;

public class MissedCall {
	String name = "Private Caller";
	LocalDateTime localdate;
	long phone_number;
	public MissedCall(long phone__number) {
		this.phone_number = phone__number;
		localdate = LocalDateTime.now();
		for(Contact itr : ContactList.getContactList()) {
			if(itr.phoneNumber == phone_number) {
				this.name = itr.name;
				break;
			}
		}
	}
	
	public String toString() {
		return "MissedCall [name=" + name + ", localdate=" + localdate + ", phone_number=" + phone_number + "]";
	}
}