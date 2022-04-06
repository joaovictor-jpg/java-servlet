package br.com.courseinfo.run;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.courseinfo.model.Banco;
import br.com.courseinfo.model.Usuario;

public class Login implements Run {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Classe login");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Banco banco = new Banco();
		Usuario usuario = banco.verificarUsuario(login, senha);
		
		if(usuario != null) {
			System.out.println("OK, usuario existe");
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogin", usuario);
			return "redirect/entrada?run=FormCadastroCurso";
		}
//		
		return "redirect/entrada?run=FormLogin";
	}

}
