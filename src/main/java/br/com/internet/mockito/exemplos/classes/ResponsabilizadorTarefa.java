package br.com.internet.mockito.exemplos.classes;

import java.util.List;
import org.apache.commons.collections.CollectionUtils;

public class ResponsabilizadorTarefa {

	private TarefasService tarefasService;

	public ResponsabilizadorTarefa(TarefasService tafefa1Service) {
		super();
		this.tarefasService = tafefa1Service;
	}
	
	public void atribuirResponsabilidadeTarefa1(Sprint sprint, Usuario usuarioResponsavel) {
		
		List<Tarefa> listaTarefas = tarefasService.todas(sprint);
		
		if(CollectionUtils.isNotEmpty(listaTarefas)) {
			listaTarefas.forEach(tarefa -> tarefa.defineResponsavel(usuarioResponsavel));
			tarefasService.salvar(listaTarefas);
		}
	}
}
