package com.ediersua.pokemon.domain.models;


public class PokemonDto {

	private Long pokemonId;
	
	private String power;

	private String name;

	private double size;

	private double weight;
	
	@Override
	public String toString() {
		return String.format("Pokemon[id='%s', name='%s', power='%s', size='%s', weight='%s']", pokemonId.toString(), name, power, size, weight);
	}

	public Long getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(Long pokemonId) {
		this.pokemonId = pokemonId;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
