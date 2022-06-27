package program6;
import java.sql.*;

public class connection {
  public static Connection c;
  connection() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      c = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientquestion", "root", "aditya");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}