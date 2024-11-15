package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {
    
    private final IPokemonMetadataProvider metadataProvider;

    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

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

            return new Pokemon(index, metadata.getName(), attack, defense, stamina, cp, hp, dust, candy, 50);

        } catch (PokedexException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
