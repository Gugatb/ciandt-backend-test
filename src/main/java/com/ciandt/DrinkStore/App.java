package com.ciandt.DrinkStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	/**
	 * Contrutor da classe.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pArguments os argumentos
	 */
	public static void main(String[] pArguments) {
		System.setProperty("spring.profiles.default", "dev");
		SpringApplication.run(App.class, pArguments);
	}
}
