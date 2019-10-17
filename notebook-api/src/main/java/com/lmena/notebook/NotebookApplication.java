package com.lmena.notebook;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.lmena.notebook.model.entity.Account;
import com.lmena.notebook.repository.AccountRepository;

@SpringBootApplication
public class NotebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotebookApplication.class, args);
	}
	
    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner initAccount(AccountRepository accountRepository) {
		return (args) -> {
			Account account = new Account();
			account.setId(1L);
			account.setAmount(0.0);
			accountRepository.save(account);
		};
	}

}
