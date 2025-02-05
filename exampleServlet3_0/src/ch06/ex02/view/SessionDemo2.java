﻿package ch06.ex02.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(
	urlPatterns="/ch06/SD2.do"
)
public class SessionDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter() ; 
		out.println("(Servlet 3.0)<p/>");
		out.println("測試Session是否存在<br>");
		HttpSession session = request.getSession(false) ;
		if (session == null ) {
			out.println("找不到已經存在session, ...<br>");
			out.println("因此，沒有小狗的名字..." );
		} else {
			out.println("找到已經存在session<BR>");
			String dogName = (String)session.getAttribute("dog");
			out.println("透過Session物件來取出屬性物件，它的值為" + dogName);			
		}
		out.println("<P><CENTER><HR>");
		out.println("<small>&lt;&lt;<a href='_ch06.jsp'>回第六章首頁</a>&gt;&gt;</small>");
		out.println("</CENTER>");
	}
}
