
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private Connection con;
	private Statement stmnt;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_logout_02", "root", "Mysql");
			stmnt = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailId = request.getParameter("emailid");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		
		try {
			ResultSet results = stmnt.executeQuery("select * from login02 where emailid = '"+emailId+"' and password = '"+password+"'");
			if(results.next()) {
 				session.setAttribute("email_Id", emailId);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/createCustomer.html");
				rd.forward(request, response);
				JOptionPane.showMessageDialog(null, "Welcome Sir..", "Welcome Note", JOptionPane.INFORMATION_MESSAGE);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				JOptionPane.showMessageDialog(null, "Invalid Parameteers..", "Warning", JOptionPane.WARNING_MESSAGE);		
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
