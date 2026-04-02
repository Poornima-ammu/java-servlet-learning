package com.login;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/demo")

public class LoginServelet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException {
		String user=req.getParameter("fn");
		String password=req.getParameter("pass");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		if(user.equals("admin") && password.equals("1234"))
		{
			out.println("<h1>Login Sucessful</h1>");
		}
		else {
			out.println("<h1>Invalid Credentails</h1>");

		}
	}
}