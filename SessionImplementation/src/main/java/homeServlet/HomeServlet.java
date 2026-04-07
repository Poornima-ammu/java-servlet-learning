package homeServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
		res.setContentType("text/html");

		PrintWriter out=res.getWriter();
		Cookie[]cookies=req.getCookies();
		String userfromCookie=null;
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("user")) {
					userfromCookie=c.getValue();
				}
			}
		}
		HttpSession session=req.getSession(false);
		if(session ==null && userfromCookie!=null) {
			session=req.getSession();
			session.setAttribute("user",userfromCookie);
		}
		
	
		if(session!=null && session.getAttribute("user")!=null ){
			String user=(String)session.getAttribute("user");
			out.println("<h2>Welcome "+user+"</h2>");
			out.println("<br><a href='logout'>Logout</a>");
			
		}
		else {
			res.sendRedirect("login");
			
		}
	}
}