package com.bob.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SquareServlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		int j= 0;
		//int  j =(Integer) req.getAttribute("k");
		
		//int j = Integer.parseInt( req.getParameter("k"));
		
		//int j = (Integer) req.getSession().getAttribute("k");
		
		Cookie cookies[]=req.getCookies();
		
		for(Cookie c :cookies) {
			if(c.getName().equals("k")) {
				j =Integer.parseInt(c.getValue());
			}
		}
		
		int l =j*j;
		
		res.getWriter().println(l);
		
		//context params declared in web.xml--data  to be shared among all servlets
//		String author = getServletContext().getInitParameter("Author");
//		res.getWriter().println(author);
//		
		//context config declared within servlets---data is unique for each servlet
		String author = getServletConfig().getInitParameter("mwandishi");
		res.getWriter().println(author);
	}
}
