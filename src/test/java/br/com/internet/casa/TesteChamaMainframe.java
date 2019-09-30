package br.com.internet.casa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.internet.mockito.CasaApplication;

;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT, classes = CasaApplication.class)
public class TesteChamaMainframe {
	
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
	
	private final Integer agencia = 1500;
	private final Integer conta = 02453;
	private final Integer dac = 1;
	private final Integer titular = 0001;
	private final Integer sufixo = 10000;
	private final BigDecimal valor = new BigDecimal("30");
	
	private Dados dados;
	
	
	
	@Autowired
	private PayloadaGRBE payloadaGRBE;
	
	final String PAYLOAD_ESPERADO = "{\"comando\":\"C\",\"transacao\":\"SMT\",\"trancode\":\"00A0000			H0000001ER1	0050>EK01@004341@150000013231010000@000001@03000@TEF@^\"}";
	@Before
	public void setup() {
		dados = new Dados();
		payloadaGRBE = new PayloadaGRBE();
	}

	@Test
	public void validaDadosMontagemTrancode() throws JsonProcessingException {
		
		assertEquals(INICIO, PayloadaGRBE.INICIO);
		assertEquals(FINAL, PayloadaGRBE.FINAL);
		assertEquals(SEPARADOR, PayloadaGRBE.SEPARADOR);
		assertEquals(COMANDO, PayloadaGRBE.COMANDO);
		assertEquals(TRANSACAO, PayloadaGRBE.TRANSACAO);
		assertEquals(HEADER, PayloadaGRBE.HEADER);
		assertEquals(FORMATO, PayloadaGRBE.FORMATO);
		assertEquals(INSTITUICAO, PayloadaGRBE.INSTITUICAO);
		assertEquals(OPERACAO, PayloadaGRBE.OPERACAO);
		assertEquals(ESCALA, PayloadaGRBE.ESCALA);
		
		assertEquals(agencia, dados.getAgencia());
		assertEquals(conta, dados.getConta());
		assertEquals(dac, dados.getDac());
		assertEquals(titular, dados.getTitular());
		assertEquals(sufixo, dados.getSufixo());
		assertEquals(valor, dados.getValor());
	}
	@Test
	public void requisicao()  {
		assertNotNull(payloadaGRBE.traduzir(dados));
		
	}
	

}
