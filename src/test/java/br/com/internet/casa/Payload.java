package br.com.internet.casa;

public class Payload {

	private final String comando;
	private final String transacao;
	private final String trancode;
	
	
	public Payload(String comando, String transacao, String trancode) {
		super();
		this.comando = comando;
		this.transacao = transacao;
		this.trancode = trancode;
	}


	public String getComando() {
		return comando;
	}


	public String getTransacao() {
		return transacao;
	}


	public String getTrancode() {
		return trancode;
	}
	
}
