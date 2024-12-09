package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

  @Test
  public void testCreateTrainer_ValidValuesMystic() {

    String name = "Ash";
    Team trainerTeam = Team.MYSTIC;

    IPokedex mockPokedex = Mockito.mock(IPokedex.class);
    IPokedexFactory mockPokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokemonTrainerFactory mockTrainerFactory = Mockito
        .mock(IPokemonTrainerFactory.class);

    PokemonTrainer Trainer = new PokemonTrainer(name, trainerTeam, mockPokedex);

    Mockito.when(
        mockTrainerFactory.createTrainer(name, trainerTeam, mockPokedexFactory))
        .thenReturn(Trainer);

    PokemonTrainer createdTrainer = mockTrainerFactory.createTrainer(name,
        trainerTeam, mockPokedexFactory);

    Mockito.verify(mockTrainerFactory).createTrainer(name, trainerTeam,
        mockPokedexFactory);

    assertNotNull(createdTrainer);
    assertEquals(name, createdTrainer.getName());
    assertEquals(trainerTeam, createdTrainer.getTeam());
    assertEquals(mockPokedex, createdTrainer.getPokedex());
  }

  @Test
  public void testCreateTrainer_ValidValuesInstinct() {

    String name = "Ash";
    Team trainerTeam = Team.INSTINCT;

    IPokedex mockPokedex = Mockito.mock(IPokedex.class);
    IPokedexFactory mockPokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokemonTrainerFactory mockTrainerFactory = Mockito
        .mock(IPokemonTrainerFactory.class);

    PokemonTrainer Trainer = new PokemonTrainer(name, trainerTeam, mockPokedex);

    Mockito.when(
        mockTrainerFactory.createTrainer(name, trainerTeam, mockPokedexFactory))
        .thenReturn(Trainer);

    PokemonTrainer createdTrainer = mockTrainerFactory.createTrainer(name,
        trainerTeam, mockPokedexFactory);

    Mockito.verify(mockTrainerFactory).createTrainer(name, trainerTeam,
        mockPokedexFactory);

    assertNotNull(createdTrainer);
    assertEquals(name, createdTrainer.getName());
    assertEquals(trainerTeam, createdTrainer.getTeam());
    assertEquals(mockPokedex, createdTrainer.getPokedex());
  }

  @Test
  public void testCreateTrainer_ValidValuesValor() {

    String name = "Ash";
    Team trainerTeam = Team.VALOR;

    IPokedex mockPokedex = Mockito.mock(IPokedex.class);
    IPokedexFactory mockPokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokemonTrainerFactory mockTrainerFactory = Mockito
        .mock(IPokemonTrainerFactory.class);

    PokemonTrainer Trainer = new PokemonTrainer(name, trainerTeam, mockPokedex);

    Mockito.when(
        mockTrainerFactory.createTrainer(name, trainerTeam, mockPokedexFactory))
        .thenReturn(Trainer);

    PokemonTrainer createdTrainer = mockTrainerFactory.createTrainer(name,
        trainerTeam, mockPokedexFactory);

    Mockito.verify(mockTrainerFactory).createTrainer(name, trainerTeam,
        mockPokedexFactory);

    assertNotNull(createdTrainer);
    assertEquals(name, createdTrainer.getName());
    assertEquals(trainerTeam, createdTrainer.getTeam());
    assertEquals(mockPokedex, createdTrainer.getPokedex());
  }

  @Test
  public void testCreateTrainer_NullName() {

    Team trainerTeam = Team.MYSTIC;
    IPokedexFactory mockPokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokemonTrainerFactory mockTrainerFactory = Mockito
        .mock(IPokemonTrainerFactory.class);

    Mockito.when(
        mockTrainerFactory.createTrainer(null, trainerTeam, mockPokedexFactory))
        .thenReturn(null);

    PokemonTrainer Trainer = mockTrainerFactory.createTrainer(null, trainerTeam,
        mockPokedexFactory);

    Mockito.verify(mockTrainerFactory).createTrainer(null, trainerTeam,
        mockPokedexFactory);

    assertNull(Trainer);

  }

  @Test
  public void testCreateTrainer_EmptyName() {

    String name = "";
    Team trainerTeam = Team.MYSTIC;
    IPokedexFactory mockPokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokemonTrainerFactory mockTrainerFactory = Mockito
        .mock(IPokemonTrainerFactory.class);

    Mockito.when(
        mockTrainerFactory.createTrainer(name, trainerTeam, mockPokedexFactory))
        .thenReturn(null);

    PokemonTrainer Trainer = mockTrainerFactory.createTrainer(name, trainerTeam,
        mockPokedexFactory);

    Mockito.verify(mockTrainerFactory).createTrainer(name, trainerTeam,
        mockPokedexFactory);

    assertNull(Trainer);

  }

  @Test
  public void testCreateTrainer_NullPokedexFactory() {

    String name = "Ash";
    Team trainerTeam = Team.MYSTIC;
    IPokemonTrainerFactory mockTrainerFactory = Mockito
        .mock(IPokemonTrainerFactory.class);

    Mockito.when(mockTrainerFactory.createTrainer(name, trainerTeam, null))
        .thenReturn(null);

    PokemonTrainer Trainer = mockTrainerFactory.createTrainer(name, trainerTeam,
        null);

    Mockito.verify(mockTrainerFactory).createTrainer(name, trainerTeam, null);

    assertNull(Trainer);
  }

  @Test
  public void testCreateTrainer_NullTeam() {

    String name = "Ash";
    Team trainerTeam = null;
    IPokemonTrainerFactory mockTrainerFactory = Mockito
        .mock(IPokemonTrainerFactory.class);
    IPokedexFactory mockPokedexFactory = Mockito.mock(IPokedexFactory.class);

    Mockito.when(
        mockTrainerFactory.createTrainer(name, trainerTeam, mockPokedexFactory))
        .thenReturn(null);

    PokemonTrainer Trainer = mockTrainerFactory.createTrainer(name, trainerTeam,
        null);

    Mockito.verify(mockTrainerFactory).createTrainer(name, trainerTeam, null);

    assertNull(Trainer);
  }

  // Implémentation de la classe

  @Test
  public void testCreateTrainer_ValidValuesMystic_Implementation() {
    String name = "Ash";
    Team trainerTeam = Team.MYSTIC;

    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

    PokemonTrainer createdTrainer = trainerFactory.createTrainer(name,
        trainerTeam, pokedexFactory);

    assertNotNull(createdTrainer);
    assertEquals(name, createdTrainer.getName());
    assertEquals(trainerTeam, createdTrainer.getTeam());
    assertNotNull(createdTrainer.getPokedex());
  }

  @Test
  public void testCreateTrainer_ValidValuesInstinct_Implementation() {
    String name = "Ash";
    Team trainerTeam = Team.INSTINCT;

    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

    PokemonTrainer createdTrainer = trainerFactory.createTrainer(name,
        trainerTeam, pokedexFactory);

    assertNotNull(createdTrainer);
    assertEquals(name, createdTrainer.getName());
    assertEquals(trainerTeam, createdTrainer.getTeam());
    assertNotNull(createdTrainer.getPokedex());
  }

  @Test
  public void testCreateTrainer_ValidValuesValor_Implementation() {
    String name = "Ash";
    Team trainerTeam = Team.VALOR;

    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

    PokemonTrainer createdTrainer = trainerFactory.createTrainer(name,
        trainerTeam, pokedexFactory);

    assertNotNull(createdTrainer);
    assertEquals(name, createdTrainer.getName());
    assertEquals(trainerTeam, createdTrainer.getTeam());
    assertNotNull(createdTrainer.getPokedex());
  }

  @Test
  public void testCreateTrainer_NullName_Implementation() {
    Team trainerTeam = Team.MYSTIC;

    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

    PokemonTrainer createdTrainer = trainerFactory.createTrainer(null,
        trainerTeam, pokedexFactory);

    assertNull(createdTrainer);
  }

  @Test
  public void testCreateTrainer_EmptyName_Implementation() {
    String name = "";
    Team trainerTeam = Team.MYSTIC;

    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

    PokemonTrainer createdTrainer = trainerFactory.createTrainer(name,
        trainerTeam, pokedexFactory);

    assertNull(createdTrainer);
  }

  @Test
  public void testCreateTrainer_NullPokedexFactory_Implementation() {
    String name = "Ash";
    Team trainerTeam = Team.MYSTIC;

    IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

    PokemonTrainer createdTrainer = trainerFactory.createTrainer(name,
        trainerTeam, null);

    assertNull(createdTrainer);
  }

  @Test
  public void testCreateTrainer_NullTeam_Implementation() {
    String name = "Ash";
    Team trainerTeam = null;

    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

    PokemonTrainer createdTrainer = trainerFactory.createTrainer(name,
        trainerTeam, pokedexFactory);

    assertNull(createdTrainer);
  }

}
