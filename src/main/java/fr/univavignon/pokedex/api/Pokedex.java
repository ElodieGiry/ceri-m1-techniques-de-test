package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
	
	IPokemonMetadataProvider metadataProvider;
	IPokemonFactory pokemonFactory;
	
	public static List<Pokemon> listePokemon = new ArrayList<Pokemon>();
	
	public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		Pokemon pokemon1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
		Pokemon pokemon2 = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
		listePokemon.add(pokemon1);
		listePokemon.add(pokemon2);
		this.metadataProvider = metadataProvider;
		this.pokemonFactory = pokemonFactory;
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return metadataProvider.getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	@Override
	public int size() {
		return listePokemon.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		listePokemon.add(pokemon);
		return pokemon.getIndex();
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		return listePokemon.get(id);
	}

	@Override
	public List<Pokemon> getPokemons() {
		return listePokemon;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		Collections.sort(listePokemon,order);
		return listePokemon;
	}

}
