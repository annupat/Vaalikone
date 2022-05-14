package filter;

import java.util.Hashtable;
import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

@WebFilter(dispatcherTypes = {
								DispatcherType.REQUEST,
								DispatcherType.FORWARD,
								DispatcherType.INCLUDE,
								DispatcherType.ERROR
						}
						, urlPatterns = {"/rest/questionservice/readalladminquestions"})

public class AuthFilter implements Filter {
	Hashtable<String, String> ValidUsers = new Hashtable<>();
	
	public AuthFilter() {
}
	
		public void destroy() {
			
		}

		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
						throws IOException, ServletException {
			doFilter((HttpServletRequest)request, (HttpServletResponse)response, chain);
		}
		
		public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
			String auth = request.getHeader("Authorization");
			
			if (!allowUser(auth)) {
				response.setHeader("WWW-Authenticate", "BASIC realm=\"Salainen\"");
				response.sendError(response.SC_UNAUTHORIZED);
			} else {
				chain.doFilter(request, response);
			}
			}
		public void init(FilterConfig fConfig) throws ServletException {
		}
		
		public void getUser() {
			ValidUsers.put("admin:salasana", "authorized");
		}
		
		protected boolean allowUser(String auth) throws IOException {
			getUser();
			if (auth == null) {
				return false;
			}
			if (!auth.toUpperCase().startsWith("BASIC ")) {
				return false;
			}
			String userpassEncoded = auth.substring(6);
			Base64 base64 = new Base64();
			String userpassDecoded = new String(base64.decode(userpassEncoded.getBytes()));
			
			if ("authorized".contentEquals(ValidUsers.get(userpassDecoded))) {
				return true;
			} else {
				return false;
			}
		}
}