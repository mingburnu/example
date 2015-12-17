package ch02.ex07.controller;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SendRedirect1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> sites = new ArrayList<String>();
    public void init() {
         sites.add("http://www.mlb.com");
         sites.add("http://java.sun.com");
         sites.add("http://tw.yahoo.com");
         sites.add("http://tw.msn.com");
         sites.add("http://www.oreilly.com.tw");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	  throws ServletException, IOException {
		int index = (int)(Math.random()*sites.size());
		String site = (String)sites.get(index);
		// 通知瀏覽器對新網址發出請求(彷彿使用者在瀏覽器輸入新的網址)入
		response.sendRedirect(site);
	}
}