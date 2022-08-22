/**
 * 
 */
package com.ediersua.pokemon.domain.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.ediersua.pokemon.domain.models.PokemonDto;
import com.ediersua.pokemon.infrastructure.entities.Pokemon;
import com.ediersua.pokemon.infrastructure.repository.IPokemonRepository;

/**
 * @author edier.sua
 *
 */
public class PokemonService implements IPokemonService{
	
	@Autowired
	IPokemonRepository repository;

	@Override
	public PokemonDto save(PokemonDto pokemonDto) {
		Pokemon pokemon = new Pokemon(pokemonDto.getPokemonId(), pokemonDto.getName(), pokemonDto.getPower(), pokemonDto.getSize(), pokemonDto.getWeight());
		pokemon = repository.save(pokemon);
		return loadPokemonDto(pokemon);
	}

	@Override
	public List<PokemonDto> findAll() {
		return loadPokemonsDto(repository.findAll());
	}

	@Override
	public PokemonDto findById(Long id) throws EmptyResultDataAccessException, NoSuchElementException {
		return loadPokemonDto(repository.findById(id).get());
	}

	@Override
	public void deleteById(Long id) throws EmptyResultDataAccessException {
		repository.deleteById(id);
	}
	
	
	private PokemonDto loadPokemonDto(Pokemon entity) {
		PokemonDto dto = new PokemonDto();
		dto.setPokemonId(entity.getId());
		dto.setName(entity.getName());
		dto.setPower(entity.getPower());
		dto.setSize(entity.getSize());
		dto.setWeight(entity.getWeight());
		return dto;
	}
	
	private List<PokemonDto> loadPokemonsDto(Iterable<Pokemon> entities){
		List<PokemonDto> pokemons = new ArrayList<PokemonDto>();
		for(Pokemon p : entities) {
			pokemons.add(loadPokemonDto(p));
		}
		return pokemons;
	}
	
}
