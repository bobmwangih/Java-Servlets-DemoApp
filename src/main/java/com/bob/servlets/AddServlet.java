package com.bob.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet

//three methods -service,doGet,doPost
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k =i+j;
		System.out.println(k);
		
		res.getWriter().println(k);
	}
}
