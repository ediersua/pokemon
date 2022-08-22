package com.ediersua.pokemon.infrastructure.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ediersua.pokemon.domain.models.PokemonDto;
import com.ediersua.pokemon.domain.usecases.IPokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	IPokemonService pokemonService;

	@PostMapping
	public ResponseEntity<PokemonDto> save(@RequestBody PokemonDto pokemon) {
		PokemonDto pokemonDto = pokemonService.save(pokemon);
		return new ResponseEntity<PokemonDto>(pokemonDto, HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public ResponseEntity<List<PokemonDto>> getPokemons() {
		List<PokemonDto> pokemons = pokemonService.findAll();
		return new ResponseEntity<List<PokemonDto>>(pokemons, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PokemonDto> getPokemonById(@PathVariable("id") Long pokemonId) {
		try {
			PokemonDto pokemon = pokemonService.findById(pokemonId);
			return new ResponseEntity<PokemonDto>(pokemon, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity("Not pokemon with id '" + pokemonId + "' found. (2)", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/delete/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Long pokemonId) {
		try {
			pokemonService.deleteById(pokemonId);
			return new ResponseEntity("Done", HttpStatus.OK);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity("Not pokemon with id '" + pokemonId + "' found.", HttpStatus.NOT_FOUND);
		}
	}

}
