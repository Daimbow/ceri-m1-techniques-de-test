package fr.univavignon.pokedex.api;

import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

public class IPokemonMetadataProviderTest {
	
	
	
	//// Exception
	
	 @Test
	public void ExceptionGetPokemonMetadataTest_OnefiftyOne() throws PokedexException{
		
		IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(151)).thenThrow(new PokedexException("Invalide index"));
		
		try {
			
			mockPokemonMetadataProvider.getPokemonMetadata(151);
			
		}catch(PokedexException e ) {
			
			Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(151);
			return;
		}
		
		throw new AssertionError("Exception PokedexException n'est pas levée");
	
	}
	
	 @Test
	public void ExceptionGetPokemonMetadataTest_NegativeIndex() throws PokedexException{
		
		IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalide index"));
		
		try {
			
			mockPokemonMetadataProvider.getPokemonMetadata(-1);
			
		}catch(PokedexException e ) {
			
			Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(-1);
			return;
		}
		
	
		throw new AssertionError("Exception PokedexException n'est pas levée");
	}
	 
	 
	 //// Test IndexZero
	
	 @Test
	public void ValidetPokemonMetadataTest_Zero() throws PokedexException{
		
		IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		PokemonMetadata PokemonEspece = new PokemonMetadata(0,"Bulbizarre",126,126,90);
		
		Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(PokemonEspece);
			
	    mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
			
		Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
	
	}
	 
	@Test
	public void ValidetPokemonMetadataEqualityTest_Zero() throws PokedexException{
		
		IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		PokemonMetadata PokemonEspece = new PokemonMetadata(0,"Bulbizarre",126,126,90);
		
		Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(PokemonEspece);
			
		 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
			
		Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
		
		 assertEquals(PokemonEspece, PokemonMetaData); 
	
	}
	
	@Test
	public void ValidetPokemonMetadataEqualityTest_getIndex() throws PokedexException{
		
		IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		PokemonMetadata PokemonEspece = new PokemonMetadata(0,"Bulbizarre",126,126,90);
		
		Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(PokemonEspece);
			
		 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
			
		Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
		
		 assertEquals(PokemonEspece.getIndex(), PokemonMetaData.getIndex()); 

	
	}
	 
	 @Test
	public void ValidetPokemonMetadataEqualityTest_getName() throws PokedexException{
		
		IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		PokemonMetadata PokemonEspece = new PokemonMetadata(0,"Bulbizarre",126,126,90);
		
		Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(PokemonEspece);
			
		 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
			
		Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
		
		 assertEquals(PokemonEspece.getName(), PokemonMetaData.getName()); 

	
	}
	 
	 
	 @Test
	public void ValidetPokemonMetadataEqualityTest_getAttack() throws PokedexException{
		
		IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		PokemonMetadata PokemonEspece = new PokemonMetadata(0,"Bulbizarre",126,126,90);
		
		Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(PokemonEspece);
			
		 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
			
		Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
		
		 assertEquals(PokemonEspece.getAttack(), PokemonMetaData.getAttack()); 

	
	}
	 
	 
	 @Test
	public void ValidetPokemonMetadataEqualityTest_getDefense() throws PokedexException{
		
		IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		PokemonMetadata PokemonEspece = new PokemonMetadata(0,"Bulbizarre",126,126,90);
		
		Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(PokemonEspece);
			
		 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
			
		Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
		
		 assertEquals(PokemonEspece.getDefense(), PokemonMetaData.getDefense()); 

	
	}
	 
	 @Test
	public void ValidetPokemonMetadataEqualityTest_getStamina() throws PokedexException{
		
		IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		PokemonMetadata PokemonEspece = new PokemonMetadata(0,"Bulbizarre",126,126,90);
		
		Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(PokemonEspece);
			
		 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
			
		Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
		
		 assertEquals(PokemonEspece.getStamina(), PokemonMetaData.getStamina()); 

	
	}
	 

	 //// Test Index one thirty three
	 
	 @Test
		public void ValidetPokemonMetadataTest_oneThirtyThree() throws PokedexException{
			
			IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
			
			PokemonMetadata PokemonEspece = new PokemonMetadata(133,"Aquali",186,168,260);
			
			Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(PokemonEspece);
				
		    mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
				
			Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
		
		}
		 
		@Test
		public void ValidetPokemonMetadataEqualityTest_oneThirtyTree() throws PokedexException{
			
			IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
			
			PokemonMetadata PokemonEspece = new PokemonMetadata(133,"Aquali",186,168,260);
			
			Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(PokemonEspece);
				
			 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
				
			Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
			
			 assertEquals(PokemonEspece, PokemonMetaData); 
		
		}
		
	 
		@Test
		public void ValidetPokemonMetadataEqualityTest_getIndex_oneThirtyTree() throws PokedexException{
			
			IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
			
			PokemonMetadata PokemonEspece = new PokemonMetadata(133,"Aquali",186,168,260);
			
			Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(PokemonEspece);
				
			 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
				
			Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
			
			 assertEquals(PokemonEspece.getIndex(), PokemonMetaData.getIndex()); 

		
		}
		 
		 @Test
		public void ValidetPokemonMetadataEqualityTest_getName_oneThirtyTree() throws PokedexException{
			
			IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
			
			PokemonMetadata PokemonEspece = new PokemonMetadata(133,"Aquali",186,168,260);
			
			Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(PokemonEspece);
				
			 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
				
			Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
			
			 assertEquals(PokemonEspece.getName(), PokemonMetaData.getName()); 

		
		}
		 
		 
		 @Test
		public void ValidetPokemonMetadataEqualityTest_getAttack_oneThirtyTree() throws PokedexException{
			
			IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
			
			PokemonMetadata PokemonEspece = new PokemonMetadata(133,"Aquali",186,168,260);
			
			Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(PokemonEspece);
				
			 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
				
			Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
			
			 assertEquals(PokemonEspece.getAttack(), PokemonMetaData.getAttack()); 

		
		}
		 
		 
		 @Test
		public void ValidetPokemonMetadataEqualityTest_getDefense_oneThirtyTree() throws PokedexException{
			
			IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
			
			PokemonMetadata PokemonEspece = new PokemonMetadata(133,"Aquali",186,168,260);
			
			Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(PokemonEspece);
				
			 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
				
			Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
			
			 assertEquals(PokemonEspece.getDefense(), PokemonMetaData.getDefense()); 

		
		}
		 
		 @Test
		public void ValidetPokemonMetadataEqualityTest_getStamina_oneThirtyTree() throws PokedexException{
			
			IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
			
			PokemonMetadata PokemonEspece = new PokemonMetadata(133,"Aquali",186,168,260);
			
			Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(PokemonEspece);
				
			 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
				
			Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
			
			 assertEquals(PokemonEspece.getStamina(), PokemonMetaData.getStamina()); 

		
		}
		 
		// Test One fifty
		 
		 @Test
		public void ValidetPokemonMetadataEqualityTest_getStamina_OneFifty() throws PokedexException{
			
			IPokemonMetadataProvider mockPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
			
			PokemonMetadata PokemonEspece = new PokemonMetadata(150,"Mew",186,168,260);
			
			Mockito.when(mockPokemonMetadataProvider.getPokemonMetadata(150)).thenReturn(PokemonEspece);
				
			 PokemonMetadata PokemonMetaData = mockPokemonMetadataProvider.getPokemonMetadata(PokemonEspece.getIndex());
				
			Mockito.verify(mockPokemonMetadataProvider).getPokemonMetadata(PokemonEspece.getIndex());
			
			 assertEquals(PokemonEspece.getName(), PokemonMetaData.getName()); 

		
		}
		 
}
