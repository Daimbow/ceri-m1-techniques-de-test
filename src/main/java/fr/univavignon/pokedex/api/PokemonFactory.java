package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {
	
	private final IPokemonMetadataProvider metadataProvider;

	public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
		this.metadataProvider = metadataProvider;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
	    try {
	        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

	            return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(),
	                               metadata.getStamina(), cp, hp, dust, candy, 50);
	        } catch (PokedexException e) {

	        	System.err.println("Failed to create Pokemon: " + e.getMessage());
	            return null;
	        }
	    }
	}
