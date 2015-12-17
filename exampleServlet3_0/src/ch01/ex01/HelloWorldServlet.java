package ch01.ex01;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
// 有兩種方式定義一個Servlet
// 簡式
@WebServlet("/ch01/sayHelloServlet")
// 正常式
/*
@WebServlet(
	name = "HelloWorld", 
	urlPatterns = { "/ch01/sayHelloServlet" }
) 
*/
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException{
    	  response.setContentType("text/html; charset=UTF-8");
          PrintWriter pw = response.getWriter();
          pw.println("<html>");
          pw.println("<head><title>Hello, World 大家好 (Servlet 3.0)</title>");
          pw.println("</head>");
          pw.println("<body>");
          pw.println("<H3>Hello, World 大家好(Servlet 3.0)</H3>");
          java.util.Date d = new java.util.Date();
          pw.println("現在時刻是" + d);
          String referer = request.getHeader("referer"); 
          pw.println("<br><P><P><P><hr><center><small>&lt;&lt;<a href=" + referer + ">回前頁</a>&gt;&gt;</small>");
          pw.println("</body>");
          pw.println("</html>");
    }
}