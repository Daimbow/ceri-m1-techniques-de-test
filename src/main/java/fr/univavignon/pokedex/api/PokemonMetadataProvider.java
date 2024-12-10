package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Cette classe implémente l'interface {@link IPokemonMetadataProvider} et fournit 
 * les métadonnées des Pokémon pour un index donné.
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

  private final Map<Integer, PokemonMetadata> pokemonMetadataMap;

  /**Constructeur qui initialise les métadonnées des Pokémon dans la carte.
   */
  public PokemonMetadataProvider() {
    this.pokemonMetadataMap = new HashMap<>();
    pokemonMetadataMap.put(0,
        new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
    pokemonMetadataMap.put(133,
        new PokemonMetadata(133, "Aquali", 186, 168, 260));
    pokemonMetadataMap.put(150, new PokemonMetadata(150, "Mew", 186, 168, 260));
  }

  /**
   * Retrieves and returns the metadata for the pokemon denoted by the given
   * <tt>index</tt>.
   * 
   * @param index Index of the pokemon to retrieve metadata for.
   * @return Metadata of the pokemon.
   * @throws PokedexException If the given <tt>index</tt> is not valid.
   */
  @Override
  public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
    if (!pokemonMetadataMap.containsKey(index)) {
      throw new PokedexException("Invalide: " + index);
    }
    return pokemonMetadataMap.get(index);
  }
}
