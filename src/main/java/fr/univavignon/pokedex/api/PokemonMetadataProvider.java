package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private final Map<Integer, PokemonMetadata> pokemonMetadataMap;

    public PokemonMetadataProvider() {
        this.pokemonMetadataMap = new HashMap<>();
        pokemonMetadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonMetadataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
        pokemonMetadataMap.put(150, new PokemonMetadata(150, "Mew", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!pokemonMetadataMap.containsKey(index)) {
            throw new PokedexException("Invalide: " + index);
        }
        return pokemonMetadataMap.get(index);
    }
}
