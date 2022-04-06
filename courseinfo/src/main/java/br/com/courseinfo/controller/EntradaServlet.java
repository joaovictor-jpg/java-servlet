package br.com.courseinfo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.courseinfo.run.Run;

/**
 * Servlet implementation class EntradaServlet
 */
//@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
