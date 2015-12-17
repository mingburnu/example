package misc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerBean;

public class LoginFilter implements Filter {
	@Override
	public void destroy() {

	}
	@Override
	public void doFilter(ServletRequest req,
			ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession();
		CustomerBean bean = (CustomerBean) session.getAttribute("user");
		if(bean!=null) {
			chain.doFilter(request, response);

		} else {
			String path = request.getContextPath();
			
			String uri = request.getRequestURI();
			uri = uri.replace(path, "");
			session.setAttribute("dest", uri);
			
			response.sendRedirect(path+"/secure/login.jsp");
		}
	}
	private FilterConfig config;
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
