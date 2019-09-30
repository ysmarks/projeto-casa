package br.com.internet.mockito.exemplos.classes;

public class StatusOperacao {

	private boolean sucesso = true;
	private String mensagem = "";
	
	public StatusOperacao( String mensagem, boolean sucesso) {
		super();
		this.sucesso = sucesso;
		this.mensagem = mensagem;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	
}
