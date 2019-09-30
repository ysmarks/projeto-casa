package br.com.internet.casa;

import java.math.BigDecimal;

public class Dados {

	private final Integer agencia = 1500;
	private final Integer conta = 02453;
	private final Integer dac = 1;
	private final Integer titular = 0001;
	private final Integer sufixo = 10000;
	private final BigDecimal valor = new BigDecimal("30");
	
	public Dados() {
		
	}

	public Integer getAgencia() {
		return agencia;
	}

	public Integer getConta() {
		return conta;
	}

	public Integer getDac() {
		return dac;
	}

	public Integer getTitular() {
		return titular;
	}

	public Integer getSufixo() {
		return sufixo;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	
}
