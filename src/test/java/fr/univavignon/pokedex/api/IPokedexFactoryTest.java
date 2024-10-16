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
        assertNull(mockPokedex);
    }
    
    @Test
    public void testCreatePokedex_NullPokemonFactory() {
    	
        IPokedexFactory mockPokedexFactory = mock(IPokedexFactory.class);
    	IPokemonMetadataProvider mockMetadataProvider = mock(IPokemonMetadataProvider.class);

        IPokedex mockPokedex = mock(IPokedex.class);


        Mockito.when(mockPokedexFactory.createPokedex(mockMetadataProvider, null)).thenReturn(null);
        mockPokedex = mockPokedexFactory.createPokedex(mockMetadataProvider, null);
        assertNull(mockPokedex);
    
    }

    @Test
    public void testCreatePokedex_NullBothParameters() {

        IPokedexFactory mockPokedexFactory = mock(IPokedexFactory.class);
        IPokedex mockPokedex = mock(IPokedex.class);

        Mockito.when(mockPokedexFactory.createPokedex(null, null)).thenReturn(null);
        mockPokedex = mockPokedexFactory.createPokedex(null, null);
        assertNull(mockPokedex);
        
    }

    
    


	
}
