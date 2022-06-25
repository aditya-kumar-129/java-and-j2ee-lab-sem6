package telephone;
import java.time.LocalDateTime;

public class MissedCall {
  String name = "private caller";
  long phone_Number;
  LocalDateTime localTime;

  public MissedCall(long phone_Number) {
    this.phone_Number = phone_Number;
    this.localTime = LocalDateTime.now();
    for (Contact itr : ContactList.getCustomerList()) {
      if (itr.phoneNumber == phone_Number) {
        this.name = itr.name;
        break;
      }
    }
  }

  public String toString() {
    return "Name of the customer is :- " + name + ", and his Phone number is :- " + phone_Number + ", He/she called at time :- " + localTime;
  }
}
