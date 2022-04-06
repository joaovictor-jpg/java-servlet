package br.com.courseinfo.run;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.courseinfo.model.Banco;
import br.com.courseinfo.model.Curso;

public class AtualizarCurso implements Run {

	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println("class Atualizar Curso");
		
		Banco banco = new Banco();
		Curso curso = banco.buscaPorId(id);
		
		String nome = request.getParameter("nome");
		Integer qtdAulas = Integer.valueOf(request.getParameter("qtdAulas"));
		Integer tempoDeCurso = Integer.valueOf(request.getParameter("tempoDeCurso"));
		String dataDeCriacao = request.getParameter("dataDeCriacao");
		
		Date data = null;
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		try {
			data = formataData.parse(dataDeCriacao);
		} catch (ParseException e) {
			throw new ServletException(e.getMessage());
		}
		
		System.out.println("Curso antes de atualizar: " + curso);
		
		curso.setName(nome);
		curso.setQuantidadeDeAulas(qtdAulas);
		curso.setDuracaoDoCurso(tempoDeCurso);
		curso.setDataDeCriacao(data);
		
		System.out.println("Curso depois de atualizar: " + curso);
		
		return "redirect/entrada?run=ListaCurso";
	}

}
