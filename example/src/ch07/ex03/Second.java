﻿package ch07.ex03 ;
import javax.servlet.http.* ;
import javax.servlet.* ;
import java.io.* ;

public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;
   static {
       System.out.println("Servlet Second is being loaded") ;
   }
   public void doGet(HttpServletRequest req,
                     HttpServletResponse res) throws
                     IOException, ServletException {
       res.setContentType("text/html; charset=UTF-8") ;
       PrintWriter out = res.getWriter() ;
       out.println("Hello World, Second") ;
   }
   public void doPost(HttpServletRequest req,
                     HttpServletResponse res) throws
                     IOException, ServletException {
       doGet(req, res) ;
   }
}     