package br.com.internet.mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableHystrix
public class CasaController {
	
	@Autowired
	private CasaBean template;

	@HystrixCommand(fallbackMethod = "mostraPadariaFarmaciaFallback")
	@GetMapping("break")
	public String mostraPadariaFarmacia() {
		String padariaService = template.template().getForObject("http://localhost:8181/padaria/pao", String.class);
		String farmaciaService = template.template().getForObject("http://localhost:8282/farmacia/medicamento", String.class);
		return padariaService + "\n" + farmaciaService;
	}
	@GetMapping("breakSem")
	public String mostraPadariaFarmaciaSem() {
		String padariaService = template.template().getForObject("http://localhost:8181/padaria/pao", String.class);
		String farmaciaService = template.template().getForObject("http://localhost:8282/farmacia/medicamento", String.class);
		return padariaService + "\n" + farmaciaService;
	}
	public String mostraPadariaFarmaciaFallback() {
		return "Conexão falhou...";
	}
}
