package com.ediersua.pokemon.infrastructure.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String power;

	private double size;

	private double weight;

	Pokemon() {
	}

	public Pokemon(Long id, String name, String power, double size, double weight) {
		this.id = id;
		this.name = name;
		this.power = power;
		this.size = size;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return String.format("Pokemon[id='%s', name='%s', power='%s', size='%s', weight='%s']", id.toString(), name, power, size, weight);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long pokemonId) {
		this.id = pokemonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
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
