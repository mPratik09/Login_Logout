

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newUser")
public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		INSTEAD OF USING THIS PAGE(seperate page), WOTE BELOW CODE IN "CreateNewUser.java" FILE 		
    	
//		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_user		lk.	html");
//		rd.forwardddddd(request, response);
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
