package loginServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/login")

 
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {

	    // redirect to login page
	    res.sendRedirect("login.html");
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws  ServletException ,IOException{
		String user=req.getParameter("uname");
		String pass=req.getParameter("Password");
		
		String url="jdbc:mysql://localhost:3306/login_db";
		String name="root";
		String password="Poornima@89";
		String sql1="Select * from users where username=?";
		boolean valid=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,name,password);
			PreparedStatement ps1=con.prepareStatement(sql1);
			ps1.setString(1, user);
			
			ResultSet rs=ps1.executeQuery();
			if(!rs.next()) 
			{
			PrintWriter out1=res.getWriter();
			req.setAttribute("msg","User Not Found . Please Register");
			RequestDispatcher rd=req.getRequestDispatcher("register.html");
			rd.include(req, res);	
		   }
		else {
			String sql2="Select * from users where username=? and password=?";
			PreparedStatement ps2=con.prepareStatement(sql2);
			ps2.setString(1, user);
			ps2.setString(2, pass);
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next()) 
			{
		
			RequestDispatcher rd=req.getRequestDispatcher("dashboard");
			rd.forward(req, res);	
		   }
			else {
			PrintWriter out=res.getWriter();
			out.println("Invalid Credentials");
			RequestDispatcher rd=req.getRequestDispatcher("login");
			rd.include(req, res);		
		}
		}
			con.close();
		}
		
			catch(Exception e) {
				e.printStackTrace();
			}
	}
}
	
