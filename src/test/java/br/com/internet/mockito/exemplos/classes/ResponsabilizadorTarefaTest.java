package br.com.internet.mockito.exemplos.classes;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.beans.HasProperty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResponsabilizadorTarefaTest {

	@Mock
	TarefasService tarefaService;
	
	@Test
	public void atribuiResponsabilidadeTodasTarefasExistentes() {
		
		Sprint sprint = new Sprint();
		Usuario usuarioResponsavel = new Usuario();
		List<Tarefa> listaTarefas = Arrays.asList(new Tarefa[] { new Tarefa(), new Tarefa(), new Tarefa()});
		
		Mockito.when(tarefaService.todas(sprint)).thenReturn(listaTarefas);
		ResponsabilizadorTarefa responsabilizadorTarefa = new ResponsabilizadorTarefa(tarefaService);
		responsabilizadorTarefa.atribuirResponsabilidadeTarefa1(sprint, usuarioResponsavel);
		assertThat(listaTarefas, everyItem(hasProperty("responsavel", equalTo(usuarioResponsavel))));
		//verify(tarefaService, times(1)).salvar(listaTarefas);
	}

}
