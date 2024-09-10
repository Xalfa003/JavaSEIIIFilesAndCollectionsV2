package org.example;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GameGenresTest {

    @Test
    public void testExportGenres() throws Exception {
        List<Game> games = new ArrayList<>();
        games.add(new Game("Game 1", 2020, "Action", "Publisher A"));
        games.add(new Game("Game 2", 2021, "Simulator", "Publisher B"));
        games.add(new Game("Game 3", 2022, "Action", "Publisher C"));

        GameGenres genreExporter = new GameGenres();
        genreExporter.exportGenres(games, "src/test/resources/game_gendres.txt");

        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/game_gendres.txt"));
        assertEquals(1, lines.size());
        assertEquals("Action,Simulator", lines.get(0));
    }
}
