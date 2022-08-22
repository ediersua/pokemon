/**
 * 
 */
package com.ediersua.pokemon.infrastructure.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ediersua.pokemon.infrastructure.entities.Pokemon;

/**
 * @author edier.sua
 *
 */
@Service
public interface IPokemonRepository extends CrudRepository<Pokemon, Long> {
	
}
