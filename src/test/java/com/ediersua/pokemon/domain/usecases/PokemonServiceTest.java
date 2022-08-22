package com.ediersua.pokemon.domain.usecases;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ediersua.pokemon.application.PokemonApplication;
import com.ediersua.pokemon.domain.models.PokemonDto;

@SpringBootTest(classes = PokemonApplication.class)
public class PokemonServiceTest {

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
