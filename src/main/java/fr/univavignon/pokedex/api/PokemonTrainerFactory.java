package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		IPokemonMetadataProvider metadataProvider = null;
		IPokemonFactory pokemonFactory = null;
		Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
		return new PokemonTrainer(name, team, pokedex);
	}

}
