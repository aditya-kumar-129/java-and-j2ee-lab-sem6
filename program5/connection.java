package program5;
import java.sql.*;

class connection {
  public static Connection c;

  connection() {
    try {
      Class.forName("com.mysql.jdbc.driver");
      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerquestion", "root", "aditya");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}