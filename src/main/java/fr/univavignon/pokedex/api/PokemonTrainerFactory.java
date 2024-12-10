package fr.univavignon.pokedex.api;


/**
 * Factory permettant de créer des instances de {@link PokemonTrainer}.
 * La classe implémente l'interface {@link IPokemonTrainerFactory} et est responsable
 * de la création d'un Pokémon entraîneur avec son équipe et son Pokédex associé.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

  /**
   * Crée un entraîneur de Pokémon avec le nom, l'équipe et un Pokédex créé.
   */
  @Override
  public PokemonTrainer createTrainer(String name, Team team,
      IPokedexFactory pokedexFactory) {
    if (name == null || name.isEmpty() || team == null
        || pokedexFactory == null) {
      return null;
    }
    
    IPokedex pokedex = pokedexFactory.createPokedex(
        new PokemonMetadataProvider(),
        new PokemonFactory(new PokemonMetadataProvider()));

    return new PokemonTrainer(name, team, pokedex);
  }
}
