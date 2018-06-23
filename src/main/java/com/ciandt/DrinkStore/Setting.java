package com.ciandt.DrinkStore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ciandt.DrinkStore.mongo.Mongo;

@Configuration
public class Setting {
	/**
	 * Obter o mongo.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return mongo o mongo
	 */
	@Bean
	public Mongo getMongo() {
		return new Mongo();
	}
}
