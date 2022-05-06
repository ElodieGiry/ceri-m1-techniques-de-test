package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokemonTrainerFactory;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokemonTrainerFactoryTest {

	@Test
	public void createTrainer() {
		IPokemonTrainerFactory mockIPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
		

		IPokedexFactory iPokedexFactory = Mockito.mock(IPokedexFactory.class);
		IPokedex iPokedex = iPokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class));
		PokemonTrainer pokemonTrainer = new PokemonTrainer("Test",Team.INSTINCT, iPokedex);
		
		when(mockIPokemonTrainerFactory.createTrainer("Test", Team.INSTINCT, iPokedexFactory)).thenReturn(pokemonTrainer);
		
		assertEquals(pokemonTrainer, mockIPokemonTrainerFactory.createTrainer("Test", Team.INSTINCT, iPokedexFactory));
    }	
    
}
