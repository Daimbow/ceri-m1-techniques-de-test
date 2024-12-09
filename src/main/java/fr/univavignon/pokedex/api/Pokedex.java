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

  
  /**
   * Retourne le nombre de Pokémon dans le Pokédex.
   * 
   * @return Le nombre de Pokémon dans le Pokédex.
   */
  @Override
  public int size() {
    return pokemons.size();
  }

  /**
   * Ajoute un Pokémon au Pokédex.
   * 
   * @param pokemon Le Pokémon à ajouter.
   * @return L'identifiant du Pokémon ajouté.
   */
  @Override
  public int addPokemon(Pokemon pokemon) {
    pokemons.add(pokemon);
    return pokemons.size() - 1;
  }

  /**
   * Récupère un Pokémon par son identifiant.
   * 
   * @param id L'identifiant du Pokémon.
   * @return Le Pokémon correspondant à l'identifiant donné.
   * @throws PokedexException Si l'identifiant est invalide.
   */
  @Override
  public Pokemon getPokemon(int id) throws PokedexException {
    if (id < 0 || id >= pokemons.size()) {
      throw new PokedexException("Invalid Pokémon ID.");
    }
    return pokemons.get(id);
  }

  /**
   * Récupère la liste des Pokémon dans le Pokédex.
   * 
   * @return La liste des Pokémon.
   */
  @Override
  public List<Pokemon> getPokemons() {
    return Collections.unmodifiableList(pokemons);
  }

  /**
   * Récupère la liste des Pokémon triée selon un critère donné.
   * 
   * @param order Le comparateur à utiliser pour trier les Pokémon.
   * @return La liste triée des Pokémon.
   */
  @Override
  public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
    List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
    sortedPokemons.sort(order);
    return Collections.unmodifiableList(sortedPokemons);
  }

  /**
   * Récupère les métadonnées d'un Pokémon à partir de son index.
   * 
   * @param index L'index du Pokémon pour lequel récupérer les métadonnées.
   * @return Les métadonnées du Pokémon.
   * @throws PokedexException Si l'index est invalide ou si un problème survient lors
   *                           de la récupération des métadonnées.
   */
  @Override
  public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
    return metadataProvider.getPokemonMetadata(index);
  }

  /**
   * Crée un Pokémon avec des statistiques données.
   * 
   * @param index L'index du Pokémon à créer.
   * @param cp Le CP (combat power) du Pokémon.
   * @param hp Le HP (health points) du Pokémon.
   * @param dust La quantité de poussière nécessaire pour créer le Pokémon.
   * @param candy Le nombre de bonbons nécessaires pour créer le Pokémon.
   * @return Le Pokémon créé, ou {@code null} si les paramètres sont invalides.
   */
  @Override
  public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
    return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
  }
}
