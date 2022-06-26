package program5;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
  public static Connection c;

  connection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerquestion", "root", "aditya");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
