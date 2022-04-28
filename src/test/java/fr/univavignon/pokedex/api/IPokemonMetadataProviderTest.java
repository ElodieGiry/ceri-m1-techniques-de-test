package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;  
import org.junit.Test;  
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyInt;

public class IPokemonMetadataProviderTest {

	@Test
	public void test() throws PokedexException {
		
		IPokemonMetadataProvider test = Mockito.mock(IPokemonMetadataProvider.class);
		when(test.getPokemonMetadata(anyInt())).thenAnswer(
			new Answer() {
				@Override
				public Object answer(InvocationOnMock invocation) throws PokedexException {
					Object[] args = invocation.getArguments();
					int entier = (int) args[0];
					if(entier==0){
						return new PokemonMetadata(0,"Bulbizarre",126,126,90);
					}
					else if(entier==133){
						return new PokemonMetadata(133,"Aquali",186,168,260);
					}
					else if(entier<0 ||entier>150) {
						return new PokedexException("Mauvais index");
					}
					else {
						return new PokedexException("Autre exception");
					}
				}
			}
			);	
		PokemonMetadata pm = test.getPokemonMetadata(0);
		
		System.out.println(pm.getName());
		System.out.println(pm.getAttack());
		System.out.println(pm.getDefense());
		System.out.println(pm.getStamina());
		
		assertEquals("Bulbizarre", pm.getName());
		assertEquals(126, pm.getAttack());
		assertEquals(126, pm.getDefense());
		assertEquals(90, pm.getStamina());
		
		PokemonMetadata pm1 = test.getPokemonMetadata(133);
		
		System.out.println(pm1.getName());
		System.out.println(pm1.getAttack());
		System.out.println(pm1.getDefense());
		System.out.println(pm1.getStamina());
		
		assertEquals("Aquali", pm1.getName());
		assertEquals(186, pm1.getAttack());
		assertEquals(168, pm1.getDefense());
		assertEquals(260, pm1.getStamina());
	}
}
