
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/createNewUser")
public class CreateNewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement stmnt;

	public CreateNewUser() {
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
		System.out.println("Create new User");
    	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_user.html");
    	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailId = request.getParameter("emailid");
		String password = request.getParameter("password");
		String password_02 = request.getParameter("password_02");

		try {
			if (password.equals(password_02)) {
				stmnt.executeUpdate("insert into login02 values('" + emailId + "', '" + password + "')");
				JOptionPane.showMessageDialog(null, "Thank you for registering..", "Welcome Note",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Password did not match!!..", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_user.html");
			rd.include(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
