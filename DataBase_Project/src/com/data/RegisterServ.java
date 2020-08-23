package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServ extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pw =resp.getWriter();
		String Name=req.getParameter("user_name");
		String password=req.getParameter("user_password");
		String Email=req.getParameter("user_email");
		
		pw.println(Name);
		pw.println(password);
		pw.println(Email);
		//connexction......
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexample","root","saruu");
			//query.....
			String s="insert into jdb32(Name,password,Email) values(?,?,?)";
			 PreparedStatement pst =con.prepareStatement(s);
			 pst.setString(1,Name);
			 pst.setString(2,password);
			 pst.setString(3,Email);
			 
			pst.executeUpdate();
			 pw.print("<h1>successfull<h1>");
		} catch (Exception e) {
			e.printStackTrace();
			//pw.println("<h1>ERRor</h1>");
			
		}
		
		
		
			
	}

}
