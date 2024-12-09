package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

  /**
   * Factory permettant de créer des instances de {@link IPokedex}.
   */
  @Override
  public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider,
      IPokemonFactory pokemonFactory) {
    if (metadataProvider == null || pokemonFactory == null) {
      return null;
    }
    return new Pokedex(metadataProvider, pokemonFactory);
  }
}
