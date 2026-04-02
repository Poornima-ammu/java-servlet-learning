package com.login;

import jakarta.servlet.ServletException;

import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
@WebServlet("/demo")

public class LoginServelet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	        throws ServletException, IOException {

	    res.getWriter().println("Use form submission bro (POST method)");
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException {
		String user=req.getParameter("fn");
		String password=req.getParameter("pass");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		System.out.println("Servlet called");
		System.out.println("User: " + user);
		System.out.println("Pass: " + password);
		
		/*if(user.equals("admin") && password.equals("1234"))
		{
			out.println("<h1>Login Sucessful</h1>");
		}
		else {
			out.println("<h1>Invalid Credentails</h1>");

		}*/
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db","root","Poornima@89");
			PreparedStatement ps=con.prepareStatement("Select * from user where username=? and password=?");
			ps.setString(1,user);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				out.println("<h1 >Login Sucessful</h1>");
			}
			else {
				out.println("<h1>Invalid Credentails</h1>");

			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		    out.println("<h2>Error: " + e.getMessage() + "</h2>");

			
		}
	}
}
