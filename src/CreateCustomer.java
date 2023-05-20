
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

@WebServlet("/createCustomer")
public class CreateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement stmnt;
	
	public CreateCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_logout_02", "root", "Mysql");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_app_01", "root", "Mysql");
			stmnt = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		try {
//		int num3 = stmnt.executeUpdate("delete from customer_02 where name = 'QuiLL'");
//		PrintWriter out = response.getWriter();
//		out.println(num3);
//		}catch (Exception e) {
//			System.out.println(e);
//		}
		
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/createCustomer.html");
//		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String emailId = request.getParameter("emailid");
		String number = request.getParameter("phone_no");
		String city = request.getParameter("city");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			try {
//				int num = stmnt.executeUpdate("create table customer_02 (name varchar(20), emailid varchar(20), phone_no varchar(10), city varchar(20))");
//				int num = stmnt.executeUpdate("delete from customer_02 where name = 'quill'");
	
				int num = stmnt.executeUpdate("insert into customer02 values ('"+name+"', '"+emailId+"', '"+number+"', '"+city+"')");
				out.println(num);
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
	}
	
}






