package fr.univavignon.pokedex.api;


public class PokemonTrainerFactory implements IPokemonTrainerFactory {


	   @Override
	    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
	        // Validate inputs
	        if (name == null || name.isEmpty() || team == null || pokedexFactory == null) {
	            return null;
	        }
	        
	        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory(new PokemonMetadataProvider()));;
	        
	        // Return the new PokemonTrainer instance
	        return new PokemonTrainer(name, team, pokedex);
	    }
}