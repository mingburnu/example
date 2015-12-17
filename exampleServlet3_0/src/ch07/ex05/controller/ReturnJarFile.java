package ch07.ex05.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(
	urlPatterns="/ch07/images.jar"
)
public class ReturnJarFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/jar");
        
        ServletContext ctx = getServletContext() ;         
        InputStream is = ctx.getResourceAsStream("/WEB-INF/data/images.jar");
        
        int count = 0 ; 
        byte[] bytes = new byte[1024];
        OutputStream os = response.getOutputStream();
        while ((count = is.read(bytes)) != -1 ) {
            os.write(bytes, 0, count);
        }
        os.flush();
        os.close();
	}
}
