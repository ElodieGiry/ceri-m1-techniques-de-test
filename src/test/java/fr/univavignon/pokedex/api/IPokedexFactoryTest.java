package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;  
import org.junit.Test;  
import org.mockito.Mock;
import org.mockito.Mockito; 

public class IPokedexFactoryTest {

	@Test
    public void createPokedex() {
        
        
        IPokedexFactory em = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider pokMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedex pokedex = Mockito.mock(IPokedex.class);
        
        
        when(em.createPokedex(pokMetadataProvider, pokemonFactory)).thenReturn(pokedex);
        
        assertEquals(em.createPokedex(pokMetadataProvider, pokemonFactory), pokedex);
    }
}
