package br.com.internet.casa;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
public class PayloadaGRBE {

	public static final String INICIO = ">";
	public static final String FINAL = "^";
	public static final String SEPARADOR = "@";
	public static final String COMANDO = "C";
	public static final String TRANSACAO = "SMT";
	public static final String HEADER = "00A0000			H0000001ER1	0050";
	public static final String FORMATO = "EK01";
	public static final String INSTITUICAO = "004341";
	public static final String OPERACAO = "TEF";
	public static final int ESCALA = 2;
	
	public static void main(String[] args) {
		Dados entidadeNotificacao = new Dados();
		Stream<String> nomes =  Lists.newArrayList(
				FORMATO, 
				INSTITUICAO,
				formatarDadosConta(entidadeNotificacao),
				formatarTitular(entidadeNotificacao.getTitular()),
				normalizarValores(entidadeNotificacao.getValor()),
				OPERACAO).stream();
		String trancode = String.format("%s%s", HEADER, nomes.collect(Collectors.joining(SEPARADOR, INICIO, SEPARADOR+FINAL)));
		//System.out.println(trancode);
		
		StringBuilder sb = new StringBuilder();
		sb.append("%s%s");
		sb.append(HEADER);
		sb.append(nomes.collect(Collectors.joining(SEPARADOR, INICIO, SEPARADOR+FINAL)));
		System.out.println(sb);
	}
	
	public Payload traduzir(Dados dados) {
		
		Dados entidadeNotificacao = new Dados();
		Stream<String> nomes =  Lists.newArrayList(
				FORMATO, 
				INSTITUICAO,
				formatarDadosConta(entidadeNotificacao),
				formatarTitular(entidadeNotificacao.getTitular()),
				normalizarValores(entidadeNotificacao.getValor()),
				OPERACAO).stream();
		String trancode = String.format("%s%s", HEADER, nomes.collect(Collectors.joining(SEPARADOR, INICIO, SEPARADOR+FINAL)));
		return new Payload(COMANDO, TRANSACAO, trancode);
	}
	private static String formatarDadosConta(final Dados entidadeNotificacao) {
		return String.format("%04d%07d%01d%06d", 
				entidadeNotificacao.getAgencia(),
				entidadeNotificacao.getConta(),
				entidadeNotificacao.getDac(),
				entidadeNotificacao.getSufixo());
	}
	
	private static String formatarTitular(final Integer titular) {
		return String.format("%06d", titular);
	}
	
	private static String normalizarValores(final BigDecimal valor) {
		return String.format("%05d", valor.setScale(ESCALA).unscaledValue());
	}

}
