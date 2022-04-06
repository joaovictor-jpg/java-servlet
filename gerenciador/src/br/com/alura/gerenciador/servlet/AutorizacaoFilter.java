package br.com.alura.gerenciador.servlet;

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
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("AutorizacaoFilter");
		
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");
		
		HttpSession session = request.getSession();
		boolean usuarioOff = (session.getAttribute("usuarioLogin") == null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

		if (ehUmaAcaoProtegida && usuarioOff) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
}
