package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
	
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return new PokemonMetadata(index, Pokedex.listePokemon.get(0).getName(), Pokedex.listePokemon.get(0).getAttack(), Pokedex.listePokemon.get(0).getDefense(), Pokedex.listePokemon.get(0).getStamina());
	}

}
