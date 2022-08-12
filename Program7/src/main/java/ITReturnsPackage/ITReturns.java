package ITReturnsPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class ITReturns extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ITReturns() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name  = request.getParameter("name");
		String gender = request.getParameter("gender");
		String salary = request.getParameter("salary");
		String tax = request.getParameter("tax");
		
		PrintWriter out = response.getWriter();
		out.println(name + " " + gender + " " + salary + " " + tax);

		File file = new File("C:\\Users\\adity\\Desktop\\a.txt");
		FileOutputStream fout = new FileOutputStream(file);
		fout.write((name + " " + gender + " " + salary + " " + tax).getBytes());
		fout.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
