package br.com.courseinfo.run;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.courseinfo.model.Banco;
import br.com.courseinfo.model.Curso;

public class ListaCurso implements Run {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		
		List<Curso> cursos = banco.listaCurso();
		
		Collections.sort(cursos);
		
		cursos.forEach(curso -> System.out.println(curso));
		request.setAttribute("cursos", cursos);
		return "forward/listaCurso.jsp";
	}
	
}
