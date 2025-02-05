﻿package ch06.ex01.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ; 
		out.println("測試session.isNew()<br>");
		HttpSession session = request.getSession() ; 
		if (session.isNew() ) {
			out.println("這是一個新的session<br>");  
		} else {
			out.println("這是一個舊的session<br>");			
		}
		String dogName = (String)session.getAttribute("dog");
		out.println("透過Session物件來取出屬性物件，它的值為" + dogName);
		out.println("<P><p><CENTER><HR>");
		out.println("<small>&lt;&lt;<a href='_ch06.jsp'>回第六章首頁</a>&gt;&gt;</small>");
		out.println("</CENTER>");
	}
}
