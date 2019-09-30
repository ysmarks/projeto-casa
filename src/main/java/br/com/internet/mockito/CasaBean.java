package br.com.internet.mockito;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CasaBean {

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
