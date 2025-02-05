﻿package ch07.ex01.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	urlPatterns="/ch07/initParameter.do",
	initParams={
			@WebInitParam(name = "discount", value = "0.65")
	}
)
public class GetInitParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double discount;

	public void init() throws ServletException {
		try {
			String s = getInitParameter("discount");
			if (s != null) {
				discount = Double.parseDouble(s);
			} else {
				discount = -1;
			}
		} catch (NumberFormatException e) {
			discount = 1.0;
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		out.println("<HTML>");
		out.println("<HEAD><TITLE>設定Servlet的起始參數</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h2>本程式說明如何設定Servlet的起始參數(Servlet 3.0)</h2>");
		out.println("經由web.xml內的<servlet>標簽，我們可以設定某個Servlet的起始參數:<p>");

		out.println("<pre>");
		out.println("&lt;init-param&gt;");
		out.println("&nbsp;&nbsp;&nbsp;&lt;param-name&gt;discount&lt;/param-name&gt;");
		out.println("&nbsp;&nbsp;&nbsp;&lt;param-value&gt;0.65&lt;/param-value&gt;");
		out.println("&lt;/init-param&gt;");
		out.println("</pre><P><P>範例:");
		out.println("本Servlet的起始參數 discount 為" + discount);
		out.println("<P><font color='red'><small>本畫面直接由Servlet產生</small></font>");
		String refer = req.getHeader("referer");
		out.println("<P><HR><small>&lt;&lt;&nbsp;<a href='" + refer + "'>回前頁</a>&nbsp;&gt;&gt;</small>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}
}