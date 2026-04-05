package dashboardServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet 
{
		protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{
			PrintWriter out=res.getWriter();
			RequestDispatcher rd1=req.getRequestDispatcher("header.html");
			rd1.include(req, res);
			  
			out.println("<h1>Welcome to Dashboard</h1>");
			
			RequestDispatcher rd2=req.getRequestDispatcher("footer.html");
			rd2.include(req, res);
			
		}
	}