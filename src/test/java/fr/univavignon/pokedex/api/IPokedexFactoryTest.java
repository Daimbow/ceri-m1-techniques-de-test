package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest{
	
    @Test
    public void testCreatePokedex_ValidParameters() {

    	
    	IPokemonMetadataProvider mockMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory mockPokemonFactory = mock(IPokemonFactory.class);
        
        IPokedexFactory mockPokedexFactory = mock(IPokedexFactory.class);
        IPokedex mockPokedex = mock(IPokedex.class);
        

        Mockito.when(mockPokedexFactory.createPokedex(mockMetadataProvider, mockPokemonFactory)).thenReturn(mockPokedex);
        

        IPokedex createdPokedex = mockPokedexFactory.createPokedex(mockMetadataProvider, mockPokemonFactory);
        
        Mockito.verify(mockPokedexFactory).createPokedex(mockMetadataProvider, mockPokemonFactory);


        assertNotNull(createdPokedex);
        assertEquals(mockPokedex, createdPokedex);
    }
    
    @Test
    public void testCreatePokedex_NullMetadataProvider() {
    	
        IPokemonFactory mockPokemonFactory = mock(IPokemonFactory.class);
        
        IPokedexFactory mockPokedexFactory = mock(IPokedexFactory.class);
        IPokedex mockPokedex = mock(IPokedex.class);


        Mockito.when(mockPokedexFactory.createPokedex(null, mockPokemonFactory)).thenReturn(null);
        mockPokedex = mockPokedexFactory.createPokedex(null, mockPokemonFactory);
        
        Mockito.verify(mockPokedexFactory).createPokedex(null, mockPokemonFactory);

        assertNull(mockPokedex);
    }
    
    @Test
    public void testCreatePokedex_NullPokemonFactory() {
    	
        IPokedexFactory mockPokedexFactory = mock(IPokedexFactory.class);
        
    	IPokemonMetadataProvider mockMetadataProvider = mock(IPokemonMetadataProvider.class);

        IPokedex mockPokedex = mock(IPokedex.class);


        Mockito.when(mockPokedexFactory.createPokedex(mockMetadataProvider, null)).thenReturn(null);
        mockPokedex = mockPokedexFactory.createPokedex(mockMetadataProvider, null);
        
        Mockito.verify(mockPokedexFactory).createPokedex(mockMetadataProvider, null);

        assertNull(mockPokedex);
    
    }

    @Test
    public void testCreatePokedex_NullBothParameters() {

        IPokedexFactory mockPokedexFactory = mock(IPokedexFactory.class);
        
        IPokedex mockPokedex = mock(IPokedex.class);

        Mockito.when(mockPokedexFactory.createPokedex(null, null)).thenReturn(null);
        mockPokedex = mockPokedexFactory.createPokedex(null, null);
        
        Mockito.verify(mockPokedexFactory).createPokedex(null, null);

        assertNull(mockPokedex);
        
    }
    
    // Test implémentation de la classe
    
    @Test
    public void testCreatePokedex_ValidParameters_Implementation() {

    	IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();  
        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider); 
        
        IPokedexFactory pokedexFactory = new PokedexFactory();  
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        assertEquals(Pokedex.class, pokedex.getClass());
    }

    @Test
    public void testCreatePokedex_NullMetadataProvider_Implementation() {
        IPokemonFactory pokemonFactory = new PokemonFactory(new PokemonMetadataProvider()); 
        
        IPokedexFactory pokedexFactory = new PokedexFactory();  
        IPokedex pokedex = pokedexFactory.createPokedex(null, pokemonFactory);

        assertNull(pokedex);
    }
    
    
    @Test
    public void testCreatePokedex_NullPokemonFactory_Implementation() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider(); 
        
        IPokedexFactory pokedexFactory = new PokedexFactory();  
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, null);

        assertNull(pokedex);
    }

    @Test
    public void testCreatePokedex_NullBothParameters_Implementation() {
        IPokedexFactory pokedexFactory = new PokedexFactory();  
        IPokedex pokedex = pokedexFactory.createPokedex(null, null);

        assertNull(pokedex);
    }

    @Test
    public void testCreatePokedex_Implementation() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider(); 
        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);  
        
        IPokedexFactory pokedexFactory = new PokedexFactory();  
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        assertEquals(Pokedex.class, pokedex.getClass());
    }
    
    @Test
    public void testCreatePokemon_Exception_Imp() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider() {
            @Override
            public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                throw new PokedexException("Failed to retrieve metadata");
            }
        };
        
        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);
        
        Pokemon pokemon = pokemonFactory.createPokemon(0, 500, 100, 1000, 20);
        
        assertNull(pokemon);
    }
    
	
}
