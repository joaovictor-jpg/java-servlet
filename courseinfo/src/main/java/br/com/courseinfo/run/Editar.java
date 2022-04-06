package br.com.courseinfo.run;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.courseinfo.model.Banco;
import br.com.courseinfo.model.Curso;

public class Editar implements Run {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Olá Mundo 2");
		
		Integer id = Integer.valueOf(request.getParameter("id"));
//		
		Banco banco = new Banco();
		Curso curso = banco.buscaPorId(id);
//		
		System.out.println(curso);
		
		request.setAttribute("curso", curso);
		return "forward/editarCurso.jsp";
	}

}
