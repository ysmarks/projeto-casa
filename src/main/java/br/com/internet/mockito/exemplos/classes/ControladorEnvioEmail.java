package br.com.internet.mockito.exemplos.classes;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
/**
 * http://www.codeatest.com/mockito-isolamento-testes-unidade/
 * @author ysantos
 *
 */
public class ControladorEnvioEmail {

	protected static final String E_MAIL_ENVIADO_COM_SUCESSO = "E-mail enviado com sucesso!";
	protected static final String NAO_FOI_POSSIVEL_ENVIAR_TODOS = "Os seguintes e-mails não receberam a mensagem: %s";
	private EmailService emailService;
	
	public StatusOperacao envia(Mensagem mensagem, String remetente, String... destinatarios) {
		List<String> emailsInvalidos = new ArrayList<>();
		for (String destinatario : destinatarios) {
			try {
				emailService.envia(mensagem, remetente, destinatario);
			} catch (EmailInvalidoException e) {
				emailsInvalidos.add(destinatario);
			}
		}
		StatusOperacao statusOperacao = new StatusOperacao(E_MAIL_ENVIADO_COM_SUCESSO, true);
		if (CollectionUtils.isNotEmpty(emailsInvalidos)) {
			statusOperacao = new StatusOperacao(String.format(NAO_FOI_POSSIVEL_ENVIAR_TODOS, StringUtils.join(emailsInvalidos, ",")), false);
		}
		return statusOperacao;
	}
}
