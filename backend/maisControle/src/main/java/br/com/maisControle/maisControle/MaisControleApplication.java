package br.com.maisControle.maisControle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MaisControleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaisControleApplication.class, args);
	}

}
