﻿package ch06.ex04.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ;		
		String userName = "陌生人" ; 
		String time = "";
		Cookie[] cookies  = request.getCookies();
		for ( int i = 0 ; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if ( cookie.getName().equals("username")) 
				userName = URLDecoder.decode(cookie.getValue(), "UTF-8") ;  
			if ( cookie.getName().equals("time")) 
				time = cookie.getValue();
		}
		out.println("<html><body><H1>Get Cookies</H1>");
		out.println("Hello, " + userName + "<BR>");
		if ( time.length() > 0 ) {
		    out.println("您上次拜訪時間為" + time + "<BR>");
		}
		out.println("<P><CENTER><HR>");
		out.println("<small>&lt;&lt;<a href='_ch06.jsp'>回第六章首頁</a>&gt;&gt;</small>");
		out.println("</CENTER>");
		out.println("</body></html>");	
	}
}
