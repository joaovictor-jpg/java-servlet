package br.com.courseinfo.run;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.courseinfo.model.Banco;

public class Excluir implements Run {

	public String run(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Testando a classe Excluir");
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		banco.excluir(id);
		return "redirect/entrada?run=ListaCurso";
	}

}
