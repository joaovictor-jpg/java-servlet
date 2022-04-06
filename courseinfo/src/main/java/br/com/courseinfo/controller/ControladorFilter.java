package br.com.courseinfo.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.courseinfo.run.Run;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class ControladorFilter extends HttpFilter implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest Servletrequest, ServletResponse Servletresponse, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest request = (HttpServletRequest) Servletrequest;
		HttpServletResponse response = (HttpServletResponse) Servletresponse;
		
		String run = request.getParameter("run");
		String nome = null;
		String nomeCompletoDaClasse = "br.com.courseinfo.run."+run;
		
		Run obj;
		try {
			Class classe = Class.forName(nomeCompletoDaClasse);//carrega a classe com o fullName
			obj = (Run) classe.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e.getMessage());
		}
		nome = obj.run(request, response);
		
		String[] split = nome.split("/");
		if (split[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + split[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(split[1]);
		}
	}
}
