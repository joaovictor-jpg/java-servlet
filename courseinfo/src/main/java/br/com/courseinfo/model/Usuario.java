package br.com.courseinfo.model;

public class Usuario {
	private String login;
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean compare(String login, String senha) {
		System.out.println("Testando método compare da classe Usuario");
		if (!this.login.equals(login)) {
			return false;
		} else if (!this.senha.equals(senha)) {
			return false;
		}
		return true;
	}

}
