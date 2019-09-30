package br.com.internet.casa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

	private String cor;
	private String modelo;
	
	public Car(String cor, String modelo) {
		super();
		this.cor = cor;
		this.modelo = modelo;
	}
	public Car() {}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
