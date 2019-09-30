package br.com.internet.mockito.exemplos.classes;

public class Tarefa {

	private String nome;
	private Usuario responsavel;
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Usuario getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}


	public void defineResponsavel(Usuario usuarioResponsavel) {
		this.responsavel = usuarioResponsavel;
	}

}
