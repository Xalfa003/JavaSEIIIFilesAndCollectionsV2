package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GamesListTest {

    @Test
    public void testLoadGamesValidFile() {
        GamesList gameLoader = new GamesList();
        List<Game> games = gameLoader.loadGames("src/test/resources/games_valid.csv");

        assertNotNull(games);
        assertEquals(3, games.size());

        Game firstGame = games.get(0);
        assertEquals("Game 1", firstGame.getName());
        assertEquals(2020, firstGame.getYear());
        assertEquals("Action", firstGame.getGenre());
        assertEquals("Publisher A", firstGame.getPublisher());
    }

    @Test
    public void testLoadGamesWithInvalidYear() {
        GamesList gameLoader = new GamesList();
        List<Game> games = gameLoader.loadGames("src/test/resources/games_invalid_year.csv");

        assertNotNull(games);
        assertEquals(2, games.size());
    }

    @Test
    public void testLoadGamesEmptyFile() {
        GamesList gameLoader = new GamesList();
        List<Game> games = gameLoader.loadGames("src/test/resources/games_empty.csv");

        assertNotNull(games);
        assertEquals(0, games.size());
    }
}
