package patientCRUD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patientId = request.getParameter("patient_id");
		String updatedPatientName = request.getParameter("updated_patient_name");		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patientServlet","root","aditya");
			
			String updated_statement = "update patient set patient_name = ? where patient_Id = ?";
			PreparedStatement p = (PreparedStatement) c.prepareStatement(updated_statement);
			p.setString(1, updatedPatientName );
			p.setString(2, patientId);
			p.executeUpdate();
			
			PrintWriter out = response.getWriter();
			out.println("Name updated successfully!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}