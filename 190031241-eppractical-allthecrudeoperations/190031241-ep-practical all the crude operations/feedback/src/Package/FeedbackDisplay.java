package Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FeedbackDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String listQ1 = request.getParameter("listQ1");
		String listQ2 = request.getParameter("listQ2");
		String listQ3 = request.getParameter("listQ3");
		String listQ4 = request.getParameter("listQ4");
		String listQ5 = request.getParameter("listQ5");
		FeedbackBean fb = (FeedbackBean) request.getAttribute("feedbackBean");
		PrintWriter pw = response.getWriter();
		pw.print("Welcome "+fb.getStdName()+"\t"+fb.getRegno()+"\n");
		pw.print("1. How are your Classes going, Are they Regular ? : "+listQ1+"\n");
		pw.print("2. Was faculty good at explaining things ? : "+listQ2+ "\n");
		pw.print("3. Was faculty effective in leading the Class ? : "+listQ3+"\n");
		pw.print("4. Stimulated Interest in the class by faculty ? : "+listQ4+"\n");
		pw.print("5. Are the syllabus completed by faculty in time ? : "+listQ5+"\n");
	}

}
