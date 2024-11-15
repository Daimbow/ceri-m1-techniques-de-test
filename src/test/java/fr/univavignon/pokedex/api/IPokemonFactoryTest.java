package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

    @Test
    public void testCreatePokemon_ValidValues_IndexZero() {


    	IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Pokemon Pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        
        Mockito.when(mockPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(Pokemon);
        
        Pokemon createdPokemon = mockPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        
        Mockito.verify(mockPokemonFactory).createPokemon(0, 613, 64, 4000, 4);
        
        assertNotNull(createdPokemon);
        assertEquals(Pokemon.getName(), createdPokemon.getName());
        assertEquals(Pokemon.getCp(), createdPokemon.getCp());
        assertEquals(Pokemon.getHp(), createdPokemon.getHp());
        assertEquals(Pokemon.getDust(), createdPokemon.getDust());
        assertEquals(Pokemon.getCandy(), createdPokemon.getCandy());
    }
    

    @Test
    public void testCreatePokemon_ValidValues_IndexOneThirtyThree() {

    	IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Pokemon Pokemon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
        
        Mockito.when(mockPokemonFactory.createPokemon(0, 2729, 202, 5000, 4)).thenReturn(Pokemon);
        
        Pokemon createdPokemon = mockPokemonFactory.createPokemon(0, 2729, 202, 5000, 4);
        
        Mockito.verify(mockPokemonFactory).createPokemon(0, 2729, 202, 5000, 4);

        
        assertNotNull(createdPokemon);
        assertEquals(Pokemon.getName(), createdPokemon.getName());
        assertEquals(Pokemon.getCp(), createdPokemon.getCp());
        assertEquals(Pokemon.getHp(), createdPokemon.getHp());
        assertEquals(Pokemon.getDust(), createdPokemon.getDust());
        assertEquals(Pokemon.getCandy(), createdPokemon.getCandy());
    }
    
    @Test
    public void testCreatePokemon_InvalidIndexZero() {
    	
        IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Mockito.when(mockPokemonFactory.createPokemon(-1, 613, 64, 4000, 4)).thenReturn(null);

        Pokemon createdPokemon = mockPokemonFactory.createPokemon(-1, 613, 64, 4000, 4);
        
        Mockito.verify(mockPokemonFactory).createPokemon(-1, 613, 64, 4000, 4);


        assertNull(createdPokemon);
    }
    
    @Test
    public void testCreatePokemon_InvalidIndexOneFiftyOne() {
    	
        IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Mockito.when(mockPokemonFactory.createPokemon(151, 613, 64, 4000, 4)).thenReturn(null);

        Pokemon createdPokemon = mockPokemonFactory.createPokemon(151, 613, 64, 4000, 4);
        
        Mockito.verify(mockPokemonFactory).createPokemon(151, 613, 64, 4000, 4);


        assertNull(createdPokemon);
    }
    
    @Test
    public void testCreatePokemon_InvalidCP() {
        
        IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Mockito.when(mockPokemonFactory.createPokemon(0, -1, 64, 4000, 4)).thenReturn(null);

        Pokemon createdPokemon = mockPokemonFactory.createPokemon(0, -100, 64, 4000, 4);
        
        Mockito.verify(mockPokemonFactory).createPokemon(0, -100, 64, 4000, 4);


        assertNull(createdPokemon);
    }
    
    @Test
    public void testCreatePokemon_InvalidHP() {
        
        IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Mockito.when(mockPokemonFactory.createPokemon(0, 613, -1, 4000, 4)).thenReturn(null);

        Pokemon createdPokemon = mockPokemonFactory.createPokemon(0, 613, -1, 4000, 4);
        
        Mockito.verify(mockPokemonFactory).createPokemon(0, 613, -1, 4000, 4);


        assertNull(createdPokemon);
    }
    
    @Test
    public void testCreatePokemon_InvalidDust() {
        
        IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Mockito.when(mockPokemonFactory.createPokemon(0, 613, 64, -1, 4)).thenReturn(null);

        Pokemon createdPokemon = mockPokemonFactory.createPokemon(0, 613, 64, -1, 4);
        
        Mockito.verify(mockPokemonFactory).createPokemon(0, 613, 64, -1, 4);


        assertNull(createdPokemon);
    }
    
    @Test
    public void testCreatePokemon_InvalidCandy() {
        
        IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Mockito.when(mockPokemonFactory.createPokemon(0, 613, 64, 4000, -1)).thenReturn(null);

        Pokemon createdPokemon = mockPokemonFactory.createPokemon(0, 613, 64, 4000, -1);
        
        Mockito.verify(mockPokemonFactory).createPokemon(0, 613, 64, 4000, -1);


        assertNull(createdPokemon);
    }
    
	 // Test limit, defense, attack
    
    @Test
    public void testCreatePokemon_ValidValues_MinStat() {

    	IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Pokemon pokemonMinStats = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);

        Mockito.when(mockPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemonMinStats); 
        
        
        Pokemon createdPokemonMin = mockPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        
        Mockito.verify(mockPokemonFactory).createPokemon(0, 613, 64, 4000, 4);

        assertEquals(126, createdPokemonMin.getAttack()); 
        assertEquals(126, createdPokemonMin.getDefense());
        assertEquals(90, createdPokemonMin.getStamina());  

    }
    
    @Test
    public void testCreatePokemon_ValidValues_MaxStat() {

    	IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);

        Pokemon pokemonMaxStats = new Pokemon(0, "Bulbizarre", 141, 141, 105, 613, 64, 4000, 4, 1.00);

        Mockito.when(mockPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemonMaxStats); 
        

        Pokemon createdPokemonMax = mockPokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        
        Mockito.verify(mockPokemonFactory).createPokemon(0, 613, 64, 4000, 4);

        assertEquals(141, createdPokemonMax.getAttack());  
        assertEquals(141, createdPokemonMax.getDefense()); 
        assertEquals(105, createdPokemonMax.getStamina()); 
    }
    
    
}
