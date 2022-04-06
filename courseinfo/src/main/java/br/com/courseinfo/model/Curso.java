package br.com.courseinfo.model;

import java.util.Date;
import java.util.Objects;

public class Curso implements Comparable<Curso>{

	private Integer id;
	private String name;
	private Integer quantidadeDeAulas;
	private Integer duracaoDoCurso;
	private Date dataDeCriacao = new Date();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantidadeDeAulas() {
		return quantidadeDeAulas;
	}

	public void setQuantidadeDeAulas(Integer quantidadeDeAulas) {
		this.quantidadeDeAulas = quantidadeDeAulas;
	}

	public Integer getDuracaoDoCurso() {
		return duracaoDoCurso;
	}

	public void setDuracaoDoCurso(Integer duracaoDoCurso) {
		this.duracaoDoCurso = duracaoDoCurso;
	}

	public Date getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(Date dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", name=" + name + ", quantidadeDeAulas=" + quantidadeDeAulas + ", duracaoDoCurso="
				+ duracaoDoCurso + ", dataDeCriacao=" + dataDeCriacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeCriacao, duracaoDoCurso, id, name, quantidadeDeAulas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(dataDeCriacao, other.dataDeCriacao)
				&& Objects.equals(duracaoDoCurso, other.duracaoDoCurso) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(quantidadeDeAulas, other.quantidadeDeAulas);
	}

	@Override
	public int compareTo(Curso curso) {
		return this.name.compareTo(curso.name);
	}
}
