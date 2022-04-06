package br.com.courseinfo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Curso> listaDeCursos = new ArrayList<>();
	private static Usuario usuario = new Usuario();

	static {
		Curso curso1 = new Curso();
		Curso curso2 = new Curso();
		curso1.setId(1);
		curso1.setName("Java");
		curso1.setQuantidadeDeAulas(10);
		curso1.setDuracaoDoCurso(20);

		curso2.setId(2);
		curso2.setName("C#");
		curso2.setQuantidadeDeAulas(10);
		curso2.setDuracaoDoCurso(20);

		listaDeCursos.add(curso1);
		listaDeCursos.add(curso2);

		usuario.setLogin("joao");
		usuario.setSenha("123456");
	}

	public void add(Curso curso) {
		listaDeCursos.add(curso);
	}

	public List<Curso> listaCurso() {
		return listaDeCursos;
	}

	public Curso buscaPorId(Integer id) {
		System.out.println(id);
		for (Curso curso : listaDeCursos) {
			if (curso.getId() == id) {
				return curso;
			}
		}
		return null;
	}

	public void excluir(Integer id) {
		System.out.println("Testa o método excluir na classe Banco");
		Iterator<Curso> iterator = listaDeCursos.iterator();
		while (iterator.hasNext()) {
			Curso curso = iterator.next();
			if (curso.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Usuario verificarUsuario(String login, String senha) {
		System.out.println("metodo verificarUsuario da classe banco");
		if (usuario.compare(login, senha)) {
			return usuario;
		}
		return null;
	}

}
