package fr.univavignon.pokedex.api;

/**
 * Factory permettant de créer des instances de {@link Pokemon}.
 */
public class PokemonFactory implements IPokemonFactory {

  private final IPokemonMetadataProvider metadataProvider;

  /**
   * Constructeur qui initialise le fournisseur de métadonnées.
   * 
   * @param metadataProvider Le fournisseur de métadonnées pour les Pokémon.
   */
  public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
    this.metadataProvider = metadataProvider;
  }

  /**
   * Crée un Pokémon avec les caractéristiques associées
   * pour le Pokémon d'un index donné.
   * 
   * @param index L'index du Pokémon à créer. L'index doit être compris entre 0 et 149 inclus.
   * @param cp Les points de combat (CP) du Pokémon.
   * @param hp Les points de vie (HP) du Pokémon.
   * @param dust La quantité de poussière nécessaire pour le Pokémon.
   * @param candy Le nombre de bonbons nécessaires pour le Pokémon.
   * @return Un objet {@link Pokemon} avec les caractéristiques spécifiées, ou {@code null}
   *         si l'index est invalide ou si des paramètres sont incorrects.
   */
  @Override
  public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
    if (index < 0 || index >= 150) {
      System.err.println(index);
      return null;
    }

    if (cp < 0 || hp < 0 || dust < 0 || candy < 0) {
      return null;
    }

    try {
      PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

      int attack = Math.min(metadata.getAttack(), 141);
      int defense = Math.min(metadata.getDefense(), 141);
      int stamina = Math.min(metadata.getStamina(), 105);

      return new Pokemon(index, metadata.getName(), attack, defense, stamina,
          cp, hp, dust, candy, 50);

    } catch (PokedexException e) {
      System.err.println(e.getMessage());
      return null;
    }
  }
}
