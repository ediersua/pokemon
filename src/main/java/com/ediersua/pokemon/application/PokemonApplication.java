package com.ediersua.pokemon.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ediersua.pokemon.infrastructure.entities.Pokemon;
import com.ediersua.pokemon.infrastructure.repository.IPokemonRepository;

@SpringBootApplication(scanBasePackages = "com.ediersua.pokemon")
@EnableJpaRepositories(basePackages = "com.ediersua.pokemon.infrastructure.repositories.jpa", basePackageClasses = IPokemonRepository.class)
@EntityScan("com.ediersua.pokemon.infrastructure.entities")
@ComponentScan("com.ediersua.pokemon")
public class PokemonApplication {

	private static final Logger log = LoggerFactory.getLogger(DataSourceAutoConfiguration.class);

	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IPokemonRepository repository) {
		return (args) -> {
			// Load initial test data
			repository.save(new Pokemon(null, "Pikachu", "Electricity", 145, 5.2));
			repository.save(new Pokemon(null, "Charmander", "X", 100, 4.2));
			repository.save(new Pokemon(null, "Psyduck", "Y", 40.2, 5));

			log.info("");
			log.info("Pokemons found with findAll():");
			log.info("-------------------------------");
			for (Pokemon pokemon : repository.findAll()) {
				log.info(pokemon.toString());
			}
			log.info("--------------------------------");
		};
	}

}
