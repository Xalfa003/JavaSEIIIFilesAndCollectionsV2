package org.example;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SimulatorGamesExporterTest {

    @Test
    public void testExportSimulatorGames() throws Exception {
        List<Game> games = new ArrayList<>();
        games.add(new Game("Sim Game 1", 2019, "Simulator", "Publisher A"));
        games.add(new Game("Sim Game 2", 2020, "Simulator", "Publisher B"));
        games.add(new Game("Action Game", 2021, "Action", "Publisher C"));

        SimulatorGamesExporter simulatorGamesExporter = new SimulatorGamesExporter();
        simulatorGamesExporter.exportSimulatorGames(games, "src/test/resources/simulator_games.csv");

        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/simulator_games.csv"));
        assertEquals(3, lines.size());

        assertEquals("Name,Year", lines.get(0));
        assertEquals("Sim Game 1,2019", lines.get(1));
        assertEquals("Sim Game 2,2020", lines.get(2));
    }
}
