package patientCRUD;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Insert() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		String patient_Id = request.getParameter("patient_id");
		String patient_name = request.getParameter("patient_name");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patientServlet","root","aditya");
			
			String insertStatement = "insert into patient values(?,?)";
			PreparedStatement p = (PreparedStatement) c.prepareStatement(insertStatement);
			p.setString(1, patient_Id);
			p.setString(2, patient_name);
			
			p.executeUpdate();
			
			PrintWriter out = response.getWriter();
			out.println("Inserted Successfully in Database!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}