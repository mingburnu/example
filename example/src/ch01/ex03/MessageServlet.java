﻿package ch01.ex03;
import java.io.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;

public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	   throws IOException, ServletException {
	    
	   response.setContentType("text/html; charset=UTF-8") ;
	   PrintWriter out = response.getWriter() ;

	   String[] msg = {"這是一個自訂標籤", 
	                   "現有的 Servlet Containers 包括: Tomcat(Apache), WebSphere(IBM)",
	                   "以及 JRun(Macromedia), Resin(Caucho Technology), WebLogic(BEA)",
	                   "中華棒隊：洋基放行，王建民奧運可投2場" } ;
	   String[]  colorType = {"RED", "PURPLE", "BLUE", "GREEN"} ;
	   out.println("<html><body><center><h1>由Servlet產生輸出資料</h1><p><p>") ;
       int i = (int)(Math.random() * msg.length ) ; 
       
	   out.println("<FONT COLOR='" + colorType[i] +"' >") ;
	   out.println("隨機訊息為:" + msg[i]) ;
	   String referer = request.getHeader("referer"); 
       out.println("<br><P><P><P><hr><center><small>&lt;&lt;<a href=" + referer + ">回前頁</a>&gt;&gt;</small>");
	   out.println("</FONT>") ;
	   out.println("</center></body></html>") ;
	   out.close() ;
   }
}   