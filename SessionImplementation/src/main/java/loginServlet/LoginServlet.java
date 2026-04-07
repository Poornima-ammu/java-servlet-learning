package loginServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String user=req.getParameter("uname");
		String pass=req.getParameter("password");
		String remember=req.getParameter("remember");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db","root","Poornima@89");
			PreparedStatement ps=con.prepareStatement("Select * from users where username=? and password=?");
			ps.setString(1, user);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				HttpSession session=req.getSession();
				session.setAttribute("user",user);
				
				//cookie
				if(remember!=null) {
					Cookie ck=new Cookie("user",user);
					ck.setMaxAge(60*60);
					res.addCookie(ck);
					ck.setHttpOnly(true);
					ck.setPath(remember);
				}
				res.sendRedirect("home");
			}
			else {
				res.sendRedirect("login");
			}
			rs.close();
			ps.close();
			con.close();;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
	