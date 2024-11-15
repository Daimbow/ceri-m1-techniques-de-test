package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {


	    @Test
	    public void ValideTestSize() {
	    	
		    IPokedex pokedex = mock(IPokedex.class);
	    	
	        Pokemon Pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        
	        pokedex.addPokemon(Pokemon);
	        
	        Mockito.when(pokedex.size()).thenReturn(1);
	        
	        int size = pokedex.size();
	        assertEquals(1, size);
	        
	        Mockito.verify(pokedex).size();
	        
	        Mockito.verify(pokedex).addPokemon(Pokemon);

	        
	    }
	    
	    @Test
	    public void testEmptyPokedexSize() {
	        IPokedex pokedex = mock(IPokedex.class);
	        Mockito.when(pokedex.size()).thenReturn(0);
	        
	        int size = pokedex.size();
	        assertEquals(0, size);
	        Mockito.verify(pokedex).size();
	    }
	    
	    @Test
	    public void testAddPokemon() {
	    	
	    	IPokedex pokedex;
	        Pokemon Pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        pokedex = mock(IPokedex.class);


	    	
	    	Mockito.when(pokedex.addPokemon(Pokemon)).thenReturn(0);
	        int index = pokedex.addPokemon(Pokemon);
	        assertEquals(0, index);
	        Mockito.verify(pokedex).addPokemon(Pokemon);
	    }
	    
	    @Test
	    public void testAddMultiplePokemons() {
	        IPokedex pokedex = mock(IPokedex.class);
	        Pokemon bulbi = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        Pokemon aquali = new Pokemon(133,"Aquali",186 , 168, 260, 2729, 202, 5000 , 4, 0.100);
	       
	        Mockito.when(pokedex.addPokemon(bulbi)).thenReturn(0);
	        Mockito.when(pokedex.addPokemon(aquali)).thenReturn(133);
	        Mockito.when(pokedex.size()).thenReturn(2);

	        pokedex.addPokemon(bulbi);
	        pokedex.addPokemon(aquali);

	        int size = pokedex.size();
	        assertEquals(2, size);
	        Mockito.verify(pokedex).addPokemon(bulbi);
	        Mockito.verify(pokedex).addPokemon(aquali);
	        Mockito.verify(pokedex).size();
	    }

	    

	    @Test
	    public void testGetPokemonValide() throws PokedexException {
	    	
	    	IPokedex pokedex;
	        pokedex = mock(IPokedex.class);


	        Pokemon Pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        
	        pokedex.addPokemon(Pokemon);

	        Mockito.when(pokedex.getPokemon(0)).thenReturn(Pokemon);
	        
	        Pokemon PokemonGet = pokedex.getPokemon(0);
	        assertNotNull(PokemonGet);
	        assertEquals("Bulbizarre", PokemonGet.getName());
	        Mockito.verify(pokedex).getPokemon(0);
	    }
	    
	    @Test
	    public void testGetPokemonInvalide() throws PokedexException {
	    	
	    	IPokedex pokedex;
	        pokedex = mock(IPokedex.class);


	        Pokemon Pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);

	        pokedex.addPokemon(Pokemon);

	        Mockito.when(pokedex.getPokemon(1)).thenThrow(new PokedexException("Invalide index"));
	        
			try {
				
		        Pokemon PokemonGet = pokedex.getPokemon(1);
				
			}catch(PokedexException e ) {
				
		        Mockito.verify(pokedex).getPokemon(1);
				return;
			}
			
			throw new AssertionError("Exception PokedexException n'est pas levée");
			
	        
	    }
	    
	    @Test
	    public void testGetPokemonsEmpty() {
	        IPokedex pokedex = mock(IPokedex.class);
	        Mockito.when(pokedex.getPokemons()).thenReturn(new ArrayList<>());
	        
	        List<Pokemon> pokemons = pokedex.getPokemons();
	        assertNotNull(pokemons);
	        assertEquals(0, pokemons.size());
	        Mockito.verify(pokedex).getPokemons();
	    }
	    
	    @Test
	    public void testGetPokemons() {
	    	
	    	IPokedex pokedex;
	        pokedex = mock(IPokedex.class);
	        
	        Pokemon Pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);

	        List<Pokemon> pokemonList = new ArrayList<>();
	        pokemonList.add(Pokemon);
	        
	        Mockito.when(pokedex.getPokemons()).thenReturn(pokemonList);
	        
	        List<Pokemon> resultat = pokedex.getPokemons();
	        assertEquals(1, resultat.size());
	        assertEquals("Bulbizarre", resultat.get(0).getName());
	        Mockito.verify(pokedex).getPokemons();
	    }
	    
	 
	    @Test
	    public void testGetPokemonsWithComparator() {
	        IPokedex pokedex;
	        pokedex = mock(IPokedex.class);
	        
	        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        
	        List<Pokemon> pokemonList = new ArrayList<>();
	        pokemonList.add(pokemon);
	        
	        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getIndex);
	        Mockito.when(pokedex.getPokemons(comparator)).thenReturn(pokemonList);
	        
	        List<Pokemon> result = pokedex.getPokemons(comparator);
	        
	        assertEquals(1, result.size());
	        assertEquals("Bulbizarre", result.get(0).getName());
	        
	        Mockito.verify(pokedex).getPokemons(comparator);
	    }
	    
	    @Test
	    public void testGetPokemonsWithComparatorMultiple() {
	    	
	        IPokedex pokedex = mock(IPokedex.class);
	        Pokemon bulbi = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        Pokemon aquali = new Pokemon(133,"Aquali",186 , 168, 260, 2729, 202, 5000 , 4, 0.100);

	        
	        List<Pokemon> pokemonList = new ArrayList<>();
	        pokemonList.add(bulbi);
	        pokemonList.add(aquali);
	        
	        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getCp);
	        Mockito.when(pokedex.getPokemons(comparator)).thenReturn(pokemonList);
	        
	        List<Pokemon> result = pokedex.getPokemons(comparator);
	        
	        assertEquals(2, result.size());
	        assertEquals("Bulbizarre", result.get(0).getName()); 
	        assertEquals("Aquali", result.get(1).getName());
	        
	        Mockito.verify(pokedex).getPokemons(comparator);
	    }
	    
	    @Test
	    public void testSize_Imp() {
	        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
	        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
	        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
	        
	        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        pokedex.addPokemon(pokemon);
	        
	        assertEquals(1, pokedex.size());
	    }

	    @Test
	    public void testAddPokemon_Imp() {
	        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
	        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
	        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
	        
	        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        
	        int index = pokedex.addPokemon(pokemon);
	        assertEquals(0, index); 
	    }

	    @Test
	    public void testGetPokemon_Imp() throws PokedexException {
	        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
	        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
	        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
	        
	        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        pokedex.addPokemon(pokemon);
	        
	        Pokemon retrievedPokemon = pokedex.getPokemon(0);
	        assertNotNull(retrievedPokemon);
	        assertEquals("Bulbizarre", retrievedPokemon.getName());
	    }

	    @Test(expected = PokedexException.class)
	    public void testGetPokemonInvalidIndex() throws PokedexException {
	        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
	        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
	        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
	        
	        pokedex.getPokemon(1);
	    }

	    @Test
	    public void testGetPokemons_Imp() {
	        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
	        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
	        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
	        
	        Pokemon bulbi = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 0.1);
	        pokedex.addPokemon(bulbi);
	        pokedex.addPokemon(aquali);
	        
	        List<Pokemon> pokemons = pokedex.getPokemons();
	        assertEquals(2, pokemons.size());
	        assertEquals("Bulbizarre", pokemons.get(0).getName());
	        assertEquals("Aquali", pokemons.get(1).getName());
	    }

	    @Test
	    public void testGetPokemonsWithComparator_Imp() {
	        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
	        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
	        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
	        
	        Pokemon bulbi = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 0.1);
	        pokedex.addPokemon(bulbi);
	        pokedex.addPokemon(aquali);
	        
	        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getCp);
	        
	        List<Pokemon> sortedPokemons = pokedex.getPokemons(comparator);
	        assertEquals(2, sortedPokemons.size());
	        assertEquals("Bulbizarre", sortedPokemons.get(0).getName()); 
	        assertEquals("Aquali", sortedPokemons.get(1).getName()); 
	    }



}

