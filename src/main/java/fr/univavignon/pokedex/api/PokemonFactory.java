package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonFactory implements IPokemonFactory {
	
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		return new Pokemon(index, Pokedex.listePokemon.get(0).getName(), Pokedex.listePokemon.get(0).getAttack(), Pokedex.listePokemon.get(0).getDefense(), Pokedex.listePokemon.get(0).getStamina(), cp, hp, dust, candy ,Pokedex.listePokemon.get(0).getIv());
	}

}
