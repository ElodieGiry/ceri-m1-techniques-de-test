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
		assertEquals(new PokemonMetadata(0,"Bulbizarre",126,126,90), test.getPokemonMetadata(0));
		assertEquals(new PokemonMetadata(133,"Aquali",186,168,260), test.getPokemonMetadata(133));
	}
}
