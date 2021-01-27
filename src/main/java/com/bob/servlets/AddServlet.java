package com.bob.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet

//three methods -service,doGet,doPost
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k =i+j;
		System.out.println(k);
		
		//res.getWriter().println(k);   
		
//		//fowarding the result k to be used in  another servlet
//		req.setAttribute("k", k);
//		
////calling a servlet from a servlet -->requestDispatcher -->redirect
//		
//		RequestDispatcher rd = req.getRequestDispatcher("square");
//		rd.forward(req, res);
		
//using sendRedirect in place of requestDispatcher	
		
		//passing data to the second servlet
		//res.sendRedirect("square?k="+k); //method 1:url rewriting
		
		req.getSession().setAttribute("k", k); //method 2:http session 
		
		//method 3 :cookies
		Cookie cookie = new Cookie("k",k+"");
		res.addCookie(cookie);
		
		res.sendRedirect("square"); 
		
	}
}
