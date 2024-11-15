package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;


public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private final Map<Integer, PokemonMetadata> pokemonMetadataMap;

    
    public PokemonMetadataProvider() {
        this.pokemonMetadataMap = new HashMap<>();
    }

    
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!pokemonMetadataMap.containsKey(index)) {
            throw new PokedexException("Invalid Pokémon index: " + index);
        }
        return pokemonMetadataMap.get(index);
    }
}
