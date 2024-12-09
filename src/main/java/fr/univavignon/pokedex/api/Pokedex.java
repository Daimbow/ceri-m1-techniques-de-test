package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implémente l'interface {@link IPokedex}, cette classe représente un Pokédex contenant
 * une liste de Pokémon. Elle permet de gérer les Pokémon et leurs métadonnées via
 * un fournisseur de métadonnées et une fabrique de Pokémon.
 * 
 */
public class Pokedex implements IPokedex {
  private final List<Pokemon> pokemons;
  private final IPokemonMetadataProvider metadataProvider;
  private final IPokemonFactory pokemonFactory;

  /**
   * Constructeur pour initialiser une nouvelle instance de la classe Pokedex.
   * 
   * Ce constructeur permet d'initialiser le fournisseur de métadonnées des Pokémon 
   * et la fabrique de Pokémon, puis crée une liste vide pour stocker les Pokémon.
   * 
   * @param metadataProvider Fournisseur de métadonnées des Pokémon à utiliser pour 
   *                         récupérer les informations des Pokémon.
   * @param pokemonFactory Fabrique de Pokémon utilisée pour créer de nouveaux Pokémon.
   */
  public Pokedex(IPokemonMetadataProvider metadataProvider,
      IPokemonFactory pokemonFactory) {
    this.metadataProvider = metadataProvider;
    this.pokemonFactory = pokemonFactory;
    this.pokemons = new ArrayList<>();
  }

  @Override
  public int size() {
    return pokemons.size();
  }

  @Override
  public int addPokemon(Pokemon pokemon) {
    pokemons.add(pokemon);
    return pokemons.size() - 1;
  }

  @Override
  public Pokemon getPokemon(int id) throws PokedexException {
    if (id < 0 || id >= pokemons.size()) {
      throw new PokedexException("Invalid Pokémon ID.");
    }
    return pokemons.get(id);
  }

  @Override
  public List<Pokemon> getPokemons() {
    return Collections.unmodifiableList(pokemons);
  }

  @Override
  public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
    List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
    sortedPokemons.sort(order);
    return Collections.unmodifiableList(sortedPokemons);
  }

  @Override
  public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
    return metadataProvider.getPokemonMetadata(index);
  }

  @Override
  public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
    return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
  }
}
