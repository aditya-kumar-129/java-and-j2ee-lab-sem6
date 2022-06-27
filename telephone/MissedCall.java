package telephone;
import java.time.LocalDateTime;

public class MissedCall {
  String name = "private caller";
  long phone_number;
  LocalDateTime localtime;

  public MissedCall(long phone__Number) {
    this.phone_number = phone__Number;
    localtime = LocalDateTime.now();
    for (Contact itr : ContactList.getCoustomerList()) {
      if (itr.phoneNumber == phone_number) {
        this.name = itr.name;
        break;
      }
    }
  }

  public String toString() {
    return "MissedCall [name=" + name + ", phone_number=" + phone_number + ", localtime=" + localtime + "]";
  }
}