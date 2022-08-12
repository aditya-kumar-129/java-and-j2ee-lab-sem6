package patientCRUD;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public View() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patientservlet","root","aditya");
			
			String ReadData = "select * from patient";
			PreparedStatement p = c.prepareStatement(ReadData);
			ResultSet res = p.executeQuery();
			
			PrintWriter out = response.getWriter();
			out.println("The data present in the table are as follows:- ");
			
			while(res.next()) {
				out.println("Patient Id : "+ res.getString("patient_Id") + " with Patient Name : " + res.getString("patient_name"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
