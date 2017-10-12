package br.com.rscruz.configuracoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="br.com.rscruz")
public class CalculadoraCustoTransporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraCustoTransporteApplication.class, args);
	}
}
