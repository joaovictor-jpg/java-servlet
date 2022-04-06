package br.com.courseinfo.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest Servletrequest, ServletResponse Servletresponse, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest request = (HttpServletRequest) Servletrequest;
		HttpServletResponse response = (HttpServletResponse) Servletresponse;
		
		String run = request.getParameter("run");
		
		HttpSession session = (HttpSession) request.getSession();
		boolean usuarioLogado = (session.getAttribute("usuarioLogin") == null);
		boolean ehUmaRunProtegida = !(run.equals("FormLogin") || run.equals("Login"));
		if(ehUmaRunProtegida && usuarioLogado) {
			response.sendRedirect("entrada?run=FormLogin");
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
