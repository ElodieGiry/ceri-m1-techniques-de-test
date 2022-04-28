package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokemonFactoryTest {
	@Test
	public void test() throws PokedexException {
		IPokemonFactory test = Mockito.mock(IPokemonFactory.class);
		when(test.createPokemon(anyInt(),anyInt(), anyInt(),anyInt(),anyInt())).thenAnswer(
			new Answer() {
				@Override
				public Object answer(InvocationOnMock invocation) throws PokedexException {
					Object[] args = invocation.getArguments();
					int entier = (int) args[0];
					if(entier==0){
						return new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56.0);
					}
					else if(entier==133){
						return new Pokemon(133,"Aquali",186,168,260,2729,20,5000,4,100.0);
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
		Pokemon pm = test.createPokemon(0,613,64,4000,4);
		System.out.println(pm.getName());
		System.out.println(pm.getAttack());
		System.out.println(pm.getDefense());
		System.out.println(pm.getStamina());
		System.out.println(pm.getCp());
		System.out.println(pm.getHp());
		System.out.println(pm.getDust());
		System.out.println(pm.getCandy());
		System.out.println(pm.getIv());
		
		assertEquals("Bulbizarre", pm.getName());
		assertEquals(126, pm.getAttack());
		assertEquals(126, pm.getDefense());
		assertEquals(90, pm.getStamina());
		assertEquals(613, pm.getCp());
		assertEquals(64, pm.getHp());
		assertEquals(4000, pm.getDust());
		assertEquals(4, pm.getCandy());
		assertEquals(56.0, pm.getIv(),0.1);
		
		Pokemon pm1 = test.createPokemon(133,2729,20,5000,4);
		
		System.out.println(pm1.getName());
		System.out.println(pm1.getAttack());
		System.out.println(pm1.getDefense());
		System.out.println(pm1.getStamina());
		System.out.println(pm1.getCp());
		System.out.println(pm1.getHp());
		System.out.println(pm1.getDust());
		System.out.println(pm1.getCandy());
		System.out.println(pm1.getIv());
		
		assertEquals("Aquali", pm1.getName());
		assertEquals(186, pm1.getAttack());
		assertEquals(168, pm1.getDefense());
		assertEquals(260, pm1.getStamina());
		assertEquals(2729, pm1.getCp());
		assertEquals(20, pm1.getHp());
		assertEquals(5000, pm1.getDust());
		assertEquals(4, pm1.getCandy());
		assertEquals(100.0, pm1.getIv(),0.1);
	}
}
