/**
 * 
 */
package com.ediersua.pokemon.domain.usecases;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;

import com.ediersua.pokemon.domain.models.PokemonDto;

/**
 * @author edier.sua
 *
 */
public interface IPokemonService {
	
	public PokemonDto save(PokemonDto pokemonDto);
	
	public List<PokemonDto> findAll();
	
	public PokemonDto findById(Long id) throws EmptyResultDataAccessException, NoSuchElementException ;
	
	public void deleteById(Long id) throws EmptyResultDataAccessException;
	
}
