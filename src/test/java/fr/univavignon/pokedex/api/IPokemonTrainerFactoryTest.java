package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokemonTrainerFactoryTest {

	public void createTrainer() {
		
        IPokemonTrainerFactory em = Mockito.mock(IPokemonTrainerFactory.class);
        Team team = Team.valueOf("MYSTIC");
        
        IPokedexFactory pokedex = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider pokprovider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        
        IPokedex poke = Mockito.mock(IPokedex.class);
        
        pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        
        pokedex.createPokedex(pokprovider, pokemonFactory);
        
        PokemonTrainer pt = em.createTrainer("Sacha", team.valueOf("MYSTIC"), pokedex);
        
        when(pt).thenAnswer(
    			new Answer() {
    				@Override
    				public Object answer(InvocationOnMock invocation) throws PokedexException {
    					Object[] args = invocation.getArguments();
    					int entier = (int) args[0];
    					if(pt.getName().equals("Sacha")){
    						return new PokemonTrainer("Sacha", team.valueOf("MYSTIC"), poke);
    					}
    					else {
    						return new PokedexException("Autre exception");
    					}
    				}
    			}
    			);
        
		System.out.println(pt);
		System.out.println(pt.getName());
		System.out.println(pt.getTeam());
		System.out.println(pt.getPokedex());
		
		assertEquals("Sacha", pt.getName());
		assertEquals(team.valueOf("MYSTIC"), pt.getTeam());
		assertEquals(pokedex, pt.getPokedex());
		
    }	
}
