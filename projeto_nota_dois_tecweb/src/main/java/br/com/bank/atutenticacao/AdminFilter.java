package br.com.bank.atutenticacao;

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
import javax.servlet.http.HttpSession;

@WebFilter({"/LoginServlet"})
public class AdminFilter implements Filter {
	
	public AdminFilter() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String url = httpServletRequest.getRequestURI();
		HttpSession session = httpServletRequest.getSession();
	
		if(session.getAttribute("usuarioAutenticado") != null || url.lastIndexOf("admin/login.jsp")>-1 || url.lastIndexOf("LoginServlet")>-1){
            chain.doFilter(request, response);
		}else {
			((HttpServletResponse)response).sendRedirect("admin/login.jsp");
		}
	}
	
	public void destroy() {}

}
