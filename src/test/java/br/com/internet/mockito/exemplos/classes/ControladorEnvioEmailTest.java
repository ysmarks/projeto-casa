package br.com.internet.mockito.exemplos.classes;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControladorEnvioEmailTest {

	@Mock
	private EmailService emailService;
	
	@InjectMocks
	private ControladorEnvioEmail controladorEnvioEmail;
	
	@Test
	public void todosDestinatariosRecebemEmail() {
		Mensagem mensagem = new Mensagem();
		String remetente = "ys@email.com";
		String[] destinatarios = new String[] {"romario@email.com", "bebeto@email.com", "zinho@email.coms"};
		
		StatusOperacao status = controladorEnvioEmail.envia(mensagem, remetente, destinatarios);
		assertTrue(status.isSucesso());
		assertEquals(ControladorEnvioEmail.E_MAIL_ENVIADO_COM_SUCESSO, status.getMensagem());
		verify(emailService, times(3)).envia(Mockito.any(Mensagem.class), Mockito.anyString(), Mockito.anyString());
	}
	
	@Test
	public void destinatarioComEmailInvalidoNaoRecebeEmail() {
		Mensagem mensagem = new Mensagem();
		String remetente = "ys@email.com";
		String[] destinatarios = new String[] {"romario@email.com", "bebeto@email", "zinho@email.coms"};
		
		doThrow(EmailInvalidoException.class).when(emailService).envia(mensagem, remetente, "bebeto@email");
		StatusOperacao status = controladorEnvioEmail.envia(mensagem, remetente, destinatarios);
		assertFalse(status.isSucesso());
		assertEquals(String.format(ControladorEnvioEmail.NAO_FOI_POSSIVEL_ENVIAR_TODOS, "bebeto@email"), status.getMensagem());
		verify(emailService, times(3)).envia(Mockito.any(Mensagem.class), Mockito.anyString(), Mockito.anyString());
	}

}
