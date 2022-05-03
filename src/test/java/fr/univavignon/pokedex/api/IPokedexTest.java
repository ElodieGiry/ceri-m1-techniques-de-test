package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokedexTest {
    
    public static List<Pokemon> pokedex = new ArrayList<Pokemon>();
    IPokedex em = Mockito.mock(IPokedex.class);
    IPokemonFactory pmp = Mockito.mock(IPokemonFactory.class);
    
    /**
     * Adds the given <tt>pokemon</tt> to this pokedex and returns
     * it unique index.
     * 
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Test
    public void addPokemon() {
        Pokemon pok1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pok2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        
        pokedex.add(pok1);
        pokedex.add(pok2);
        
        when(em.addPokemon(pok1)).thenReturn(pok1.getIndex());
        when(em.addPokemon(pok2)).thenReturn(pok2.getIndex());
        
        assertEquals(em.addPokemon(pok1), 0);
        assertEquals(em.addPokemon(pok2), 133);
        //assertEquals(em.addPokemon(pok2), 150);
    }
    
    /**
     * Returns the number of pokemon this pokedex contains.
     * 
     * @return Number of pokemon in this pokedex.
     */
    @Test
    public void size() {
        addPokemon();
        when(em.size()).thenReturn(pokedex.size());
        
        assertEquals(em.size(), 4);
    }
    
    /**
	 * Locates the pokemon identified by the given <tt>id</tt>.
	 * 
	 * @param id Unique pokedex relative identifier.
	 * @return Pokemon denoted by the given identifier.
	 * @throws PokedexException If the given <tt>index</tt> is not valid.
	 */ 
 
    @Test
    public void getPokemon() throws PokedexException {
        addPokemon();
        Pokemon pok3 = pmp.createPokemon(0, 613, 64, 4000, 4);
        
        when(pokedex.get(0)).thenReturn(getPokemonIndex(0));
        assertEquals(pokedex.get(0), pmp.createPokemon(0, 613, 64, 4000, 4));
        //assertEquals(pokedex.get(0), pokfac.createPokemon(133, 2729, 202, 5000, 4));
    }
    
    public Pokemon getPokemonIndex(int index) throws PokedexException {
        for(int i=0;i<pokedex.size();i++) {
            if(pokedex.get(i).getIndex() == index) {
                //System.out.println(pokedex.get(i).getIndex());
                return pokedex.get(i);
            }
        }
        //throw new PokedexException("n'existe pas");
        return null;
    }
    
    @Test
    public void getPokemons() throws PokedexException {
        addPokemon();
        Pokemon pok3 = pmp.createPokemon(0, 613, 64, 4000, 4);
        
        List<Pokemon> pokedexBis = new ArrayList<Pokemon>();
        Pokemon pok1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        Pokemon pok2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        pokedexBis.add(pok1);
        pokedexBis.add(pok2);
        pokedexBis = pokedex;
        
        System.out.println("---------------------");
        System.out.println(pokedexBis);
        System.out.println(pokedex);
        System.out.println("---------------------");
        
        //when(pokedexBis).thenReturn(pokedex);
        //assertEquals(pokedexBis, );
    }
}