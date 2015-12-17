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

import org.apache.commons.codec.binary.Base64;

@WebFilter(
		urlPatterns={"/secure/*"}
)
public class BasicFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req,
			ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String auth = request.getHeader("Authorization");
		if(auth==null || auth.length()==0) {
			response.setStatus(
					HttpServletResponse.SC_UNAUTHORIZED);
			response.setHeader(
					"WWW-Authenticate", "Basic realm=\"BasicWeb\"");
		} else {
			auth = auth.substring(6);
			byte[] temp = Base64.decodeBase64(auth.getBytes());
			auth = new String(temp);
			System.out.println(auth);
			
			
			
			
		}
	}

	private FilterConfig config;
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	@Override
	public void destroy() {

	}
}
