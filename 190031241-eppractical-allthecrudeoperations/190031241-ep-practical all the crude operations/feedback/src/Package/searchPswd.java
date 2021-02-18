package Package;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class searchPswd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public searchPswd() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailid = request.getParameter("emailid");
		String pswd = request.getParameter("pswd");
		
		RegBean lb = new RegBean();
		lb.setEmailid(emailid);
		lb.setPswd(pswd);
		
		LogDAO log = new LogDAO();
		String s = "";
		
		try {
			s = s+log.search(emailid);
			
			if(s.equals(pswd)){
				Cookie ck = new Cookie("email_save",emailid);
				RequestDispatcher rd = request.getRequestDispatcher("feedback.html");
				rd.include(request, response);
				response.addCookie(ck);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("error_login.html");
				rd.include(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
}
