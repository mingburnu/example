package misc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(
		urlPatterns={"/*"}
)
public class EncodingFilter implements Filter {
	@Override
	public void destroy() {

	}
	@Override
	public void doFilter(ServletRequest req,
			ServletResponse resp, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
	request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}
	private FilterConfig config;
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
}
