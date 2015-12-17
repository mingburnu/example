package ch01;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class LotteryServlet2
 */
public class LotteryServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
	         request.setCharacterEncoding("UTF-8");
	         String name = request.getParameter("visitor");
	         if (name == null || name.trim().length() == 0) {
	            name = "訪客";
	         }
	         String type = request.getParameter("numberType");
	         Collection<Integer> coll = null;
	         LotteryBean lottery = new LotteryBean();
	         if (type.equalsIgnoreCase("FOURSTARS")) {
	            lottery.setLowerBound(0);
	            lottery.setUpperBound(9);
	            lottery.setBallNumber(4);
	            coll = lottery.getFourStars();
	         } else if (type.equalsIgnoreCase("BIG")) {
	            lottery.setLowerBound(1);
	            lottery.setUpperBound(49);
	            lottery.setBallNumber(6);
	            coll = lottery.getLuckyNumbers();
	         } else if (type.equalsIgnoreCase("MID")) {
	             lottery.setLowerBound(1);
	             lottery.setUpperBound(42);
	             lottery.setBallNumber(6);
	             coll = lottery.getLuckyNumbers();
	          } else if (type.equalsIgnoreCase("SMALL")) {
	             lottery.setLowerBound(1);
	             lottery.setUpperBound(39);
	             lottery.setBallNumber(5);
	             coll = lottery.getLuckyNumbers();
	          }
	          request.setAttribute("visitName", name);
	          request.setAttribute("luckyNumber", coll);
	          RequestDispatcher rd = 
	                   request.getRequestDispatcher("/ch01/goodLuck.jsp");
	          rd.forward(request, response);
	          return;
	       } catch (UnsupportedEncodingException e) {
	          throw new ServletException(e);
	       }

	}


}
