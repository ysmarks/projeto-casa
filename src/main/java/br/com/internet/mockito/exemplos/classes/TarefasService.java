package br.com.internet.mockito.exemplos.classes;

import java.util.List;

public class TarefasService {

	private TarefasRepository repository;
	
	public List<Tarefa> todas(Sprint sprint) {
		return repository.consultaTodas(sprint);
	}

	public void salvar(List<Tarefa> tarefas) {
		repository.salvar(tarefas);
	}

}
