package com.ediersua.pokemon.domain.usecases;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ediersua.pokemon.application.PokemonApplication;
import com.ediersua.pokemon.domain.models.PokemonDto;

@SpringBootTest(classes = PokemonApplication.class)
public class PokemonServiceTest {

	private static final Logger log = LoggerFactory.getLogger(PokemonServiceTest.class);

	@Autowired
	private IPokemonService pokemonService;
	
	@Test
	void savePokemon() throws FileNotFoundException{
		
		PokemonDto dto = new PokemonDto();
		dto.setName("Caterpie");
		dto.setPower("Polvo escudo");
		dto.setSize(30);
		dto.setWeight(2.9);
		
		PokemonDto result = pokemonService.save(dto);
		
		Assertions.assertTrue(result.getPokemonId() != null && result.getPokemonId() != 0);
		
	}
	
	@Test
	void findById() {
		Long id = 2L;
		PokemonDto result = pokemonService.findById(id);
		Assertions.assertEquals(id, result.getPokemonId());

	}

}
