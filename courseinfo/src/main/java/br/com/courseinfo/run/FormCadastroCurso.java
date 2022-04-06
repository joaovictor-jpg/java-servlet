package br.com.courseinfo.run;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormCadastroCurso implements Run {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		return "forward/cadastroCurso.jsp";
	}
}
