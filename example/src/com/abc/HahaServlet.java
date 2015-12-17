package com.abc;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class HahaServlet
 */
public class HahaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HahaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Writer out = response.getWriter();
		out.write("哈哈，大家好!!!<BR>");
		String reqURI = request.getRequestURI();
		out.write("requestURI="+ reqURI   +"<BR>");

		RequestDispatcher  rd = request.getRequestDispatcher("/commons/previousPage.jsp");
		rd.include(request, response);
		return;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
