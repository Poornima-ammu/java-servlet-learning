package register;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res) {
		String name=req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		String url="jdbc:mysql://localhost:3306/login_db";
		String uname="root";
		String password="Poornima@89";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,uname,password);
			PreparedStatement ps1=con.prepareStatement("Insert into users (username,password) values (?,?)");
			ps1.setString(1, name);
			ps1.setString(2, pass);
			ps1.executeUpdate();
			
			req.setAttribute("msg","Registration Sucessfull! Please Login");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
			con.close();
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
			}
		}
	
	


}
