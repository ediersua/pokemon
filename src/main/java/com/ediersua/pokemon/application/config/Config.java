package com.ediersua.pokemon.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ediersua.pokemon.domain.usecases.IPokemonService;
import com.ediersua.pokemon.domain.usecases.PokemonService;

@Configuration
public class Config {
	
	@Bean
    public IPokemonService getPokemonService() {
        return new PokemonService();
    }

}
