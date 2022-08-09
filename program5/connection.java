package program5;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

class connection {
  public static Connection c;

  connection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/customerquestion", "root", "aditya");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}