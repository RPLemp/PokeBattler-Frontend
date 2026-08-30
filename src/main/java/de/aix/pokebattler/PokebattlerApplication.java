package de.aix.pokebattler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.liquibase.autoconfigure.LiquibaseAutoConfiguration;

// https://pokeapi.co/

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
//		HibernateJpaConfiguration.class,
		LiquibaseAutoConfiguration.class
})
public class PokebattlerApplication {
	static void main(String[] args) {
		SpringApplication.run(PokebattlerApplication.class, args);
	}
}
