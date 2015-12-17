package ch08_01;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import ch06_01.*;

public class LoginFilter implements Filter {
    Collection<String>  url = new ArrayList<String>();
	public void destroy() {

	}

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (request instanceof ServletRequest
                && response instanceof ServletResponse) {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            String servletPath = req.getServletPath();
            System.out.println("111--->" + servletPath);
            if (mustLogin(servletPath)) {
                if (checkLogin(req)) {
                    System.out.println("222-->需要Login, 已經Login");
                    chain.doFilter(request, response);
                } else {                    
                    HttpSession session = req.getSession();
                    session.setAttribute("target", req.getServletPath());
                    System.out.println("333-->需要Login, 尚未Login , ServletPath=" + req.getServletPath());
                    RequestDispatcher rd = request
                            .getRequestDispatcher("/ch06_01/login.jsp");
                    rd.forward(req, resp);
                }
            } else {
                System.out.println("444-->不需要Login ");
                chain.doFilter(request, response);
            }
        } else {
            throw new ServletException("Request/Response Type Error");
        }
    }


	public void init(FilterConfig fConfig) throws ServletException {
         Enumeration<String> e = fConfig.getInitParameterNames();
         while(e.hasMoreElements()){
        	 String name = e.nextElement();
        	 url.add(fConfig.getInitParameter(name));
         }
	}
	 private boolean mustLogin(String servletPath) {
	     boolean login = false;
	     for (String sURL : url) {
	         if (sURL.endsWith("*")) {
	             sURL = sURL.substring(0, sURL.length() - 1);
	             if (servletPath.startsWith(sURL)) {
	                 login = true;
	                 break;
	             }
	         } else {
	             if (servletPath.equals(sURL)) {
	                 login = true;
	                 break;
	             }
	         }
	     }
	     return login;
	 }

	 private boolean checkLogin(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     MemberBean loginToken = (MemberBean) session.getAttribute("LoginOK");
	     if (loginToken == null) {
	         return false;
	     } else {
	         return true;
	     }
	 }

}
