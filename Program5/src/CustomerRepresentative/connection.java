package CustomerRepresentative;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class connection {
	public static Connection c;
	
	connection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/customerrepresentative","root","aditya");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
