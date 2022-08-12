package tshirt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AddTshirt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddTshirt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessories[] = request.getParameterValues("access");
		String tagLine = request.getParameter("tagline");
		String typeOfPocket = request.getParameter("pocket");
		String color = request.getParameter("color");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tshirtServlet", "root", "aditya");
			
			String selectedAccess = "";
			for(String s : accessories)
				selectedAccess += (s + " ");
			
			String query = "select count(*) from tshirts";
			PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			rs.next();
			int size = rs.getInt(1);
			
			int orderNo = 100 + size;
			
			String addTshirtQuery = "insert into tshirts values(?, ?, ?, ?, ?)";
			PreparedStatement stat = (PreparedStatement) conn.prepareStatement(addTshirtQuery);
			stat.setInt(1, orderNo);
			stat.setString(2, selectedAccess);
			stat.setString(3, tagLine);
			stat.setString(4, typeOfPocket);
			stat.setString(5, color);
			stat.executeUpdate();
			
			PrintWriter out = response.getWriter();
			out.print("T-Shirt inserted successfully!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
