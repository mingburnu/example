package com.abc;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(
	urlPatterns={"/ch01/helloAgain.jsp"}
)
public class HahaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Writer out = response.getWriter();
		out.write("哈哈，大家好!!!(Servlet 3.0)<BR>");
		String reqURI = request.getRequestURI();
		out.write("requestURI="+ reqURI   +"<BR>");

		RequestDispatcher  rd = request.getRequestDispatcher("/commons/previousPage.jsp");
		rd.include(request, response);
		return;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
