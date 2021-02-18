package Package;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegInsert() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int regno = Integer.parseInt(request.getParameter("regno"));
		String StdName = request.getParameter("StdName");
		String emailid = request.getParameter("emailid");
		String pswd = request.getParameter("pswd");
		int year = Integer.parseInt(request.getParameter("year"));
		String sec = request.getParameter("sec");
		RegBean rb = new RegBean();
		rb.setRegno(regno);
		rb.setStdName(StdName);
		rb.setEmailid(emailid);
		rb.setPswd(pswd);
		rb.setYear(year);
		rb.setSec(sec);
		
		RegDAO dao = new RegDAO();
		try {
			int i = dao.reg_insert(rb);
			if(i > 0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				request.setAttribute("RegisterBean",rb);
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("error.html");
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
