package ch02.ex11.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
	urlPatterns="/ch02/requestInfo/request.do"
)
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Request Information Example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Request Information Example(Servlet 3.0)</h2>");
        out.println("<h3>本畫面由Servlet直接產生</h3>");
        out.println("<P>Request URI: " + request.getRequestURI());
        out.println("<P>QueryString: " + request.getQueryString());        
        out.println("<P>Context Path: " + request.getContextPath());
        out.println("<P>Servlet Path: " + request.getServletPath());
        out.println("<P>Server Name: " + request.getServerName());
        out.println("<P>SessionId: " + request.getRequestedSessionId());
        out.println("<P>Method: " + request.getMethod());
        out.println("<P>Protocol: " + request.getProtocol());
        out.println("<P>Remote Address: " + request.getRemoteAddr());
        out.println("<P><HR><CENTER><small>&lt;&lt;<a href='../index.jsp'>回第二章首頁</a>&gt;&gt;</small></CENTER>");
        
        out.println("</body>");
        out.println("</html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        doGet(request, response);
    }
}
